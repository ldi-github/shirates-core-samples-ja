package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class AndroidSendKeys1_ja : UITest() {

    @Test
    @Order(10)
    fun sendKeys() {

        scenario {
            case(1) {
                condition {
                    it.macro("[設定を検索画面]")
                }.action {
                    it.sendKeys("日付")
                }.expectation {
                    it.textIs("日付")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun clearInput() {

        scenario {
            case(1) {
                condition {
                    it.restartApp()
                        .macro("[設定を検索画面]")
                        .select("[検索ボックス]")
                        .textIs("設定を検索")
                        .sendKeys("日付")
                        .textIs("日付")
                }.action {
                    it.clearInput()
                }.expectation {
                    it.select("[検索ボックス]")
                        .textIs("設定を検索")
                }
            }
        }
    }
}