package macro.android

import shirates.core.logging.TestLog
import shirates.core.macro.Macro
import shirates.core.macro.MacroObject

@MacroObject
object TestMacro {

    @Macro("[テストマクロ1]")
    fun testMacro1() {

        TestLog.info("[テストマクロ1]が呼ばれました。")
    }

    @Macro("[テストマクロ2]")
    fun testMacro2(arg1: String, arg2: Int) {

        TestLog.info("[テストマクロ2]が呼ばれました。(arg1=$arg1, arg2=$arg2)")
    }
}