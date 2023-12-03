package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class AirplaneMode1_ja : UITest() {

    @Test
    @Order(10)
    fun airplaneMode() {

        scenario {
            case(1) {
                action {
                    it.macro("[機内モードON]")
                        .flickTopToBottom(startMarginRatio = 0.0)
                }.expectation {
                    it.select("@機内モード")
                        .checkIsON()
                }
            }

            case(2) {
                action {
                    it.macro("[機内モードOFF]")
                        .flickTopToBottom(startMarginRatio = 0.0)
                }.expectation {
                    it.select("@機内モード")
                        .checkIsOFF()
                }
            }
        }
    }

}