package shirates.helper

import shirates.core.driver.*
import shirates.core.driver.branchextension.emulator
import shirates.core.driver.branchextension.realDevice
import shirates.core.driver.commandextension.*
import shirates.core.logging.TestLog
import shirates.core.utility.image.saveImage
import shirates.core.utility.toPath
import java.io.File
import java.nio.file.Files
import java.nio.file.Path

object ImageSetupHelper : TestDrive {

    fun TestElement.cropTo(dir: Path, fileName: String? = null) {
        val baseFileName = selector.toString()
        val suffix = testDrive.imageProfile
        val fname = fileName ?: "$baseFileName$suffix"
        this.cropImage()
            .lastCropInfo!!.croppedImage!!
            .saveImage(dir.resolve(fname).toString())
    }

    /**
     * Android設定トップ画面をセットアップする
     */
    fun setupImageAndroidSettingsTopScreen() {

        if (TestMode.isNoLoadRun) {
            return
        }

        val dir = "testConfig/android/設定/screens/images/Android設定トップ画面".toPath()
        if (Files.exists(dir).not()) dir.toFile().mkdirs()

        it.macro("[Android設定トップ画面]")

        withScrollDown {
            select("[ネットワークとインターネットアイコン]").cropTo(dir)
            select("[接続設定アイコン]").cropTo(dir)
            select("[アプリアイコン]").cropTo(dir)
            select("[通知アイコン]").cropTo(dir)
            select("[バッテリーアイコン]").cropTo(dir)
            select("[ストレージアイコン]").cropTo(dir)
            select("[音とバイブレーションアイコン]").cropTo(dir)
            select("[ディスプレイアイコン]").cropTo(dir)
            select("[壁紙とスタイルアイコン]").cropTo(dir)
            select("[ユーザー補助アイコン]").cropTo(dir)
            select("[セキュリティとプライバシーアイコン]").cropTo(dir)
            select("[位置情報アイコン]").cropTo(dir)
            select("[安全性と緊急情報アイコン]").cropTo(dir)
            select("[パスワードとアカウントアイコン]").cropTo(dir)
            select("[Digital Wellbeing と保護者による使用制限アイコン]").cropTo(dir)
            select("[Googleアイコン]").cropTo(dir)
            select("[システムアイコン]").cropTo(dir)
            realDevice {
                select("[デバイス情報アイコン]").cropTo(dir)
            }
            emulator {
                select("[エミュレートされたデバイスについてアイコン]").cropTo(dir)
            }
            select("[ヒントとサポートアイコン]").cropTo(dir)
        }
    }

    /**
     * カレンダー周情報画面の画像をセットアップする
     */
    fun setupImageCalendarWeekScreen() {

        val path = "images/calendarWeekScreen"
        val dir = TestLog.testResults.resolve(path)
        if (Files.exists(dir).not()) File(dir.toUri()).mkdirs()

        fun TestElement.crop(fileName: String) {

            cropImage()
                .lastCropInfo!!.croppedImage!!
                .saveImage(TestLog.testResults.resolve("$path/$fileName").toString())
        }

        fun TestElement.cropItems(dayN: String): List<TestElement> {

            val items = this.children.filter { it.contentDesc.contains("[スケジュール]ビューを開く") }
            for (i in 1..items.count()) {
                items[i - 1].crop("[Day$dayN-$i].png")
            }
            return items
        }

        it.macro("[カレンダ週ー週画面]")
        it.select(".android.support.v7.widget.RecyclerView") {
            cropItems("1")
        }
        it.swipeToLeft()
        it.select(".android.support.v7.widget.RecyclerView") {
            cropItems("2")
        }
        it.swipeToLeft()
        it.select(".android.support.v7.widget.RecyclerView") {
            cropItems("3")
        }
    }

    /**
     * マップトップ画面の画像をセットアップする
     */
    fun SetupImagesMapsTopScreen() {

        it.macro("[マップトップ画面]")
            .screenIs("[マップトップ画面]")
        val dir = "testConfig/android/マップ/screens/images/マップトップ画面".toPath()
        if (Files.exists(dir).not()) dir.toFile().mkdirs()

        rootElement.cropImage("[マップトップ画面].png")
        it.select("[スポットタブ(選択状態)]").cropTo(dir)
        it.select("[投稿タブ]").cropTo(dir)

        it.tap("[投稿タブ]")
            .wait()
        it.select("[スポットタブ]").cropTo(dir)
        it.select("[投稿タブ(選択状態)]").cropTo(dir)
    }
}