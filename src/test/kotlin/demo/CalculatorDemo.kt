package demo

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.SheetName
import shirates.core.testcode.UITest

@SheetName("電卓テスト")
@Testrun("testConfig/android/電卓/testrun.properties")
class CalculatorDemo : UITest() {

    /**
     * このテストを実行するには事前に電卓アプリ(Google LLC)をインストールしてください。
     */

    @Test
    @DisplayName("123+456")
    fun s10() {

        scenario {
            case(1) {
                condition {
                    it.macro("[電卓を再起動する]")
                    it.screenIs("[電卓メイン画面]")
                }.action {
                    it
                        .tap("[1]")
                        .tap("[2]")
                        .tap("[3]")
                }.expectation {
                    it.select("[式]")
                        .textIs("123")
                }
            }

            case(2) {
                action {
                    it.tap("[+]")
                }.expectation {
                    it.select("[式]")
                        .textIs("123+")
                }
            }

            case(3) {
                action {
                    it
                        .tap("[4]")
                        .tap("[5]")
                        .tap("[6]")
                }.expectation {
                    it.select("[式]")
                        .textIs("123+456")
                    it.select("[計算結果プレビュー]")
                        .textIs("579")
                }
            }

            case(4) {
                action {
                    it.tap("[=]")
                }.expectation {
                    it.select("[計算結果]")
                        .textIs("579")
                }
            }
        }
    }

    @Test
    @DisplayName("1÷0")
    fun s20() {

        scenario {
            case(1) {
                condition {
                    it.macro("[電卓を再起動する]")
                    it.screenIs("[電卓メイン画面]")
                }.action {
                    it
                        .tap("[1]")
                        .tap("[÷]")
                        .tap("[0]")
                        .tap("[=]")
                }.expectation {
                    it.select("[式]")
                        .textIs("1÷0")
                    it.select("[計算結果プレビュー]")
                        .textIs("ゼロでは除算できません")
                }
            }
        }
    }

}