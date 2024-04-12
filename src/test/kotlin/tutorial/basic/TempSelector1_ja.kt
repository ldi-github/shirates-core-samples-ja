package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.macro
import shirates.core.driver.commandextension.screenIs
import shirates.core.driver.commandextension.tap
import shirates.core.driver.commandextension.tempSelector
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class TempSelector1_ja : UITest() {

    @Test
    @Order(10)
    fun tempSelector() {

        tempSelector("[最初のアイテム]", "ネットワークとインターネット")

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.tap("[最初のアイテム]")
                }.expectation {
                    it.screenIs("[ネットワークとインターネット画面]")
                }
            }
        }
    }

}