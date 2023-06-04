package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class AssertingAnyValue1_ja : UITest() {

    @Test
    @Order(10)
    fun stringAssertion_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    "文字列１"
                        .thisIs("文字列１")
                        .thisIsNot("文字列２")

                        .thisStartsWith("文")
                        .thisStartsWithNot("字")

                        .thisContains("字列")
                        .thisContainsNot("りんご")

                        .thisEndsWith("字列１")
                        .thisEndsWithNot("字列２")

                        .thisMatches("^文字列.*")
                        .thisMatchesNot("^りんご.*")
                }
            }

            case(2) {
                expectation {
                    "".thisIsEmpty()
                    "hoge".thisIsNotEmpty()

                    " ".thisIsBlank()
                    "hoge".thisIsNotBlank()
                }
            }

        }
    }

    @Test
    @Order(20)
    fun stringAssertion_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    "文字列１"
                        .thisContains("りんご")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun booleanAssertion_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    true.thisIsTrue()
                    false.thisIsFalse()

                    true.thisIsTrue("値は true です")
                    false.thisIsFalse("値は false です")
                }
            }
            case(2) {
                expectation {
                    it.isApp("設定")
                        .thisIsTrue("アプリは <設定> です")
                    it.isApp("Chrome")
                        .thisIsFalse("アプリは <Chrome> ではありません")
                }
            }
        }
    }

    @Test
    @Order(40)
    fun booleanAssertion_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    false.thisIsTrue()
                }
            }
        }
    }
}