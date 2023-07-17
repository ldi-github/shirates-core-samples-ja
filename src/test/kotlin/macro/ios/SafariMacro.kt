package macro.ios

import shirates.core.driver.TestDriver.it
import shirates.core.driver.commandextension.*
import shirates.core.macro.Macro
import shirates.core.macro.MacroObject

@MacroObject
object SafariMacro {

    @Macro("[Safari画面]")
    fun safariScreen() {

        it.refreshCache()

        if (it.isScreen("[Safari画面]")) {
            return
        }

        it.launchApp("Safari")
        if (it.canSelect("Cancel")) {
            it.tap()
        }
        it.screenIs("[Safari画面]")
    }

}