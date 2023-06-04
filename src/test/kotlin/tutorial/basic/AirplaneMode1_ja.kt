package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.flickTopToBottom
import shirates.core.driver.commandextension.macro
import shirates.core.driver.commandextension.select
import shirates.core.driver.commandextension.textIs
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
                        .flickTopToBottom(startMarginRatio = 0.0, safeMode = false)
                }.expectation {
                    it.select("@インターネット*")
                        .textIs("OFF")
                }
            }

            case(2) {
                action {
                    it.macro("[機内モードOFF]")
                        .flickTopToBottom(startMarginRatio = 0.0, safeMode = false)
                }.expectation {
                    it.select("@インターネット*")
                        .textIs("ON")
                }
            }
        }
    }

}