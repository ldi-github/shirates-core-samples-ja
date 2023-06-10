package demo

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.branchextension.ifCanSelect
import shirates.core.driver.branchextension.ios
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("testConfig/ios/設定/testrun.properties")
class iOSSettingsDemo : UITest() {

    @Test
    @DisplayName("[デベロッパ画面]に[次回起動時にローカルデータをリセット]が存在すること")
    fun s10() {

        scenario {
            case(1) {
                condition {
                    it.pressHome()
                        .launchApp()
                        .screenIs("[iOS設定トップ画面]")
                }.action {
                    it.tapWithScrollDown("デベロッパ")
                }.expectation {
                    it.screenIs("[デベロッパ画面]")
                }
            }
            case(2) {
                expectation {
                    it.existWithScrollDown("次回起動時にローカルデータをリセット")
                }
            }

        }
    }

    @Test
    @DisplayName("[情報画面]でバージョンを取得する")
    fun s20() {

        scenario {
            case(1) {
                ios {
                    condition {
                        it
                            .restartApp()
                            .screenIs("[iOS設定トップ画面]")
                            .tap("一般")
                            .tap("情報")
                    }.action {
                        ifCanSelect("iOSバージョン") {
                            it.next().next()
                                .memoTextAs("バージョン")
                        }
                        ifCanSelect("text=Version&&className=XCUIElementTypeStaticText") {
                            it.next(".XCUIElementTypeStaticText")
                                .memoTextAs("バージョン")
                        }
                    }
                }

            }
        }
    }

    @Test
    @DisplayName("アクティブなアプリの検証")
    fun s30() {

        scenario {
            case(1) {
                ios {
                    it.appIs("設定")
                }
            }
        }
    }
}