package macro.android

import shirates.core.driver.TestDrive
import shirates.core.driver.branchextension.android
import shirates.core.driver.commandextension.*
import shirates.core.driver.platformMajorVersion
import shirates.core.macro.Macro
import shirates.core.macro.MacroObject

@MacroObject
object AndroidMacro : TestDrive {

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
            it.flickTopToBottom(startMarginRatio = 0.0)
                .flickTopToBottom()

            if (platformMajorVersion == 11) {
                it.select("#quick_settings_container")
                    .flickCenterToLeft()
            }

            if (canSelect("@機内モード")) {
                if (it.isChecked.not()) {
                    it.tap()
                }
                it.select("@機内モード")
                    .checkIsON()
            }
        }
    }

    @Macro("[機内モードOFF]")
    fun airplaneModeOFF() {

        android {
            it.pressHome()
                .pressHome()
            it.flickTopToBottom(startMarginRatio = 0.0)
                .flickTopToBottom()

            if (platformMajorVersion == 11) {
                it.select("#quick_settings_container")
                    .flickCenterToLeft()
            }

            if (canSelect("@機内モード")) {
                if (it.isChecked) {
                    it.tap()
                }
                it.select("@機内モード")
                    .checkIsOFF()
            }
        }
    }

}