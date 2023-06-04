package macro.ios

import shirates.core.driver.TestDrive
import shirates.core.driver.commandextension.*
import shirates.core.driver.wait
import shirates.core.macro.Macro
import shirates.core.macro.MacroObject

@MacroObject
object AppleMapsMacro : TestDrive {

    @Macro("[Appleマップトップ画面]")
    fun appleMapsToScreen() {

        it.refreshCache()

        if (it.isScreen("[Appleマップトップ画面]")) {
            return
        }

        it.pressHome()
            .pressHome()
            .launchApp("マップ")

        if (it.canSelect("後で")) {
            it.tap()
        }
        if (it.canSelect("キャンセル")) {
            it.tap()
        }
        if (it.canSelect("閉じる")) {
            it.tap()
        }
        if (it.canSelect("What’s New in Maps")) {
            it.tap("Continue")
            it.wait()
        }
        if (it.canSelect("Allow While Using App")) {
            it.tap()
        }
        it.screenIs("[Appleマップトップ画面]")
    }

}