package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.imageIs
import shirates.core.driver.commandextension.imageIsNot
import shirates.core.driver.commandextension.macro
import shirates.core.driver.commandextension.select
import shirates.core.driver.platformVersion
import shirates.core.testcode.UITest

@Testrun("testConfig/android/マップ/testrun.properties")
class AssertingAnyValue2_ja : UITest() {

    @Test
    @Order(10)
    fun imageIs_OK() {

        scenario {
            case(1) {
                condition {
                    if ((platformVersion.toIntOrNull() ?: 0) < 12) {
                        SKIP_SCENARIO("このテストシナリオはAndroid 12以上が必要です。 (actual=$platformVersion)")
                    }
                    it.macro("[マップトップ画面]")
                }.expectation {
                    it.select("[スポットタブ]")
                        .imageIs("image=[スポットタブ(選択状態)].png")
                        .imageIsNot("image=[スポットタブ].png")

                        .imageIs("[スポットタブ(選択状態)].png")
                        .imageIsNot("[スポットタブ].png")

                        .imageIs("[スポットタブ画像(選択状態)]")
                        .imageIsNot("[スポットタブ画像]")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun imageAssertion_NG() {

        scenario {
            case(1) {
                condition {
                    if ((platformVersion.toIntOrNull() ?: 0) < 12) {
                        SKIP_SCENARIO("このテストシナリオはAndroid 12以上が必要です。 (actual=$platformVersion)")
                    }
                    it.macro("[マップトップ画面]")
                }.expectation {
                    it.select("[スポットタブ]")
                        .imageIs("[スポットタブ(選択状態)].png")     // OK
                        .imageIs("[スポットタブ].png")       // NG
                }
            }
        }
    }

    @Test
    @Order(30)
    fun imageAssertion_NG_2() {

        scenario {
            case(1) {
                condition {
                    if ((platformVersion.toIntOrNull() ?: 0) < 12) {
                        SKIP_SCENARIO("このテストシナリオはAndroid 12以上が必要です。 (actual=$platformVersion)")
                    }
                    it.macro("[マップトップ画面]")
                }.expectation {
                    it.select("[スポットタブ]")
                        .imageIsNot("[スポットタブ].png")    // OK
                        .imageIsNot("[スポットタブ(選択状態)].png")  // NG
                }
            }
        }
    }

}