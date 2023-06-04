package macro.android

import shirates.core.driver.TestDrive
import shirates.core.driver.commandextension.isScreen
import shirates.core.driver.commandextension.launchApp
import shirates.core.driver.commandextension.refreshCache
import shirates.core.driver.commandextension.screenIs
import shirates.core.macro.Macro
import shirates.core.macro.MacroObject

@MacroObject
object PlayStoreMacro : TestDrive {

    @Macro("[Play ストア画面]")
    fun playStoreScreen() {

        it.refreshCache()

        if (it.isScreen("[Play ストア画面]")) {
            return
        }

        it.launchApp("Play ストア")
            .screenIs("[Play ストア画面]")
    }

}