package macro.android

import shirates.core.driver.TestDrive
import shirates.core.driver.commandextension.*
import shirates.core.macro.Macro
import shirates.core.macro.MacroObject

@MacroObject
object CalculatorMacro : TestDrive {

    @Macro("[電卓を再起動する]")
    fun restartCalculator() {

        it.terminateApp("com.google.android.calculator")
            .launchApp("電卓")
            .screenIs("[電卓メイン画面]")
    }

    @Macro("[電卓メイン画面]")
    fun calculatorMainScreen() {

        it.refreshCache()

        if (it.isScreen("[電卓メイン画面]")) {
            return
        }

        it.restartApp()
        if (it.isScreen("[電卓メイン画面]")) {
            return
        }

        restartCalculator()
    }
}