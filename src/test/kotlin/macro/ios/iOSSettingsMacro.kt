package macro.ios

import shirates.core.driver.TestDriver.it
import shirates.core.driver.commandextension.*
import shirates.core.macro.Macro
import shirates.core.macro.MacroObject

@MacroObject
object iOSSettingsMacro {

    @Macro("[iOS設定トップ画面]")
    fun iosSettingsTopScreen() {

        it.refreshCache()

        if (it.isScreen("[iOS設定トップ画面]")) {
            if (it.canSelect("一般").not()) {
                it.flickAndGoUp()
            }
            return
        }

        it.restartApp("[設定]")
            .screenIs("[iOS設定画面]")
    }

    @Macro("[デベロッパ画面]")
    fun developerScreen() {

        it.refreshCache()

        if (it.isScreen("[デベロッパ画面]")) {
            if (it.canSelect("設定")) {
                return
            }
            it.flickTopToBottom()
            if (it.canSelect("設定")) {
                return
            }
        }

        iosSettingsTopScreen()
        it.tapWithScrollDown("デベロッパ")
            .screenIs("[デベロッパ画面]")
    }

    @Macro("[一般画面]")
    fun settingsGeneralScreen() {

        it.refreshCache()

        if (it.isScreen("[一般画面]")) {
            return
        }

        iosSettingsTopScreen()
        it.tapWithScrollDown("一般")
            .screenIs("[一般画面]")
    }

    @Macro("[キーボード画面]")
    fun iosKeyboardScreen() {

        it.refreshCache()

        if (it.isScreen("[キーボード画面]")) {
            if (it.canSelect(".XCUIElementTypeCell&&Keyboards")) {
                return
            }
            it.flickTopToBottom()
            if (it.canSelect(".XCUIElementTypeCell&&Keyboards")) {
                return
            }
        }

        settingsGeneralScreen()
        it.tapWithScrollDown("キーボード")
            .screenIs("[キーボード画面]")
    }
}