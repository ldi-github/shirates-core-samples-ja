package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.macro
import shirates.core.driver.commandextension.sendKeys
import shirates.core.driver.commandextension.tap
import shirates.core.driver.commandextension.textIs
import shirates.core.storage.data
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class Data1_ja : UITest() {

    @Test
    @Order(10)
    fun data1() {

        scenario {
            case(1) {
                condition {
                    it.macro("[設定を検索画面]")
                        .tap("[検索ボックス]")
                }.action {
                    it.sendKeys(data("[製品1].製品名"))
                }.expectation {
                    it.textIs("スーパーハイテンション")
                }
            }
        }

    }
}