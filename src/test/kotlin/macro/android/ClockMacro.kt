package macro.android

import shirates.core.driver.TestDrive
import shirates.core.driver.commandextension.*
import shirates.core.macro.Macro
import shirates.core.macro.MacroObject

@MacroObject
object ClockMacro : TestDrive {

    @Macro("[時計を再起動する]")
    fun restartClock() {

        it.terminateApp("com.google.android.deskclock")
            .launchApp("時計")
    }

    @Macro("[アラーム画面]")
    fun alarmScreen() {

        if (isApp("[時計]").not()) {
            restartClock()
        }
        if (isScreen("[アラーム画面]").not()) {
            it.tap("[アラームタブ]")
        }
        it.screenIs("[アラーム画面]")
    }

    @Macro("[タイマー画面]")
    fun timerScreen() {

        if (isApp("[時計]").not()) {
            restartClock()
        }
        if (isScreen("[タイマー画面]").not()) {
            it.tap("[タイマータブ]")
        }
        it.screenIs("[タイマー画面]")
    }

}