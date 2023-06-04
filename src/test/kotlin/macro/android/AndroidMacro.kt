package macro.android

import shirates.core.driver.TestDrive
import shirates.core.driver.branchextension.android
import shirates.core.driver.branchextension.ifStringIs
import shirates.core.driver.commandextension.*
import shirates.core.driver.platformVersion
import shirates.core.driver.viewport
import shirates.core.exception.TestConfigException
import shirates.core.macro.Macro
import shirates.core.macro.MacroObject

@MacroObject
object AndroidMacro: TestDrive {

    @Macro("[Androidホーム画面]")
    fun androidHomeScreen() {

        it.pressHome()
            .pressHome()
    }

    @Macro("[機内モードON]")
    fun airplaneModeON() {

        android {
            it.pressHome()
                .pressHome()
            it.swipePointToPoint(
                startX = 20,
                startY = 10,
                endX = 20,
                endY = viewport.bottom
            )
            if ((platformVersion.toIntOrNull() ?: 0) < 12) {
                throw TestConfigException("Android 12以上を使用してください。")
            }
            it.swipePointToPoint(
                startX = 20,
                startY = 10,
                endX = 20,
                endY = viewport.bottom
            )
            it.select("@機内モード")
                .text
                .ifStringIs("OFF") {
                    it.tap()
                }
            it.select("@機内モード")
                .textIs("ON")
            it.pressHome()
        }
    }

    @Macro("[機内モードOFF]")
    fun airplaneModeOFF() {

        android {
            it.pressHome()
                .pressHome()
            it.swipePointToPoint(
                startX = 20,
                startY = 10,
                endX = 20,
                endY = viewport.bottom
            )
            if ((platformVersion.toIntOrNull() ?: 0) < 12) {
                throw TestConfigException("Use android 12 or greater")
            }
            it.swipePointToPoint(
                startX = 20,
                startY = 10,
                endX = 20,
                endY = viewport.bottom
            )

            it.select("@機内モード")
                .text
                .ifStringIs("ON") {
                    it.tap()
                }
            it.select("@機内モード")
                .textIs("OFF")
            it.pressHome()
        }

    }

}