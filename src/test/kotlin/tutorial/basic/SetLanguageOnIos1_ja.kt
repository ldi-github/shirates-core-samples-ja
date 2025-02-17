package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.behavior.LanguageHelper
import shirates.core.testcode.UITest

@Testrun("testConfig/ios/設定/testrun.properties")
class SetLanguageOnIos1_ja : UITest() {

    @Test
    @Order(10)
    fun setLanguage1() {

        scenario {
            case(1) {
                action {
                    LanguageHelper.setLanguageAndLocale(language = "en", locale = "US")
                }
            }
            case(2) {
                action {
                    LanguageHelper.setLanguageAndLocale(language = "ja", locale = "JP")
                }
            }
        }
    }

}