package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest
import shirates.helper.ImageSetupHelper

@Testrun("testConfig/android/設定/testrun.properties")
class FindImage1_ja : UITest() {

    @Test
    @Order(10)
    fun croppingImages() {

        scenario {
            /**
             * Android設定トップ画面のアイコンをキャプチャして以下のディレクトリへ格納します。
             * testConfig/android/設定/screens/images/Android設定トップ画面
             */
            ImageSetupHelper.setupImageAndroidSettingsTopScreen()
        }
    }

    @Test
    @Order(20)
    fun findImage() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    withScrollDown {
                        it.findImage("[ネットワークとインターネットアイコン].png")
                        it.findImage("[ディスプレイアイコン].png")
                        it.findImage("[ヒントとサポートアイコン].png")
                    }
                    withScrollUp {
                        it.findImage("[ディスプレイアイコン].png")
                        it.findImage("[ネットワークとインターネットアイコン].png")
                    }
                }.expectation {
                    withScrollDown {
                        it.existImage("[ネットワークとインターネットアイコン].png")
                        it.existImage("[ディスプレイアイコン].png")
                        it.existImage("[ヒントとサポートアイコン].png")
                    }
                    withScrollUp {
                        it.existImage("[ディスプレイアイコン].png")
                        it.existImage("[ネットワークとインターネットアイコン].png")
                    }
                }
            }
        }
    }

}