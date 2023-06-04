package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.describe
import shirates.core.driver.wait
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class Wait1_ja : UITest() {

    @Test
    @Order(10)
    fun wait1() {

        scenario {
            case(1) {
                action {
                    describe("短時間待ちます。")
                        .wait()
                }
            }

            case(2) {
                action {
                    describe("3.0秒待ちます。")
                        .wait(3.0)
                }
            }
        }
    }

}