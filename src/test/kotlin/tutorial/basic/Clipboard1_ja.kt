package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.driver.function.readClipboard
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class Clipboard1_ja : UITest() {

    @Test
    @Order(10)
    fun element_clipboard() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.select("設定")
                        .clipboardText()
                }.expectation {
                    readClipboard()
                        .thisIs("設定")
                }
            }
            case(2) {
                condition {
                    it.exist("[ネットワークとインターネット]")
                }.action {
                    it.clipboardText()
                }.expectation {
                    readClipboard()
                        .thisIs("ネットワークとインターネット")
                }
            }
        }

    }

    @Test
    @Order(20)
    fun string_clipboard() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    "文字列1".writeToClipboard()
                }.expectation {
                    readClipboard()
                        .thisIs("文字列1")
                }
            }
        }

    }

}