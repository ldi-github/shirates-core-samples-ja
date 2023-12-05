package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("testConfig/ios/設定/testrun.properties")
class ExistDontExistInCellIos_ja : UITest() {

    @Test
    @Order(10)
    fun exist_in_cell_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[言語と地域画面]")
                }.expectation {
                    it.cell(".XCUIElementTypeCell&&value=iPhoneの使用言語") {
                        exist("日本語")
                        exist("iPhoneの使用言語")
                    }
                }
            }
            case(2) {
                expectation {
                    it.cellOf("iPhoneの使用言語") {
                        exist("日本語")
                        exist("iPhoneの使用言語")
                    }
                }
            }
        }
    }

    @Test
    @Order(20)
    fun exist_in_cell_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[言語と地域画面]")
                }.expectation {
                    it.cellOf("iPhoneの使用言語") {
                        exist("日本語")
                        exist("ねこ")
                    }
                }
            }
        }
    }

    @Test
    @Order(30)
    fun dontExist_in_cell_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[言語と地域画面]")
                }.expectation {
                    it.cellOf("iPhoneの使用言語") {
                        dontExist("いぬ")
                    }
                }
            }
        }
    }

    @Test
    @Order(40)
    fun dontExist_in_cell_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[言語と地域画面]")
                }.expectation {
                    it.cellOf("iPhoneの使用言語") {
                        dontExist("日本語")
                    }
                }
            }
        }
    }
}