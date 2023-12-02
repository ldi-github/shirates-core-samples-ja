package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.dontExistImage
import shirates.core.driver.commandextension.existImage
import shirates.core.driver.commandextension.macro
import shirates.core.testcode.UITest
import shirates.helper.ImageSetupHelper

@Testrun("testConfig/android/マップ/testrun.properties")
class ExistDontExist2_ja : UITest() {

    @Test
    @Order(0)
    fun setupImage() {

        scenario {
            ImageSetupHelper.SetupImagesMapsTopScreen()
        }
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

                        .existImage("[経路タブ]")
                        .dontExistImage("[経路タブ(選択状態)]")

                        .existImage("[保存済みタブ]")
                        .dontExistImage("[保存済みタブ(選択状態)]")

                        .existImage("[投稿タブ]")
                        .dontExistImage("[投稿タブ(選択状態)]")

                        .existImage("[お知らせタブ]")
                        .dontExistImage("[お知らせタブ(選択状態)]")
                }
            }
        }

    }

    @Test
    @Order(20)
    fun existImage_WARN() {

        scenario {
            case(1) {
                condition {
                    it.macro("[マップトップ画面]")
                }.expectation {
                    it.existImage("[スポットタブ]")   // WARN
                }
            }
        }
    }

    @Test
    @Order(30)
    fun existImage_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[マップトップ画面]")
                }.expectation {
                    it.existImage("[スポットタブ]", throwsException = true)   // NG
                }
            }
        }
    }

    @Test
    @Order(40)
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
    @Order(50)
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