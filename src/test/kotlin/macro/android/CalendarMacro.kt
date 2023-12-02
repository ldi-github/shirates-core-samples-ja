package macro.android

import shirates.core.driver.TestDrive
import shirates.core.driver.branchextension.ifScreenIs
import shirates.core.driver.commandextension.*
import shirates.core.macro.Macro
import shirates.core.macro.MacroObject

@MacroObject
object CalendarMacro : TestDrive {

    @Macro("[カレンダーを再起動する]")
    fun restartCalendar() {

        it.terminateApp("com.google.android.calendar")
            .launchApp("カレンダー")
        skipWelcomeScreen()
    }

    @Macro("[毎日を有意義に過ごしましょう画面をスキップする]")
    fun skipWelcomeScreen() {

        ifScreenIs("[毎日を有意義に過ごしましょう画面]") {
            it.tap("[>]")
        }
        ifScreenIs("[さらに見やすく魅力的なデザイン画面]") {
            it.tap("[終了]")
        }
    }

    @Macro("[カレンダー週画面]")
    fun calendarWeekScreen() {

        it.restartApp()

        if (isScreen("[カレンダー週画面]")) {
            return
        }
        ifScreenIs("[毎日を有意義に過ごしましょう画面]") {
            skipWelcomeScreen()
        }
        if (it.canSelect("@カレンダーリストと設定ドロワーを表示する").not()) {
            restartCalendar()
        }

        it.tap("@カレンダーリストと設定ドロワーを表示する")
            .tap("週")

        it.screenIs("[カレンダー週画面]")
    }
}