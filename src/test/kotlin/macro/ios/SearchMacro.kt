package macro.ios

import shirates.core.driver.TestDriver.it
import shirates.core.driver.commandextension.*
import shirates.core.macro.Macro
import shirates.core.macro.MacroObject

@MacroObject
object SearchMacro {

    @Macro("[iOS検索画面]")
    fun iosSearchScreen() {

        it.refreshCache()

        if (it.isScreen("[iOS検索画面]")) {
            return
        }
        it.restartApp()
            .pressHome()
            .flickCenterToBottom()
            .screenIs("[iOS検索画面]")
    }

}