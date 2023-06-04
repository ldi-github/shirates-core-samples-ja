package macro.ios

import shirates.core.driver.TestDriver.it
import shirates.core.driver.commandextension.pressHome
import shirates.core.macro.Macro
import shirates.core.macro.MacroObject

@MacroObject
object iOSMacro {

    @Macro("[iOSホーム画面]")
    fun iOSHomeScreen() {

        it.pressHome()
            .pressHome()
    }

}