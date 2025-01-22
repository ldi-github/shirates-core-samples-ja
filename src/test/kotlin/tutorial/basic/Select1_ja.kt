package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class Select1_ja : UITest() {

    @Test
    @Order(10)
    fun select() {

        scenario {
            case(1) {
                action {
                    it.select("設定")
                    output(it)
                }
            }
            case(2) {
                action {
                    it.selectWithScrollDown("システム")
                    output(it)
                }
            }
            case(3) {
                action {
                    it.selectWithScrollUp("設定")
                    output(it)
                }
            }
        }
    }

    @Test
    @Order(20)
    fun selectInScanElements() {

        scenario {
            case(1) {
                action {
                    it.scanElements()
                        .selectInScanResults("設定")
                        .selectInScanResults("ユーザー補助")
                        .selectInScanResults("システム")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun selectWithScrollAndSwipeToCenter() {

        scenario {
            case(1) {
                action {
                    it.selectWithScrollDown("セキュリティとプライバシー")
                }
            }
            case(2) {
                action {
                    it.selectWithScrollUp("通知")
                }
            }
        }
    }
}