package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class Scroll1_ja : UITest() {

    @Test
    @Order(10)
    fun scrollDown_scrollUp() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it
                        .scrollDown()
                        .scrollDown()
                        .scrollUp()
                        .scrollUp()
                }
            }
            case(2) {
                action {
                    it
                        .scrollDown(scrollDurationSeconds = 5.0, startMarginRatio = 0.1)
                        .scrollDown(scrollDurationSeconds = 3.0, startMarginRatio = 0.3)
                        .scrollUp(scrollDurationSeconds = 5.0, startMarginRatio = 0.1)
                        .scrollUp(scrollDurationSeconds = 3.0, startMarginRatio = 0.3)
                }
            }
        }
    }

    @Test
    @Order(20)
    fun scrollToBottom_scrollToTop() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.scrollToBottom(repeat = 2)
                }.expectation {
                    it.exist("[ヒントとサポート]")
                }
            }
            case(2) {
                action {
                    it.scrollToTop(repeat = 2)
                }.expectation {
                    it.exist("設定")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun withScroll() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    withScrollDown {
                        it
                            .select("[通知]").textIs("通知")
                            .select("[ユーザー補助]").textIs("ユーザー補助")
                            .select("[ヒントとサポート]").textIs("ヒントとサポート")
                    }
                    withScrollUp {
                        it
                            .select("[ユーザー補助]").textIs("ユーザー補助")
                            .select("[通知]").textIs("通知")
                    }
                }
            }
            case(2) {
                expectation {
                    withScrollDown {
                        it
                            .exist("[通知]")
                            .exist("[ユーザー補助]")
                            .exist("[ヒントとサポート]")
                    }
                    withScrollUp {
                        it
                            .exist("[ヒントとサポート]")
                            .exist("[ユーザー補助]")
                            .exist("[通知]")
                    }
                }
            }
            case(3) {
                action {
                    withScrollDown {
                        it.tap("[ユーザー補助]")
                    }
                }.expectation {
                    it.screenIs("[ユーザー補助画面]")
                }
            }
            case(4) {
                action {
                    it.tap("[←]")
                    withScrollUp {
                        it.tap("[ネットワークとインターネット]")
                    }
                }.expectation {
                    it.screenIs("[ネットワークとインターネット画面]")
                }
            }
        }
    }

}