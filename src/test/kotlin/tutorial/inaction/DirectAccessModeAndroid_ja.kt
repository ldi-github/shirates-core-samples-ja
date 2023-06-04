package tutorial.inaction

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.DisableCache
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest
import shirates.core.utility.time.StopWatch

@Testrun("testConfig/android/設定/testrun.properties")
class DirectAccessModeAndroid_ja : UITest() {

    @Test
    @Order(10)
    fun enableCacheTest() {

//        enableCache()   // キャッシュモードがデフォルトの場合にはこの記述は不要です

        scenario {
            case(1) {
                condition {
                    it.screenIs("[Android設定トップ画面]")
                        .tap("[ネットワークとインターネット]")
                        .screenIs("[ネットワークとインターネット画面]")
                }.action {
                    it.tap("[インターネット]")
                }.expectation {
                    it.screenIs("[インターネット画面]")
                        .exist("[ネットワークを追加]")
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
                    it.screenIs("[Android設定トップ画面]")
                        .tap("[ネットワークとインターネット]")
                        .switchScreen("[ネットワークとインターネット画面]")
                }.action {
                    it.tap("[インターネット]")
                }.expectation {
                    it.switchScreen("[インターネット画面]")
                        .exist("[ネットワークを追加]")
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
                    it.screenIs("[Android設定トップ画面]")
                        .tap("[ネットワークとインターネット]")
                        .switchScreen("[ネットワークとインターネット画面]")
                }.action {
                    it.tap("[インターネット]")
                }.expectation {
                    it.switchScreen("[インターネット画面]")
                        .exist("[ネットワークを追加]")
                }
            }
        }
    }

    @Test
    @Order(40)
    fun suppressCacheTest() {

        scenario {
            case(1) {
                expectation {
                    it.exist("ネットワークとインターネット")  // キャッシュモード
                    suppressCache {
                        it.exist("ネットワークとインターネット")  // ダイレクトアクセスモード
                    }
                }
            }
        }
    }

    @Test
    @Order(50)
    fun performanceComparison() {

        fun process(count: Int) {
            val sw1 = StopWatch()
            val sw2 = StopWatch()
            invalidateCache()

            sw1.start()
            useCache {
                for (i in 1..count) {
                    it.select("ネットワークとインターネット")  // キャッシュモード
                }
            }
            sw1.stop()

            sw2.start()
            suppressCache {
                for (i in 1..count) {
                    it.select("ネットワークとインターネット")  // ダイレクトアクセスモード
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
}