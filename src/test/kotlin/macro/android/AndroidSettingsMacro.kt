package macro.android

import shirates.core.driver.TestDrive
import shirates.core.driver.commandextension.*
import shirates.core.macro.Macro
import shirates.core.macro.MacroObject

@MacroObject
object AndroidSettingsMacro : TestDrive {

    @Macro("[Android設定トップ画面]")
    fun androidSettingsTopScreen() {

        if (it.isScreen("[Android設定トップ画面]")) {
            it.selectWithScrollUp("設定")
            return
        }

        it.restartApp()
            .launchApp("設定")
            .screenIs("[Android設定トップ画面]")

        if (canSelect("[アカウントアバター]").not()) {
            it.flickAndGoUp()
        }
    }

    @Macro("[設定を検索画面]")
    fun androidSearchSettingsScreen() {

        if (it.isScreen("[設定を検索画面]")) {
            return
        }

        androidSettingsTopScreen()
        it.tap("[設定を検索]")
            .screenIs("[設定を検索画面]")
    }

    @Macro("[ネットワークとインターネット画面]")
    fun networkAndInternetScreen() {

        if (it.isScreen("[ネットワークとインターネット画面]")) {
            it.flickTopToBottom()
            return
        }

        androidSettingsTopScreen()
        it.tap("ネットワークとインターネット")
            .screenIs("[ネットワークとインターネット画面]")
    }

    @Macro("[Internet Screen]")
    fun internetScreen() {

        if (it.isScreen("[インターネット画面]")) {
            it.flickTopToBottom()
            return
        }

        networkAndInternetScreen()
        it.tap("インターネット")
            .screenIs("[インターネット画面]")
    }

    @Macro("[接続済みのデバイス画面]")
    fun connectedDevicesScreen() {

        if (it.isScreen("[接続済みのデバイス画面]")) {
            it.flickTopToBottom()
            return
        }

        androidSettingsTopScreen()
        it.tapWithScrollDown("接続済みのデバイス")
            .screenIs("[接続済みのデバイス画面]")
    }

    @Macro("[バッテリー画面]")
    fun batteryScreen() {

        if (it.isScreen("[バッテリー画面]")) {
            it.flickTopToBottom()
            return
        }

        androidSettingsTopScreen()
        it.tapWithScrollDown("バッテリー")
            .screenIs("[バッテリー画面]")
    }

    @Macro("[壁紙画面]")
    fun wallpaperScreen() {

        if (it.isScreen("[壁紙画面]")) {
            return
        }

        androidSettingsTopScreen()
        it.tapWithScrollDown("壁紙とスタイル")
            .tap("壁紙の変更")
            .screenIs("[壁紙画面]")
    }

    @Macro("[ユーザー補助画面]")
    fun accessibilityScreen() {

        if (it.isScreen("[ユーザー補助画面]")) {
            it.flickTopToBottom()
            return
        }

        androidSettingsTopScreen()
        it.tapWithScrollDown("ユーザー補助")
            .screenIs("[ユーザー補助画面]")
    }

    @Macro("[システム画面]")
    fun systemScreen() {

        if (it.isScreen("[システム画面]")) {
            it.flickTopToBottom()
        }

        androidSettingsTopScreen()
        it.flickBottomToTop()
            .tapWithScrollDown("[システム]")
            .screenIs("[システム画面]")
    }

    @Macro("[開発者向けオプション画面]")
    fun developerOptionsScreen() {

        systemScreen()
        it.tapWithScrollDown("開発者向けオプション")
            .screenIs("[開発者向けオプション画面]")
    }
}