package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class ExistDontExistInCellAndroid_ja : UITest() {

    @Test
    @Order(10)
    fun exist_in_cellOf_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.cell("<ネットワークとインターネット>:ancestor(2)") {
                        exist("ネットワークとインターネット")
                        exist("モバイル、Wi-Fi、アクセス ポイント")
                    }
                    it.cell("<接続済みのデバイス>:ancestor(2)") {
                        exist("接続済みのデバイス")
                        exist("Bluetooth、ペア設定")
                    }
                }
            }
            case(2) {
                expectation {
                    it.cellOf("ネットワークとインターネット") {
                        exist("ネットワークとインターネット")
                        exist("モバイル、Wi-Fi、アクセス ポイント")
                    }
                    it.cellOf("接続済みのデバイス") {
                        exist("接続済みのデバイス")
                        exist("Bluetooth、ペア設定")
                    }
                }
            }
        }
    }

    @Test
    @Order(20)
    fun exist_in_cellOf_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.cellOf("ネットワークとインターネット") {
                        exist("ネットワークとインターネット")
                        exist("ねこ")
                    }
                }
            }
        }
    }

    @Test
    @Order(30)
    fun dontExist_in_cellOf_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.cellOf("ネットワークとインターネット") {
                        exist("ネットワークとインターネット")
                        dontExist("ねこ")
                    }
                    it.cellOf("接続済みのデバイス") {
                        exist("接続済みのデバイス")
                        dontExist("いぬ")
                    }
                }
            }
        }
    }

    @Test
    @Order(40)
    fun dontExist_in_cellOf_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.cellOf("ネットワークとインターネット") {
                        dontExist("ネットワークとインターネット")
                    }
                }
            }
        }
    }

}