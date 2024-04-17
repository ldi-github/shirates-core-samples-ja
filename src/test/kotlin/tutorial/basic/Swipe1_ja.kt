package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.driver.scrollFrame
import shirates.core.driver.viewBounds
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class Swipe1_ja : UITest() {

    @Test
    @Order(10)
    fun swipeTo_swipeToAdjust() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.select("[バッテリー]")
                        .swipeTo("[ネットワークとインターネット]")
                }.expectation {
                }
            }
            case(2) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.select("[バッテリー]")
                        .swipeToAdjust("[ネットワークとインターネット]")
                }.expectation {
                }
            }
        }
    }

    @Test
    @Order(20)
    fun swipeToCenter_swipeToTop_swipeToBottom() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .exist("[通知]")
                        .exist("[バッテリー]")
                        .output("scrollFrame: ${it.scrollFrame}")
                }.action {
                    it.select("[バッテリー]")
                        .swipeToCenterOfScreen()
                        .swipeToTopOfScreen(durationSeconds = 10.0)
                }.expectation {
                    it.dontExist("[通知]")
                        .exist("[ストレージ]")
                }
            }
            case(2) {
                condition {
                    it.exist("[セキュリティとプライバシー]")
                        .exist("[位置情報]")
                }.action {
                    it.select("[セキュリティとプライバシー]")
                        .swipeToBottomOfScreen(durationSeconds = 10.0)
                }.expectation {
                    it.exist("[セキュリティとプライバシー]")
                        .dontExist("[位置情報]")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun swipePointToPoint() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.swipePointToPoint(
                        startX = viewBounds.centerX,
                        startY = viewBounds.centerY,
                        endX = viewBounds.centerX,
                        endY = viewBounds.top
                    )
                }.expectation {

                }
            }

            case(2) {
                action {
                    it.swipePointToPoint(
                        startX = viewBounds.centerX,
                        startY = viewBounds.centerY,
                        endX = viewBounds.centerX,
                        endY = viewBounds.bottom,
                        durationSeconds = 0.2
                    )
                }.expectation {

                }
            }
        }
    }

    @Test
    @Order(40)
    fun swipeCenterToTop_swipeCenterToBottom() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.swipeCenterToTop()
                }.expectation {

                }
            }

            case(2) {
                action {
                    it.swipeCenterToBottom()
                }.expectation {

                }
            }
        }

    }

    @Test
    @Order(50)
    fun swipeLeftToRight_swipeRightToLeft() {

        scenario {
            case(1) {
                condition {
                    it
                        .pressHome()
                        .pressHome()
                }.action {
                    it.swipeLeftToRight()
                }.expectation {

                }
            }

            case(2) {
                action {
                    it.swipeRightToLeft()
                }.expectation {

                }
            }
        }
    }

    @Test
    @Order(60)
    fun flickLeftToRight_flickRightToLeft() {

        scenario {
            case(1) {
                condition {
                    it
                        .pressHome()
                        .pressHome()
                }.action {
                    it.flickLeftToRight()
                }.expectation {

                }
            }

            case(2) {
                action {
                    it.flickRightToLeft()
                }.expectation {

                }
            }

        }

    }

    @Test
    @Order(70)
    fun swipeBottomToTop_swipeTopToBottom() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.swipeBottomToTop()
                }.expectation {

                }
            }

            case(2) {
                action {
                    it.swipeTopToBottom()
                }.expectation {

                }
            }
        }

    }

    @Test
    @Order(80)
    fun flickBottomToTop_flickTopToBottom() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.flickBottomToTop()
                }.expectation {

                }
            }

            case(2) {
                action {
                    it.flickTopToBottom()
                }.expectation {

                }
            }
        }

    }

    @Test
    @Order(90)
    fun swipeVerticalTo() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.selectWithScrollDown("[バッテリー]")
                        .swipeVerticalTo(300)
                }.expectation {
                }
            }

            case(2) {
                action {
                    it.swipeVerticalTo(2000)
                }.expectation {
                }
            }
        }
    }

    @Test
    @Order(100)
    fun swipeHorizontalTo() {

        scenario {
            case(1) {
                condition {
                    it.pressHome()
                        .pressHome()
                        .screenIs("[Pixelホーム画面]")
                }.action {
                    it.select("Chrome")
                        .swipeHorizontalTo(0)
                }.expectation {
                }
            }

            case(2) {
                action {
                    it.select("メッセージ")
                        .swipeHorizontalTo(viewBounds.right)
                }.expectation {
                }
            }

        }
    }

    @Test
    @Order(110)
    fun swipeToTop_swipeToBottom() {

        scenario {
            case(1) {
                condition {
                    it.pressHome()
                        .pressHome()
                        .screenIs("[Pixelホーム画面]")
                }.action {
                    it.select("@検索")
                        .swipeToTop()
                }.expectation {
                }
            }

            case(2) {
                action {
                    it.select("#input")
                        .swipeToBottom()
                }.expectation {
                }
            }
        }
    }

    @Test
    @Order(120)
    fun flickToTop_flickToBottom() {

        scenario {
            case(1) {
                condition {
                    it.pressHome()
                        .pressHome()
                        .screenIs("[Pixelホーム画面]")
                }.action {
                    it.select("@検索")
                        .flickToTop()
                }.expectation {
                }
            }

            case(2) {
                action {
                    it.select("#input")
                        .flickToBottom()
                }.expectation {
                }
            }
        }
    }
}