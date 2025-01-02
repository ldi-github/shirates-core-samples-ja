package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.driver.rootElement
import shirates.core.testcode.UITest

@Testrun("testConfig/android/マップ/testrun.properties")
class Scroll3_ja : UITest() {

    @Test
    @Order(10)
    fun scrollRight_scrollLeft_implicitly1() {

        scenario {
            case(1) {
                condition {
                    it.macro("[マップトップ画面]")
                }.expectation {
                    select("#below_search_omnibox_container")
                        .existWithScrollRight("もっと見る")
                }
            }
            case(2) {
                expectation {
                    select("#below_search_omnibox_container")
                        .existWithScrollLeft("レストラン")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun scrollRight_scrollLeft_implicitly2() {

        scenario {
            case(1) {
                condition {
                    it.macro("[マップトップ画面]")
                }.expectation {
                    select("レストラン")
                        .existWithScrollRight("もっと見る")
                }
            }
            case(2) {
                expectation {
                    existWithScrollLeft("レストラン")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun scrollRight_scrollLeft_implicitly3() {

        scenario {
            case(1) {
                condition {
                    it.macro("[マップトップ画面]")
                }.action {
                    rootElement.scrollRight()
                        .scrollLeft()
                }
            }
        }
    }

    @Test
    @Order(40)
    fun scrollDown_scrollUp_explicitly1() {

        scenario {
            case(1) {
                condition {
                    it.macro("[マップトップ画面]")
                        .tapWithScrollRight("もっと見る", scrollFrame = "#recycler_view")
                }.action {
                    scrollDown(scrollFrame = "#explore_modules_list_layout_recyclerView")
                    scrollUp(scrollFrame = "#explore_modules_list_layout_recyclerView")
                }
            }
            case(2) {
                expectation {
                    withScrollDown(scrollFrame = "#explore_modules_list_layout_recyclerView") {
                        exist("洗車")
                    }
                    withScrollUp(scrollFrame = "#explore_modules_list_layout_recyclerView") {
                        existWithoutScroll("クリーニング")
                        exist("コーヒー")
                    }
                }
            }
        }
    }

}