package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("testConfig/android/電卓/testrun.properties")
class Memo1_ja : UITest() {

    @Order(10)
    @Test
    fun writeMemo_readMemo() {

        scenario {
            case(1) {
                condition {
                    it.macro("[電卓メイン画面]")
                    writeMemo("最初のキー", "[1]")
                    writeMemo("2番目のキー", "[+]")
                    writeMemo("3番目のキー", "[2]")
                    writeMemo("4番目のキー", "[=]")
                    writeMemo("期待結果", "3")
                }.action {
                    it
                        .tap(readMemo("最初のキー"))
                        .tap(readMemo("2番目のキー"))
                        .tap(readMemo("3番目のキー"))
                        .tap(readMemo("4番目のキー"))
                }.expectation {
                    it.select("[計算結果]")
                        .textIs(readMemo("期待結果"))
                }
            }
        }
    }

    @Order(20)
    @Test
    fun memoTextAs_readMemo() {

        scenario {
            case(1) {
                condition {
                    it.macro("[電卓メイン画面]")
                }.action {
                    it.tap("[1]")
                        .tap("[2]")
                        .tap("[+]")
                        .tap("[3]")
                        .tap("[=]")
                }.expectation {
                    it.select("[計算結果]")
                        .textIs("15")
                        .memoTextAs("結果1")    // TestElement.text を "結果1" としてメモします
                }
            }

            case(2) {
                condition {
                    it.tap("[AC]")
                }.action {
                    it.readMemo("結果1")
                        .forEach { key ->
                            it.tap("[$key]")
                        }
                    it.tap("[+]")
                        .tap("[5]")
                        .tap("[=]")
                }.expectation {
                    it.select("[計算結果]")
                        .textIs("20")
                }
            }
        }

    }
}