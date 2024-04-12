package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.TestElementCache
import shirates.core.driver.commandextension.appIs
import shirates.core.driver.commandextension.macro
import shirates.core.driver.commandextension.screenIs
import shirates.core.driver.commandextension.verify
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class AssertingAnything1_ja : UITest() {

    @Test
    @Order(10)
    fun ok() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.verify("packageNameが\"com.android.settings\"であること") {
                        if (TestElementCache.rootElement.packageName == "com.android.settings") {
                            OK()
                        } else {
                            NG()
                        }
                    }
                    it.verify("アプリが'設定' かつ 画面が[Android設定トップ画面]であること") {
                        it.appIs("設定")
                        it.screenIs("[Android設定トップ画面]")
                    }
                }
            }
        }
    }

    @Test
    @Order(20)
    fun ng() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.verify("アプリが'Settings2' かつ 画面が[Android設定トップ画面]であること") {
                        it.appIs("Settings2")
                        it.screenIs("[Android設定トップ画面]")
                    }
                }
            }
        }
    }

    @Test
    @Order(30)
    fun notImplemented() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.verify("アプリが'設定' かつ 画面が[Android設定トップ画面]であること") {
                    }
                }
            }
        }
    }
}