package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.configuration.repository.ImageFileRepository
import shirates.core.driver.branchextension.ifImageIs
import shirates.core.driver.branchextension.ifImageIsNot
import shirates.core.driver.commandextension.macro
import shirates.core.driver.commandextension.select
import shirates.core.logging.TestLog
import shirates.core.testcode.UITest
import shirates.helper.TestSetupHelper

@Testrun("testConfig/android/設定/testrun.properties")
class IfImageIs1_ja : UITest() {

    @Test
    @Order(0)
    fun setupImage() {

        TestSetupHelper.setupImageAndroidSettingsTopScreen()
    }

    @Test
    @Order(10)
    fun ifImageIsTest() {

        ImageFileRepository.setup(screenDirectory = TestLog.testResults.resolve("images"))

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.select("[ネットワークとインターネットアイコン]")
                        .ifImageIs("[ネットワークとインターネットアイコン].png") {
                            OK("ifImageIs called")
                        }.ifElse {
                            NG()
                        }
                    it.select("[ネットワークとインターネットアイコン]")
                        .ifImageIsNot("[ネットワークとインターネットアイコン].png") {
                            NG()
                        }.ifElse {
                            OK("ifElse が呼ばれました")
                        }
                }
            }
            case(2) {
                expectation {
                    it.select("[ネットワークとインターネットアイコン]")
                        .ifImageIs("[アプリアイコン].png") {
                            NG()
                        }.ifElse {
                            OK("ifElse が呼ばれました")
                        }
                    it.select("[ネットワークとインターネットアイコン]")
                        .ifImageIsNot("[アプリアイコン].png") {
                            OK("ifImageIsNot が呼ばれました")
                        }.ifElse {
                            NG()
                        }
                }
            }
        }
    }

}