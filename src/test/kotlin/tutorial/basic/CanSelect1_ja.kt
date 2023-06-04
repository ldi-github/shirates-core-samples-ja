package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class CanSelect1_ja : UITest() {

    @Test
    @Order(10)
    fun canSelect() {

        scenario {
            case(1) {
                action {
                    it.canSelect("設定", log = true)
                }
            }
            case(2) {
                action {
                    it.canSelectWithScrollDown("システム", log = true)
                }
            }
            case(3) {
                action {
                    it.canSelectWithScrollUp("設定", log = true)
                }
            }
            case(4) {
                action {
                    it.canSelectAllWithScrollDown("設定", "システム", log = true)
                }
            }
            case(5) {
                action {
                    it.canSelectAllWithScrollUp("設定", "システム", log = true)
                }
            }
        }
    }

    @Test
    @Order(20)
    fun canSelectInScanElements() {

        scenario {
            case(1) {
                condition {
                    it.scanElements()
                }.action {
                    it.canSelectInScanResults("設定", log = true)
                    it.canSelectInScanResults("ユーザー補助", log = true)
                    it.canSelectInScanResults("システム", log = true)
                    it.canSelectInScanResults("ほげ", log = true)
                }
            }
            case(2) {
                action {
                    it.canSelectAllInScanResults("設定", "ユーザー補助", "システム", log = true)
                    it.canSelectAllInScanResults("設定", "ユーザー補助", "ほげ", log = true)
                }
            }
        }
    }

    @Test
    @Order(30)
    fun canSelect_true() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.canSelect("ネットワークとインターネット")
                        .thisIsTrue(message = "canSelect(\"ネットワークとインターネット\") は true です")
                }
            }
        }
    }

    @Test
    @Order(40)
    fun canSelect_false() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.canSelect("ネットワークビジネス")
                        .thisIsFalse("canSelect(\"ネットワークビジネス\") は false です")
                }
            }
        }
    }

    @Test
    @Order(50)
    fun canSelectWithScrollDown_true() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.canSelectWithScrollDown("システム")
                        .thisIsTrue("canSelectWithScrollDown(\"システム\") は true です")
                }
            }
        }
    }

    @Test
    @Order(60)
    fun canSelectWithScrollDown_false() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.canSelectWithScrollDown("ネットワークビジネス")
                        .thisIsFalse("canSelectWithScrollDown(\"ネットワークビジネス\") は false です")
                }
            }
        }
    }

    @Test
    @Order(70)
    fun canSelectWithScrollUp_true() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .flickBottomToTop()
                }.expectation {
                    it.canSelectWithScrollUp("ネットワークとインターネット")
                        .thisIsTrue("canSelectWithScrollUp(\"ネットワークとインターネット\") は true です")
                }
            }
        }
    }

    @Test
    @Order(80)
    fun canSelectWithScrollUp_false() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .flickBottomToTop()
                }.expectation {
                    it.canSelectWithScrollUp("ネットワークビジネス")
                        .thisIsFalse("canSelectWithScrollUp(\"ネットワークビジネス\") は false です")
                }
            }
        }
    }

    @Test
    @Order(90)
    fun canSelectInScanResults_true() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .scanElements()
                }.expectation {
                    it.canSelectInScanResults("ネットワークとインターネット")
                        .thisIsTrue("canSelectInScanResults(\"ネットワークとインターネット\") は true です")
                }
            }
        }
    }

    @Test
    @Order(100)
    fun canSelectInScanResults_false() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .scanElements()
                }.expectation {
                    it.canSelectInScanResults("ネットワークビジネス")
                        .thisIsFalse("canSelectInScanResults(\"ネットワークビジネス\") は false です")
                }
            }
        }
    }


}