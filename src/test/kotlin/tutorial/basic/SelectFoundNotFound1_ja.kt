package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class SelectFoundNotFound1_ja : UITest() {

    @Test
    @Order(10)
    fun select_found() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    describe("select(\"ネットワークとインターネット\")")
                        .select("ネットワークとインターネット")
                }.expectation {
                    it.textIs("ネットワークとインターネット")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun select_notfound_ERROR() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    describe("select(\"no exist\")")
                        .select("no exist")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun select_notfound_empty() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    describe("select(\"システム\", throwsException = false)")
                        .select("システム", throwsException = false)
                }.expectation {
                    it.isFound.thisIsFalse("要素が見つかりません")
                    it.isEmpty.thisIsTrue("空要素です")
                    it.hasError.thisIsTrue("hasError is true")
                }
            }
        }
    }

    @Test
    @Order(40)
    fun selectWithScrollDown_found() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    describe("selectWithScrollDown(\"システム\")")
                        .selectWithScrollDown("システム")
                }.expectation {
                    it.isFound.thisIsTrue("${it.selector} が見つかりました")
                }
            }
        }
    }

    @Test
    @Order(50)
    fun selectWithScrollDown_notfound() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    describe("selectWithScrollDown(\"no exist\")")
                        .selectWithScrollDown("no exist", throwsException = false)
                }.expectation {
                    it.isFound.thisIsFalse("${it.selector} が見つかりませんでした")
                }
            }
        }
    }

}