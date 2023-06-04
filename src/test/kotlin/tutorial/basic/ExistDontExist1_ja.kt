package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class ExistDontExist1_ja : UITest() {

    @Test
    @Order(10)
    fun exist_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.exist("ネットワークとインターネット")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun exist_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.exist("システム")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun existWithScrollDown_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.existWithScrollDown("システム")
                }
            }
        }
    }

    @Test
    @Order(40)
    fun existWithScrollDown_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.existWithScrollDown("ネットワークビジネス")
                }
            }
        }
    }

    @Test
    @Order(50)
    fun existWithScrollUp_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .flickBottomToTop()
                }.expectation {
                    it.existWithScrollUp("ネットワークとインターネット")
                }
            }
        }
    }

    @Test
    @Order(60)
    fun existWithScrollUp_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .flickBottomToTop()
                }.expectation {
                    it.existWithScrollUp("ネットワークビジネス")
                }
            }
        }
    }

    @Test
    @Order(70)
    fun existInScanResult_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    describe("下方向へスクロールして要素をスキャンする")
                        .scanElements()
                }.expectation {
                    describe("期待した要素がスキャン結果に存在すること")
                        .existInScanResults("ネットワークとインターネット")
                        .existInScanResults("ストレージ")
                        .existInScanResults("システム")
                }
            }
        }
    }

    @Test
    @Order(80)
    fun existInScanResult_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.condition {
                    describe("下方向へスクロールして要素をスキャンする")
                        .scanElements()
                }.expectation {
                    it.existInScanResults("ネットワークとインターネット")
                        .existInScanResults("ストレージ")
                        .existInScanResults("システム")
                        .existInScanResults("ネットワークビジネス")
                }
            }
        }
    }

    @Test
    @Order(90)
    fun dontExist_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.dontExist("システム")
                }
            }
        }
    }

    @Test
    @Order(100)
    fun dontExist_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.dontExist("ネットワークとインターネット")
                }
            }
        }
    }

    @Test
    @Order(110)
    fun dontExistWithScrollDown_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.dontExistWithScrollDown("ネットワークビジネス")
                }
            }
        }
    }

    @Test
    @Order(120)
    fun dontExistWithScrollDown_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.dontExistWithScrollDown("システム")
                }
            }
        }
    }

    @Test
    @Order(130)
    fun dontExistWithScrollUp_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.condition {
                    it.flickBottomToTop()
                }.expectation {
                    it.dontExistWithScrollUp("ネットワークビジネス")
                }
            }
        }
    }

    @Test
    @Order(140)
    fun dontExistWithScrollUp_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.condition {
                    it.flickBottomToTop()
                }.expectation {
                    it.dontExistWithScrollUp("システム")
                }
            }
        }
    }

    @Test
    @Order(150)
    fun dontExistInScanResults_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.condition {
                    it.scanElements()
                }.expectation {
                    it.dontExistInScanResults("Switch")
                        .dontExistInScanResults("PS5")
                        .dontExistInScanResults("XBOX")
                }
            }
        }
    }

    @Test
    @Order(160)
    fun dontExistInScanResults_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.condition {
                    it.scanElements()
                }.expectation {
                    it.dontExistInScanResults("Switch")
                        .dontExistInScanResults("PS5")
                        .dontExistInScanResults("XBOX")
                        .dontExistInScanResults("ネットワークとインターネット")
                }
            }
        }
    }

}