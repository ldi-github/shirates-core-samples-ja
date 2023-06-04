package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.branchextension.osaifuKeitai
import shirates.core.driver.branchextension.osaifuKeitaiNot
import shirates.core.driver.commandextension.describe
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class OsaifuKeitai1_ja : UITest() {

    @Test
    @Order(10)
    fun osaifuKeitai1() {

        scenario {
            case(1) {
                action {
                    osaifuKeitai {
                        describe("おサイフケータイが有効です")
                    }
                    osaifuKeitaiNot {
                        describe("おサイフケータイが無効です")
                    }
                }
            }
        }
    }

}