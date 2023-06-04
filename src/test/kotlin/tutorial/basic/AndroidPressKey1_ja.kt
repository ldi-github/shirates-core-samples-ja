package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class AndroidPressKey1_ja : UITest() {

    @Test
    @Order(10)
    fun pressBack() {

        scenario {
            case(1) {
                condition {
                    it.macro("[ネットワークとインターネット画面]")
                }.action {
                    it.pressBack()
                }.expectation {
                    it.screenIs("[Android設定トップ画面]")
                }
            }

        }
    }

    @Test
    @Order(20)
    fun pressHome() {

        scenario {
            case(1) {
                condition {
                    it.macro("[ネットワークとインターネット画面]")
                }.action {
                    it.pressHome()
                }.expectation {
                    it.screenIs("[Pixelホーム画面]")
                }
            }

        }
    }

    @Test
    @Order(30)
    fun pressSearch() {

        scenario {
            case(1) {
                condition {
                    it.macro("[設定を検索画面]")
                        .sendKeys("日付")
                }.action {
                    it.pressSearch()
                }.expectation {
                    it.exist("システム > 日付と時刻")
                }
            }
        }

    }

}