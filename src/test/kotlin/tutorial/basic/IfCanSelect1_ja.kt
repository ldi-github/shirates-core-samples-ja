package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.branchextension.ifCanSelect
import shirates.core.driver.branchextension.ifCanSelectNot
import shirates.core.driver.commandextension.macro
import shirates.core.driver.commandextension.scrollToBottom
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class IfCanSelect1_ja : UITest() {

    @Test
    @Order(10)
    fun ifCanSelectTest() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    ifCanSelect("[ネットワークとインターネット]") {
                        OK("ifCanSelect が呼ばれました")
                    }.ifElse {
                        NG()
                    }

                    ifCanSelectNot("[システム]") {
                        OK("ifCanSelectNot が呼ばれました")
                    }.ifElse {
                        NG()
                    }
                }
            }
            case(2) {
                action {
                    it.scrollToBottom()
                }.expectation {
                    ifCanSelect("[ネットワークとインターネット]") {
                        NG()
                    }.ifElse {
                        OK("ifElse が呼ばれました")
                    }

                    ifCanSelectNot("[システム]") {
                        NG()
                    }.ifElse {
                        OK("ifElse が呼ばれました")
                    }
                }
            }
        }
    }

}