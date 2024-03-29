package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.driver.doUntilTrue
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class DoUntilTrue1_ja : UITest() {

    @Test
    @Order(10)
    fun doUntilTrue_action() {

        scenario {
            case(1) {
                condition {
                    it.terminateApp()
                    it.launchApp()
                    it.screenIs("[Android設定トップ画面]")
                }.action {
                    doUntilTrue {
                        it.swipeCenterToTop()
                        it.canSelect("システム")
                    }
                    it.tap()
                }.expectation {
                    it.screenIs("[システム画面]")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun doUntilTrue_onTimeout() {

        scenario {
            case(1) {
                condition {
                    it.terminateApp()
                    it.launchApp()
                    it.screenIs("[Android設定トップ画面]")
                }.action {
                    doUntilTrue(
                        waitSeconds = 3.0,
                        onTimeout = { c ->
                            SKIP_SCENARIO("Timeout. (waitSeconds=${c.waitSeconds})")
                        }
                    ) {
                        it.swipeCenterToTop()
                        it.canSelect("システム")
                    }
                    it.tap()
                }.expectation {
                    it.screenIs("[システム画面]")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun doUntilTrue_onMaxLoop() {

        scenario {
            case(1) {
                condition {
                    it.terminateApp()
                    it.launchApp()
                    it.screenIs("[Android設定トップ画面]")
                }.action {
                    doUntilTrue(
                        maxLoopCount = 2,
                        throwOnOverMaxLoopCount = false,
                        onMaxLoop = { c ->
                            SKIP_SCENARIO("MaxLoopCount. (maxLoopCount=${c.maxLoopCount})")
                        }
                    ) {
                        it.swipeCenterToTop()
                        it.canSelect("システム")
                    }
                    it.tap()
                }.expectation {
                    it.screenIs("[システム画面]")
                }
            }
        }
    }

    @Test
    @Order(40)
    fun doUntilTrue_onError() {

        scenario {
            case(1) {
                expectation {
                    doUntilTrue(
                        onError = { c ->
                            output("${c.error} (${c.count})")
                            c.cancelRetry = c.count >= 3
                        },
                    ) {
                        it.select("#no-exist", waitSeconds = 0.0)   // throws TestDriverException
                        false
                    }
                }
            }
            case(2) {
                expectation {
                    doUntilTrue(
                        onError = { c ->
                            output("${c.error} (${c.count})")
                            c.cancelRetry = true
                        }
                    ) {
                        it.select("#no-exist", waitSeconds = 0.0)   // throws TestDriverException
                        false
                    }
                }
            }
        }
    }

}