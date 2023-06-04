package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("testConfig/android/マップ/testrun.properties")
class AssertingImage1_ja : UITest() {

    /**
     * Note:
     *
     * Run CroppingImages1.kt(tutorial.inaction.CroppingImages1)
     * before running this sample
     * to set up template image files.
     */

    @Test
    @Order(10)
    fun imageIs_isImage_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[マップトップ画面]")
                }.expectation {
                    it.select("[スポットタブ]").imageIs("[スポットタブ画像(選択状態)]")     // OK
                    it.select("[スポットタブ]").isImage("[スポットタブ画像(選択状態)]").thisIsTrue()      // OK
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
                    it.select("[経路タブ]").imageIs("[経路タブ画像(選択状態)]")     // NG
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
                    it.select("[スポットタブ]").imageIs("[スポットタブ画像(選択状態)]")
                    it.select("[経路タブ]").imageIs("[経路タブ画像]")
                    it.select("[保存済みタブ]").imageIs("[保存済みタブ画像]")
                    it.select("[投稿タブ]").imageIs("[投稿タブ画像]")
                    it.select("[お知らせタブ]").imageIs("[お知らせタブ画像]")
                }
            }
            case(2) {
                action {
                    it.tap("[経路タブ]")
                }.expectation {
                    it.select("[スポットタブ]").imageIs("[スポットタブ画像]")
                    it.select("[経路タブ]").imageIs("[経路タブ画像(選択状態)]")
                    it.select("[保存済みタブ]").imageIs("[保存済みタブ画像]")
                    it.select("[投稿タブ]").imageIs("[投稿タブ画像]")
                    it.select("[お知らせタブ]").imageIs("[お知らせタブ画像]")
                }
            }
            case(3) {
                action {
                    it.tap("[保存済みタブ]")
                }.expectation {
                    it.select("[スポットタブ]").imageIs("[スポットタブ画像]")
                    it.select("[経路タブ]").imageIs("[経路タブ画像]")
                    it.select("[保存済みタブ]").imageIs("[保存済みタブ画像(選択状態)]")
                    it.select("[投稿タブ]").imageIs("[投稿タブ画像]")
                    it.select("[お知らせタブ]").imageIs("[お知らせタブ画像]")
                }
            }
            case(4) {
                action {
                    it.tap("[投稿タブ]")
                }.expectation {
                    it.select("[スポットタブ]").imageIs("[スポットタブ画像]")
                    it.select("[経路タブ]").imageIs("[経路タブ画像]")
                    it.select("[保存済みタブ]").imageIs("[保存済みタブ画像]")
                    it.select("[投稿タブ]").imageIs("[投稿タブ画像(選択状態)]")
                    it.select("[お知らせタブ]").imageIs("[お知らせタブ画像]")
                }
            }
            case(5) {
                action {
                    it.tap("[お知らせタブ]")
                }.expectation {
                    it.select("[スポットタブ]").imageIs("[スポットタブ画像]")
                    it.select("[経路タブ]").imageIs("[経路タブ画像]")
                    it.select("[保存済みタブ]").imageIs("[保存済みタブ画像]")
                    it.select("[投稿タブ]").imageIs("[投稿タブ画像]")
                    it.select("[お知らせタブ]").imageIs("[お知らせタブ画像(選択状態)]")
                }
            }
        }
    }

}