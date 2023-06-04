package tutorial.inaction

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.tap
import shirates.core.driver.commandextension.tapWithScrollDown
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class Debugging1_ja : UITest() {

    @Test
    @Order(10)
    fun missingSelector_ERROR() {

        scenario {
            case(1) {
                action {
                    it.tap("設計")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun watchingSourceXml() {

        scenario {
            case(1) {
                action {
                    it.tapWithScrollDown("ユーザー補助")
                        .tapWithScrollDown("ユーザー補助機能のショートカット")
                        .tap("ユーザー補助機能ボタンと操作")
                }
            }
        }
    }
}