package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.branchextension.osaifuKeitai
import shirates.core.driver.branchextension.osaifuKeitaiNot
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class Descriptor1_ja : UITest() {

    @Test
    @Order(10)
    fun descriptors() {

        scenario {
            case(1) {
                condition {
                    describe("describe")
                    procedure("procedure") {
                        manual("manual")
                    }
                    caption("caption")
                    comment("comment")
                    manual("manual")
                    output("output")
                }.action {
                    caption("caption")
                        .describe("describe1")
                        .describe("describe2")
                    procedure("procedure") {
                        manual("manual")
                    }
                }.expectation {
                    target("target1")
                        .manual("manual")
                    target("target2")
                        .knownIssue("knownIssue", ticketUrl = "https://example.com/ticket/12345")
                }
            }
        }

    }

    @Test
    fun example() {

        scenario {
            case(1) {
                condition {
                    macro("[在庫設定]")
                    macro("[ログイン]")
                    macro("[受注画面]")
                }.action {
                    osaifuKeitai {
                        caption("おサイフケータイ")
                            .procedure("おサイフケータイで受注登録") {
                                // 実装します
                            }
                            .comment("note: must be charged")
                    }
                    osaifuKeitaiNot {
                        caption("おサイフケータイ以外")
                            .procedure("クレジットカードで受注登録") {
                                // 実装します
                            }
                    }
                }.expectation {
                    target("[完了メッセージ]")
                        .manual("表示されること")
                    target("[OK]")
                        .manual("表示されること")
                }
            }

            case(2) {
                action {
                    manual("[OK]をタップする")
                }.expectation {
                    manual("[ホーム画面]が表示されること")
                        .knownIssue("既知の不具合", ticketUrl = "https://example.com/ticket/12345")
                }
            }
        }
    }
}