package tutorial.basic

import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.appIs
import shirates.core.driver.commandextension.launchApp
import shirates.core.driver.commandextension.terminateApp
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class LaunchApp1_ja : UITest() {

    @Test
    fun launchApp() {

        scenario {
            case(1) {
                condition {
                    it.terminateApp()   // testConfig.json の packageOrBundleId を参照
                }.action {
                    it.launchApp()  // testConfig.json の packageOrBundleId を参照
                }.expectation {
                    it.appIs("[設定]")  // app.json の App Nickname を参照
                    it.appIs("設定")    // app.json の App Nickname を参照
                    it.appIs("com.android.settings")    // パッケージ
                }
            }
            case(2) {
                condition {
                    it.terminateApp("[Chrome]")     // app.json の App Nickname を参照
                }.action {
                    it.launchApp("[Chrome]")
                }.expectation {
                    it.appIs("[Chrome]")
                }
            }
            case(3) {
                condition {
                    it.terminateApp("com.android.chrome")   // パッケージ
                }.action {
                    it.launchApp("com.android.chrome")
                }.expectation {
                    it.appIs("com.android.chrome")
                }
            }
            case(4) {
                condition {
                    it.terminateApp("Chrome")   // app.json の App Nickname を参照
                }.action {
                    it.launchApp("Chrome")
                }.expectation {
                    it.appIs("Chrome")
                }
            }
            case(5) {
                condition {
                    it.terminateApp("[Play ストア]")     // app.json の App Nickname を参照
                }.action {
                    it.launchApp("[Play ストア]")
                }.expectation {
                    it.appIs("[Play ストア]")
                }
            }
        }
    }

}