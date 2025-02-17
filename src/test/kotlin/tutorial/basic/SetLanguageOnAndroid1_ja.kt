package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.behavior.LanguageHelperAndroid
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class SetLanguageOnAndroid1_ja : UITest() {

    @Test
    @Order(10)
    fun setLanguage_getLanguage_removeLanguage1() {

        scenario {
            case(1) {
                action {
                    LanguageHelperAndroid.setLanguageAndRegion(language = "English", region = "United States")
                }
            }
            case(2) {
                action {
                    LanguageHelperAndroid.setLanguageAndRegion(language = "日本語", region = "日本")
                }
            }
        }
    }

}