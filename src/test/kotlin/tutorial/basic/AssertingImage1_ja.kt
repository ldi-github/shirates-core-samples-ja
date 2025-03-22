package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest
import shirates.helper.ImageSetupHelper

@Testrun("testConfig/android/マップ/testrun.properties")
class AssertingImage1_ja : UITest() {

    @Test
    @Order(0)
    fun setupImage() {

        scenario {
            ImageSetupHelper.SetupImagesMapsTopScreen()
        }
    }

    @Test
    @Order(10)
    fun imageIs_isImage_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[マップトップ画面]")
                }.expectation {
                    it.select("[スポットタブ]").imageIs("[スポットタブ(選択状態)]")     // OK
                    it.select("[スポットタブ]").isImage("[スポットタブ(選択状態)]").thisIsTrue()      // OK
                }
            }
        }
    }

    @Test
    @Order(20)
    fun imageIs_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[マップトップ画面]")
                }.expectation {
                    it.select("[投稿タブ]").imageIs("[投稿タブ(選択状態)]")     // NG
                }
            }
        }
    }

    @Test
    @Order(30)
    fun checkingTabState() {

        scenario {
            case(1) {
                condition {
                    it.macro("[マップトップ画面]")
                }.expectation {
                    it.select("[スポットタブ]").imageIs("[スポットタブ(選択状態)]")
                    it.select("[投稿タブ]").imageIs("[投稿タブ]")
                }
            }
            case(2) {
                action {
                    it.tap("[投稿タブ]")
                }.expectation {
                    it.select("[スポットタブ]").imageIs("[スポットタブ]")
                    it.select("[投稿タブ]").imageIs("[投稿タブ(選択状態)]")
                }
            }
        }
    }

}