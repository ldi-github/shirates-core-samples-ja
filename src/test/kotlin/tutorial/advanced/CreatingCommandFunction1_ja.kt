package tutorial.advanced

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.*
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class CreatingCommandFunction1_ja : UITest() {

    @Test
    @Order(10)
    fun scrollToTopAndTapWithScrollDown() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .flickAndGoDown()
                        .dontExist("[ユーザー補助]")
                }.action {
                    it.scrollToTop()
                        .tapWithScrollDown("[ユーザー補助]")
                }.expectation {
                    it.screenIs("[ユーザー補助画面]")
                }
            }
        }
    }

    private fun TestDrive.tapWithScrollDownFromTop(
        expression: String,
        scrollDurationSeconds: Double = testContext.swipeDurationSeconds,
        scrollStartMarginRatio: Double = testContext.scrollVerticalStartMarginRatio,
        scrollMaxCount: Int = testContext.scrollMaxCount,
        holdSeconds: Double = testContext.tapHoldSeconds,
        tapMethod: TapMethod = TapMethod.auto
    ): TestElement {

        val testElement = lastElement

        val command = "tapWithScrollDownFromTop"
        val sel = getSelector(expression = expression)
        val message = "最上部へスクロールし、下方向へスクロールしながら $sel をタップします"
        val context = TestDriverCommandContext(testElement)
        context.execOperateCommand(command = command, message = message) {
            scrollToTop()
            tapWithScrollDown(
                expression = expression,
                scrollDurationSeconds = scrollDurationSeconds,
                scrollStartMarginRatio = scrollStartMarginRatio,
                scrollMaxCount = scrollMaxCount,
                holdSeconds = holdSeconds,
                tapMethod = tapMethod
            )
        }

        return lastElement
    }

    @Test
    @Order(20)
    fun tapWithScrollDownFromTop() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .flickAndGoDown()
                        .dontExist("[ユーザー補助]")
                }.action {
                    it.tapWithScrollDownFromTop("[ユーザー補助]")
                }.expectation {
                    it.screenIs("[ユーザー補助画面]")
                }
            }
        }
    }

}