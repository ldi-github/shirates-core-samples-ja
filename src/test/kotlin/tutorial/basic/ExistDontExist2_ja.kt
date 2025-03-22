package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtensionContext
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.dontExistImage
import shirates.core.driver.commandextension.existImage
import shirates.core.driver.commandextension.macro
import shirates.core.driver.commandextension.tap
import shirates.core.testcode.UITest
import shirates.helper.ImageSetupHelper

@Testrun("testConfig/android/マップ/testrun.properties")
class ExistDontExist2_ja : UITest() {

    override fun beforeAllAfterSetup(context: ExtensionContext?) {
        ImageSetupHelper.SetupImagesMapsTopScreen()
    }

    @Test
    @Order(10)
    fun existImage_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[マップトップ画面]")
                }.expectation {
                    it
                        .existImage("[スポットタブ(選択状態)]")
                        .dontExistImage("[スポットタブ]")

                        .existImage("[投稿タブ]")
                        .dontExistImage("[投稿タブ(選択状態)]")
                }
            }
        }

    }

    @Test
    @Order(20)
    fun existImage_WARN_COND_AUTO() {

        scenario {
            case(1) {
                condition {
                    it.macro("[マップトップ画面]")
                        .tap("投稿")
                }.expectation {
                    it.existImage("[投稿タブ(選択状態)]")   // WARN & COND_AUTO
                }
            }
        }
    }

    @Test
    @Order(30)
    fun dontExistImage_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[マップトップ画面]")
                }.expectation {
                    it.dontExistImage("[スポットタブ]")     // OK
                }
            }
        }
    }

    @Test
    @Order(40)
    fun dontExistImage_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[マップトップ画面]")
                }.expectation {
                    it.dontExistImage("[スポットタブ(選択状態)]") // NG
                }
            }
        }
    }

}