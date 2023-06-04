package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.dontExist
import shirates.core.driver.commandextension.exist
import shirates.core.driver.commandextension.macro
import shirates.core.testcode.UITest

@Testrun("testConfig/android/マップ/testrun.properties")
class ExistDontExist2_ja : UITest() {

    /**
     * Note:
     *
     * Run CroppingImages1.kt(tutorial.inaction.CroppingImages1)
     * before running this sample
     * to set up template image files.
     */

    @Test
    @Order(10)
    fun exist_image_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[マップトップ画面]")
                }.expectation {
                    it
                        .exist("[スポットタブ(選択状態)]")
                        .dontExist("[スポットタブ画像]")

                        .exist("[経路タブ]")
                        .dontExist("[経路タブ(選択状態)]")

                        .exist("[保存済みタブ画像]")
                        .dontExist("[保存済みタブ画像(選択状態)]")

                        .exist("[投稿タブ画像]")
                        .dontExist("[投稿タブ画像(選択状態)]")

                        .exist("[お知らせタブ画像]")
                        .dontExist("[お知らせタブ画像(選択状態)]")
                }
            }
        }

    }

    @Test
    @Order(20)
    fun exist_image_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[マップトップ画面]")
                }.expectation {
                    it
                        .dontExist("[スポットタブ画像]")   // OK
                        .exist("[スポットタブ画像]")   // NG
                }
            }
        }
    }

    @Test
    @Order(30)
    fun dont_exist_image_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[マップトップ画面]")
                }.expectation {
                    it
                        .exist("[スポットタブ(選択状態)]")     // OK
                        .dontExist("[スポットタブ(選択状態)]") // NG
                }
            }
        }
    }

}