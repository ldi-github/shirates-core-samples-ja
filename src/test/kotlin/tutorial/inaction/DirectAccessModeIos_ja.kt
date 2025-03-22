package tutorial.inaction

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.DisableCache
import shirates.core.driver.commandextension.*
import shirates.core.driver.testContext
import shirates.core.testcode.Manual
import shirates.core.testcode.UITest
import shirates.core.utility.time.StopWatch

@Testrun("testConfig/ios/設定/testrun.properties")
class DirectAccessModeIos_ja : UITest() {

    @Test
    @Order(10)
    fun enableCacheTest() {

//        enableCache()   // キャッシュモードがデフォルトの場合にはこの記述は不要です

        scenario {
            case(1) {
                condition {
                    it.screenIs("[iOS設定トップ画面]")
                        .tap("[一般]")
                        .screenIs("[一般画面]")
                }.action {
                    it.tap("[情報]")
                }.expectation {
                    it.screenIs("[情報画面]")
                        .exist("[名前]")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun disableCacheTest() {

        disableCache()

        scenario {
            case(1) {
                condition {
                    it.switchScreen("[iOS設定トップ画面]")
                        .tap("[一般]")
                        .switchScreen("[一般画面]")
                }.action {
                    it.tap("[情報]")
                }.expectation {
                    it.switchScreen("[情報画面]")
                        .exist("[名前]")
                }
            }
        }
    }

    @Test
    @DisableCache
    @Order(30)
    fun disableCacheTest2() {

        scenario {
            case(1) {
                condition {
                    it.switchScreen("[iOS設定トップ画面]")
                        .tap("[一般]")
                        .switchScreen("[一般画面]")
                }.action {
                    it.tap("[情報]")
                }.expectation {
                    it.switchScreen("[情報画面]")
                        .exist("[名前]")
                }
            }
        }
    }

    @Manual
    @Test
    @Order(40)
    fun performanceComparison() {

        fun process(count: Int) {
            val sw1 = StopWatch("sw1")
            val sw2 = StopWatch("sw2")
            invalidateCache()

            sw1.start()
            useCache {
                for (i in 1..count) {
                    it.select("一般")  // キャッシュモード
                }
            }
            sw1.stop()

            sw2.start()
            suppressCache {
                for (i in 1..count) {
                    it.select("一般")  // ダイレクトアクセスモード
                }
            }
            sw2.stop()

            output("$count 要素数")
            output("$sw1 キャッシュモード")
            output("$sw2 ダイレクトアクセスモード")
        }

        scenario {
            case(1) {
                expectation {
                    process(1)
                }
            }
            case(2) {
                expectation {
                    process(5)
                }
            }
            case(3) {
                expectation {
                    process(10)
                }
            }
            case(4) {
                expectation {
                    process(50)
                }
            }
        }
    }

    @Test
    @Order(50)
    fun useCacheArgument() {

        // 以下の関数には 引数useCache を指定することができます

        printUseCache("testMethod")

        scenario(useCache = true) {
            printUseCache("scenario")

            case(1, useCache = false) {
                printUseCache("case")

                condition(useCache = true) {
                    printUseCache("condition")

                }.action(useCache = false) {
                    printUseCache("action")

                }.expectation(useCache = true) {
                    printUseCache("expectation")

                }
            }
        }
    }

    private fun printUseCache(funcName: String) {

        println("($funcName) testContext.useCache=${testContext.useCache}")
    }
}