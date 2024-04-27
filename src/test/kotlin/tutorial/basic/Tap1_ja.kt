package tutorial.basic

import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.screenIs
import shirates.core.driver.commandextension.select
import shirates.core.driver.commandextension.tap
import shirates.core.driver.commandextension.tapWithScrollDown
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class Tap1_ja : UITest() {

    @Test
    fun tap() {

        scenario {
            case(1) {
                action {
                    it.tap("ネットワークとインターネット")
                        .tap("インターネット")
                    it.tap("@上へ移動")
                        .tap("@上へ移動")
                }
            }
            case(2) {
                action {
                    it.tapWithScrollDown("ディスプレイ")
                        .tapWithScrollDown("ロック画面")
                    it.tap("@上へ移動")
                        .tap("@上へ移動")
                }
            }
        }
    }

    @Test
    fun tapByCoordinates() {

        scenario {
            case(1) {
                action {
                    val e = select("ネットワークとインターネット")
                    it.tap(x = e.bounds.centerX, y = e.bounds.centerY)
                }.expectation {
                    it.screenIs("[ネットワークとインターネット画面]")
                }
            }
        }
    }

}