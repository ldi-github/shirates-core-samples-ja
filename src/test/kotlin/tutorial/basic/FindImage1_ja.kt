package tutorial.basic

import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("unittestConfig/android/設定/testrun.properties")
class FindImage1_ja : UITest() {

    /**
     * 注意:
     *
     * このサンプルを実行する前に
     * CroppingImages2.kt(tutorial.inaction.CroppingImages2)を実行して
     * テンプレート画像ファイルをセットアップしてください。
     */

    @Test
    fun findImage() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.findImage("[ネットワークとインターネット].png")
                    it.findImageWithScrollDown("[ディスプレイ].png")
                    it.findImageWithScrollDown("[ヒントとサポート].png")
                    it.findImageWithScrollUp("[ディスプレイ].png")
                    it.findImageWithScrollUp("[ネットワークとインターネット].png")
                }.expectation {
                    it.exist("[ネットワークとインターネット].png")
                    it.existWithScrollDown("[ディスプレイ].png")
                    it.existWithScrollDown("[ヒントとサポート].png")
                    it.existWithScrollUp("[ディスプレイ].png")
                    it.existWithScrollUp("[ネットワークとインターネット].png")
                }
            }
        }
    }

}