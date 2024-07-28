package tutorial.inaction

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.Manual
import shirates.core.testcode.UITest

@Testrun("testConfig/android/電卓/testrun.properties")
class CodeFirst2_ja : UITest() {

    @Manual
    @Test
    @DisplayName("電卓を起動")
    fun A0010() {

        scenario {
            case(1) {
                condition {
                    it.macro("[電卓メイン画面]")
                }.expectation {
                    it.screenIs("[電卓メイン画面]")
                }
            }
        }
    }

    @Manual
    @Test
    @DisplayName("足し算")
    fun A0020() {

        scenario {
            case(1) {
                condition {
                    it.macro("[電卓メイン画面]")
                }.action {
                    it.tap("[1]")
                        .tap("[+]")
                        .tap("[2]")
                        .tap("[=]")
                }.expectation {
                    it.select("[計算結果]")
                        .textIs("3")
                }
            }
        }
    }

    @Manual
    @Test
    @DisplayName("ゼロ除算")
    fun A0030() {

        scenario {
            case(1) {
                condition {
                    it.macro("[電卓メイン画面]")
                }.action {
                    it.tap("[1]")
                        .tap("[÷]")
                        .tap("[0]")
                        .tap("[=]")
                }.expectation {
                    it.select("[計算結果プレビュー]")
                        .textIs("ゼロでは除算できません")
                }
            }
        }
    }

}