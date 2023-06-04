package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class AssertingOthers1_ja : UITest() {

    @Test
    @Order(10)
    fun appIs_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.appIs("設定")
                }
            }

            case(2) {
                condition {
                    it.launchApp("Chrome")
                }.expectation {
                    val isApp = it.isApp("Chrome")
                    output("isApp(\"Chrome\")=$isApp")
                    it.appIs("Chrome")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun appIs_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.appIs("Chrome")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun keyboardIsShown_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    output("isKeyboardShown=$isKeyboardShown")
                    it.keyboardIsNotShown()
                }
            }

            case(2) {
                action {
                    it.tap("[設定を検索]")
                }.expectation {
                    it.keyboardIsShown()
                }
            }
        }
    }

    @Test
    @Order(40)
    fun keyboardIsShown_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.keyboardIsNotShown()
                        .keyboardIsShown()
                }
            }
        }
    }

    @Test
    @Order(50)
    fun packageIs_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.packageIs("com.android.settings")
                }
            }

            case(2) {
                action {
                    it.launchApp("Chrome")
                }.expectation {
                    it.packageIs("com.android.chrome")
                }
            }
        }
    }

    @Test
    @Order(60)
    fun packageIs_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.packageIs("com.android.chrome")
                }
            }
        }
    }

}