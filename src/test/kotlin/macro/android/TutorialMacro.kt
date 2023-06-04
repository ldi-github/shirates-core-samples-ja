package macro.android

import shirates.core.driver.TestDrive
import shirates.core.macro.Macro
import shirates.core.macro.MacroObject

/**
 * このマクロはデモンストレーション用です
 */
@MacroObject
object TutorialMacro : TestDrive {

    @Macro("[在庫設定]")
    fun setupStock() {

        // 手順を実装します
    }

    @Macro("[ログイン]")
    fun login() {

        // 手順を実装します
    }

    @Macro("[受注画面]")
    fun orderScreen() {

        // 手順を実装します
    }

}