package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.branchextension.ifImageExist
import shirates.core.driver.branchextension.ifImageExistNot
import shirates.core.driver.commandextension.macro
import shirates.core.driver.commandextension.scrollToBottom
import shirates.core.testcode.UITest
import shirates.helper.ImageSetupHelper

@Testrun("testConfig/android/設定/testrun.properties")
class IfImageExist1_ja : UITest() {

    @Test
    @Order(0)
    fun setupImage() {

        ImageSetupHelper.setupImageAndroidSettingsTopScreen()
    }

    @Test
    @Order(10)
    fun ifImageExistTest() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    ifImageExist("[ネットワークとインターネットアイコン].png") {
                        OK("ifImageExist が呼ばれました")
                    }.ifElse {
                        NG()
                    }

                    ifImageExistNot("[システムアイコン].png") {
                        OK("ifImageExistNot が呼ばれました")
                    }.ifElse {
                        NG()
                    }
                }
            }
            case(2) {
                action {
                    it.scrollToBottom()
                }.expectation {
                    ifImageExist("[ネットワークとインターネットアイコン].png") {
                        NG()
                    }.ifElse {
                        OK("ifElse が呼ばれました")
                    }

                    ifImageExistNot("[システムアイコン].png") {
                        NG()
                    }.ifElse {
                        OK("ifElse が呼ばれました")
                    }
                }
            }
        }
    }

}