package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.branchextension.ifScreenIs
import shirates.core.driver.branchextension.ifScreenIsNot
import shirates.core.driver.commandextension.macro
import shirates.core.driver.commandextension.tap
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class IfScreenIs1_ja : UITest() {

    @Test
    @Order(10)
    fun ifScreenIsTest() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    ifScreenIs("[Android設定トップ画面]") {
                        OK("ifScreenIs が呼ばれました")
                    }.ifElse {
                        NG()
                    }
                }
            }
            case(2) {
                action {
                    it.tap("[ネットワークとインターネット]")
                }.expectation {
                    ifScreenIs("[ネットワークとインターネット画面]") {
                        OK("ifScreenIs が呼ばれました")
                    }.ifElse {
                        NG()
                    }
                }
            }
        }
    }

    @Test
    @Order(20)
    fun ifScreenIsNotTest() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    ifScreenIsNot("[Android設定トップ画面]") {
                        NG()
                    }.ifElse {
                        OK("ifElse が呼ばれました")
                    }
                }
            }
            case(2) {
                action {
                    it.tap("[ネットワークとインターネット]")
                }.expectation {
                    ifScreenIsNot("[ネットワークとインターネット画面]") {
                        NG()
                    }.ifElse {
                        OK("ifElse が呼ばれました")
                    }
                }
            }
        }
    }

}