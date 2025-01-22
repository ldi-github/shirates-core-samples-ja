package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class AssertingAttribute1_ja : UITest() {

    @Test
    @Order(10)
    fun textAssertion_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.select("ネットワークとインターネット")
                }.expectation {
                    it
                        .textIs("ネットワークとインターネット")
                        .textIsNot("通知")

                        .textStartsWith("ネットワークと")
                        .textStartsWithNot("接続済みの")

                        .textContains("ワークとインタ")
                        .textContainsNot("デバイス")

                        .textEndsWith("とインターネット")
                        .textEndsWithNot("デバイス")

                        .textMatches("^ネット.*")
                        .textMatchesNot("^接続済み.*")

                        .textIsNotEmpty()
                }
            }
            case(2) {
                action {
                    it.select("#account_avatar")
                }.expectation {
                    it.textIsEmpty()
                }
            }
        }
    }

    @Test
    @Order(20)
    fun textAssertion_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.select("ネットワークとインターネット")
                }.expectation {
                    it.textIs("接続済みのデバイス")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun idAssertion_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.select("#account_avatar")
                }.expectation {
                    it
                        .idIs("account_avatar")
                        .idIs("com.android.settings:id/account_avatar")
                }
            }
        }
    }

    @Test
    @Order(40)
    fun idAssertion_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.select("#account_avatar")
                }.expectation {
                    it
                        // OK. expected is converted to "com.android.settings:id/account_avatar"
                        .idIs("account_avatar")

                        // OK. expected is converted to "com.android.settings:id/account_avatar"
                        .idIs("account_avatar", auto = true)

                        // NG. expected is "account_avatar"
                        .idIs("account_avatar", auto = false)
                }
            }
        }
    }

    @Test
    @Order(50)
    fun accessAssertion_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[ネットワークとインターネット画面]")
                }.action {
                    it.select("@ネットワークとインターネット")
                }.expectation {
                    it.accessIs("ネットワークとインターネット")
                        .accessIsNot("システム")
                }
            }
        }
    }

    @Test
    @Order(60)
    fun accessAssertion_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[ネットワークとインターネット画面]")
                }.action {
                    it.select("@ネットワークとインターネット")
                }.expectation {
                    it.accessIs("接続済みのデバイス")
                }
            }
        }
    }

    @Test
    @Order(70)
    fun classNameAssertion_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.select("#account_avatar")
                }.expectation {
                    it.classIs("android.widget.ImageView")
                        .classIsNot("android.widget.TextView")
                }
            }
        }
    }

    @Test
    @Order(80)
    fun classNameAssertion_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.select("#account_avatar")
                }.expectation {
                    it.classIs("android.widget.TextView")
                }
            }
        }
    }

    @Test
    @Order(90)
    fun attributeAssertion_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.select("#account_avatar")
                }.expectation {
                    it.attributeIs("package", "com.android.settings")
                }
            }
        }
    }

    @Test
    @Order(100)
    fun attributeAssertion_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.select("#account_avatar")
                }.expectation {
                    it.attributeIs("package", "com.google.android.calculator")
                }
            }
        }
    }
}