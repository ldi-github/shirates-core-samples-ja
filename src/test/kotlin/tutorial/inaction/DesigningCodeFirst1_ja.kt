package tutorial.inaction

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.macro
import shirates.core.driver.commandextension.select
import shirates.core.driver.commandextension.tap
import shirates.core.driver.commandextension.textIs
import shirates.core.testcode.UITest

@Testrun("testConfig/android/電卓/testrun.properties")
class DesigningCodeFirst1_ja : UITest() {

    @Test
    @Order(10)
    @DisplayName("1 + 2 = 3")
    fun A1010() {

        scenario {
            case(1) {
                condition {
                    it.macro("[電卓メイン画面]")
                }.action {
                    it
                        .tap("[1]")
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

    @Test
    @Order(20)
    @DisplayName("9 - 3 = 6")
    fun A1020() {

        scenario {
            case(1) {
                condition {
                    it.macro("[電卓メイン画面]")
                }.action {
                    it
                        .tap("[9]")
                        .tap("[-]")
                        .tap("[3]")
                        .tap("[=]")
                }.expectation {
                    it.select("[計算結果]")
                        .textIs("6")
                }
            }
        }
    }

    @Test
    @Order(30)
    @DisplayName("ゼロ除算")
    fun A1030() {

        scenario {
            case(1) {
                condition {
                    it.macro("[電卓メイン画面]")
                }.action {
                    it
                        .tap("[1]")
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