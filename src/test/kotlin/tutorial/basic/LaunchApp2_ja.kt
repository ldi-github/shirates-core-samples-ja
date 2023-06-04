package tutorial.basic

import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.appIs
import shirates.core.driver.commandextension.launchApp
import shirates.core.driver.commandextension.terminateApp
import shirates.core.testcode.UITest

@Testrun("testConfig/ios/設定/testrun.properties")
class LaunchApp2_ja : UITest() {

    @Test
    fun launchApp() {

        scenario {
            case(1) {
                condition {
                    it.terminateApp()
                }.action {
                    it.launchApp()
                }.expectation {
                    it.appIs("設定")
                }
            }
            case(2) {
                condition {
                    it.terminateApp("[Safari]")
                }.action {
                    it.launchApp("[Safari]")
                }.expectation {
                    it.appIs("[Safari]")
                }
            }
            case(3) {
                condition {
                    it.terminateApp("com.apple.mobilesafari")
                }.action {
                    it.launchApp("com.apple.mobilesafari")
                }.expectation {
                    it.appIs("com.apple.mobilesafari")
                }
            }
            case(4) {
                condition {
                    it.terminateApp("Safari")
                }.action {
                    it.launchApp("Safari")
                }.expectation {
                    it.appIs("Safari")
                }
            }
            case(5) {
                condition {
                    it.terminateApp("[フリーボード]")
                }.action {
                    it.launchApp("[フリーボード]")
                }.expectation {
                    it.appIs("[フリーボード]")
                }
            }
        }
    }

}