package tutorial.basic

import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.accessIs
import shirates.core.driver.commandextension.macro
import shirates.core.driver.commandextension.select
import shirates.core.testcode.UITest

@Testrun("testConfig/android/電卓/testrun.properties")
class RelativeSelector1_ja : UITest() {

    @Test
    fun select() {

        scenario {
            case(1) {
                condition {
                    it.macro("[電卓メイン画面]")
                }.expectation {
                    it.select("<@1>:rightButton").accessIs("2")
                    it.select("<@1>:rightButton:rightButton").accessIs("3")
                    it.select("<@1>:rightButton(2)").accessIs("3")
                    it.select("[1]:rightButton(2)").accessIs("3")
                }
            }
        }
    }

    @Test
    fun select_with_nickname() {

        scenario {
            case(1) {
                condition {
                    it.macro("[電卓メイン画面]")
                }.expectation {
                    it.select("<@1>[:右のボタン]").accessIs("2")
                    it.select("[1][:下のボタン]").accessIs("0")
                    it.select("[1]:rightButton(2)[:左のボタン]").accessIs("2")
                }
            }
            case(2) {
                expectation {
                    it.select("[5]").select("[:右のボタン]").accessIs("6")
                    it.select("[5]").select("[:下のボタン]").accessIs("2")
                    it.select("[5]").select("[:左のボタン]").accessIs("4")
                    it.select("[5]").select("[:上のボタン]").accessIs("8")
                }
            }
            case(3) {
                expectation {
                    it.select("[5]").apply {
                        select("[:右のボタン]").accessIs("6")
                        select("[:下のボタン]").accessIs("2")
                        select("[:左のボタン]").accessIs("4")
                        select("[:上のボタン]").accessIs("8")
                    }
                }
            }
        }
    }
}