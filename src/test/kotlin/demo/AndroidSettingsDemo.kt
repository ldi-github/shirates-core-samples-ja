package demo

import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class AndroidSettingsDemo : UITest() {

    @Test
    fun airplaneModeSwitch() {

        scenario {
            case(1) {
                condition {
                    it.launchApp("設定")
                        .screenIs("[Android設定トップ画面]")
                }.action {
                    it.tap("[ネットワークとインターネット]")
                }.expectation {
                    it.screenIs("[ネットワークとインターネット画面]")
                }
            }
            case(2) {
                condition {
                    it.select("{機内モードスイッチ}")
                        .checkIsOFF()
                }.action {
                    it.tap("{機内モードスイッチ}")
                }.expectation {
                    it.select("{機内モードスイッチ}")
                        .checkIsON()
                }
            }
            case(3) {
                action {
                    it.tap("{機内モードスイッチ}")
                }.expectation {
                    it.select("{機内モードスイッチ}")
                        .checkIsOFF()
                }
            }
        }
    }
}