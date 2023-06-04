package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.branchextension.ifTrue
import shirates.core.driver.commandextension.caption
import shirates.core.driver.commandextension.exist
import shirates.core.driver.commandextension.macro
import shirates.core.driver.commandextension.tapWithScrollDown
import shirates.core.driver.isEmulator
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class IfTrueIfFalse1_ja : UITest() {

    @Test
    @Order(10)
    fun ifTrueIfFalse() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    isEmulator
                        .ifTrue {
                            it.caption("エミュレーターの場合")
                                .tapWithScrollDown("エミュレートされたデバイスについて")
                        }
                        .ifElse {
                            it.caption("実機の場合")
                                .tapWithScrollDown("デバイス情報")
                        }
                }.expectation {
                    isEmulator
                        .ifTrue {
                            it.caption("エミュレーターの場合")
                                .exist("@エミュレートされたデバイスについて")
                        }
                        .ifElse {
                            it.caption("実機の場合")
                                .exist("@デバイス情報")
                        }
                }
            }
        }
    }

}