package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.branchextension.onScreen
import shirates.core.driver.commandextension.describe
import shirates.core.driver.commandextension.macro
import shirates.core.driver.commandextension.screenIs
import shirates.core.driver.commandextension.screenName
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class OnScreen1_ja : UITest() {

    @Test
    @Order(10)
    fun onScreen1() {

        scenario {
            case(1) {
                condition {
                    it.macro("[システム画面]")
                }.expectation {
                    onScreen("[Android設定トップ画面]") {
                        it.screenIs("[Android設定トップ画面]")
                    }.onScreen("[システム画面]") {
                        it.screenIs("[システム画面]")
                    }.not {
                        describe("画面は $screenName です")
                    }
                }
            }
        }
    }

}