package tutorial.inaction

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.exist
import shirates.core.driver.commandextension.macro
import shirates.core.driver.commandextension.scrollToBottom
import shirates.core.driver.commandextension.scrollToTop
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class ScrollToEdge1_ja : UITest() {

    @Order(10)
    @Test
    fun scrollToBottom_scrollToTop() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.scrollToBottom()
                }.expectation {
                    it.exist("{ヒントとサポート}")
                }
            }
            case(2) {
                action {
                    it.scrollToTop()
                }.expectation {
                    it.exist("[ネットワークとインターネット]")
                }
            }
        }
    }

    @Order(20)
    @Test
    fun scrollToBottom_scrollToTop_with_edge_selector() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.scrollToBottom(edgeSelector = "{ヒントとサポート}")
                }.expectation {
                    it.exist("{ヒントとサポート}")
                }
            }
            case(2) {
                action {
                    it.scrollToTop(edgeSelector = "[ネットワークとインターネット]")
                }.expectation {
                    it.exist("[ネットワークとインターネット]")
                }
            }
        }
    }
}