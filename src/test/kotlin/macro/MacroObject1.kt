package macro

import shirates.core.driver.TestDrive
import shirates.core.driver.commandextension.tap
import shirates.core.macro.Macro
import shirates.core.macro.MacroObject

@MacroObject
object MacroObject1 : TestDrive {

    @Macro("[ネットワーク設定画面]")
    fun internetScreen() {

        it.tap("ネットワークとインターネット")
            .tap("インターネット")
            .tap("ネットワーク設定")
    }

}