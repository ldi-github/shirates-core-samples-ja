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
                    it.select("設定", log = true)
                    output(it)
                }
            }
            case(2) {
                action {
                    it.selectWithScrollDown("システム", log = true)
                    output(it)
                }
            }
            case(3) {
                action {
                    it.selectWithScrollUp("設定", log = true)
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
                        .selectInScanResults("設定", log = true)
                        .selectInScanResults("ユーザー補助", log = true)
                        .selectInScanResults("システム", log = true)
                }
            }
        }
    }

}