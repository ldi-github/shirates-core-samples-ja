package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.driver.wait
import shirates.core.testcode.UITest

@Testrun("testConfig/ios/設定/testrun.properties")
class iOSPressKey1_ja : UITest() {

    @Test
    @Order(10)
    fun pressBack() {

        scenario {
            case(1) {
                condition {
                    it.macro("[iOS検索画面]")
                    it.select("[Spotlight検索フィールド]")
                        .clearInput()
                        .sendKeys("safari")
                        .tap("safari")
                        .wait()
                        .appIs("Safari")
                }.action {
                    it.pressBack()
                }.expectation {
                    it.screenIs("[iOS検索画面]")
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
                    it.macro("[iOS設定トップ画面]")
                }.action {
                    it.pressHome()
                }.expectation {
                    it.exist(".XCUIElementTypePageIndicator")
                        .exist("#Safari")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun pressEnter() {

        scenario {
            case(1) {
                condition {
                    it.pressHome()
                        .swipeCenterToBottom()
                        .tap("#SpotlightSearchField")
                        .clearInput()
                        .sendKeys("safari")
                }.action {
                    it.pressEnter()
                }.expectation {
                    it.appIs("Safari")
                }
            }
        }
    }

}