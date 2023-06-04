package macro.android

import shirates.core.driver.TestDrive
import shirates.core.driver.branchextension.ifCanSelect
import shirates.core.driver.commandextension.*
import shirates.core.driver.waitForDisplay
import shirates.core.macro.Macro
import shirates.core.macro.MacroObject

@MacroObject
object MapsMacro : TestDrive {

    @Macro("[マップトップ画面]")
    fun mapsTopScreen() {

        if (it.isScreen("[マップトップ画面]")) {
            return
        }

        it.terminateApp("com.google.android.apps.maps")
            .launchApp("マップ")
            .ifCanSelect("*to send you notifications?") {
                it.tap("Allow")
            }
            .ifCanSelect("地図をカスタマイズしよう") {
                it.tap("スキップ")
            }
            .waitForDisplay("#map_frame")

        if (it.isScreen("[マップトップ画面]")) {
            return
        }

        it.tapCenterOfScreen()
        if (it.isScreen("[マップトップ画面]")) {
            return
        }

        it.tapCenterOfScreen()
        if (it.isScreen("[マップトップ画面]")) {
            return
        }

        it.screenIs("[マップトップ画面]")
    }
}