package demo.vision

import ifCanDetect
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.thisStartsWith
import shirates.core.vision.driver.branchextension.ios
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

@Testrun("testConfig/ios/設定（Vision）/testrun.properties")
class iOSSettingsVisionDemo : VisionTest() {

    @Test
    @DisplayName("[次回起動時にローカルデータをリセット]が[デベロッパ画面に存在すること]")
    fun s10() {

        scenario {
            case(1) {
                condition {
                    it.screenIs("[iOS設定トップ画面]")
                }.action {
                    it.tapWithScrollDown("デベロッパ")
                }.expectation {
                    it.screenIs("[デベロッパ画面]")
                }
            }
            case(2) {
                expectation {
                    it.existWithScrollDown("次回起動時にローカルデータを")
                }
            }

        }
    }

    @Test
    @DisplayName("[情報画面]のバージョンを取得する")
    fun s20() {

        scenario {
            case(1) {
                ios {
                    condition {
                        it.screenIs("[iOS設定トップ画面]")
                            .tap("一般")
                            .tap("情報")
                    }.action {
                        screenshot()
                        it
                            .ifCanDetect("iOSバージョン") {
                                it.rightText()
                                    .memoTextAs("iOSバージョン")
                            }
                            .ifCanDetect("機種名") {
                                it.rightText()
                                    .memoTextAs("機種名")
                            }
                    }.expectation {
                        readMemo("iOSバージョン").thisStartsWith("18.2", message = "iOS Version is `18.2`")
                        readMemo("機種名").thisStartsWith("iPhone 16", message = "Model Name is `iPhone 16`")
                    }
                }
            }
        }
    }

}