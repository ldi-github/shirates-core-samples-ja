package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.storage.account
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class Account1_ja : UITest() {

    @Test
    @Order(10)
    fun account() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .tap("[設定を検索]")
                        .screenIs("[設定を検索画面]")
                        .tap("[検索ボックス]")
                }.action {
                    it.sendKeys(account("[アカウント1].ID"))
                }.expectation {
                    it.textIs(account("[アカウント1].ID"))
                }
            }
        }

    }
}