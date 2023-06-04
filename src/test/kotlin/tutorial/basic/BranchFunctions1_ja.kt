package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.branchextension.*
import shirates.core.driver.commandextension.describe
import shirates.core.driver.commandextension.screenIs
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties", profile = "Android")
class BranchFunctions1_ja : UITest() {

    @Test
    @Order(10)
    fun branch_platform_device() {

        scenario {
            case(1) {
                action {
                    android {
                        virtualDevice {
                            describe("これはAndroidエミュレーターの場合に呼ばれます。")
                        }
                        realDevice {
                            describe("これはAndroid実機の場合に呼ばれます。")
                        }
                    }
                    ios {
                        virtualDevice {
                            describe("これはiOSシミュレーターの場合に呼ばれます。")
                        }
                        realDevice {
                            describe("これはiOS実機の場合に呼ばれます。")
                        }
                    }
                }.expectation {
                    it.screenIs("[Android設定トップ画面]")
                }
            }
            case(2) {
                action {
                    emulator {
                        describe("これはAndroidエミュレーターの場合に呼ばれます。")
                    }
                    simulator {
                        describe("これはiOSシミュレーターの場合に呼ばれます。")
                    }
                    realDevice {
                        describe("これは実機の場合に呼ばれます。")
                    }
                }.expectation {
                    it.screenIs("[Android設定トップ画面]")
                }
            }
        }
    }

}