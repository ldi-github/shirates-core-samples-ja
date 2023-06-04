package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class SilentAndProcedure1_ja : UITest() {

    @Test
    @Order(10)
    fun silent1() {

        scenario {
            case(1) {
                condition {
                    macro("[Android設定トップ画面]")
                }.action {
                    describe("[システム]をタップする")
                    silent {
                        it.scrollToBottom()
                            .tap("[システム]")
                    }
                }.expectation {
                    it.screenIs("[システム画面]")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun procedure1() {

        scenario {
            case(1) {
                condition {
                    macro("[Android設定トップ画面]")
                }.action {
                    procedure("[システム]をタップする") {
                        it.scrollToBottom()
                            .tap("[システム]")
                    }
                }.expectation {
                    it.screenIs("[システム画面]")
                }
            }
        }
    }

}