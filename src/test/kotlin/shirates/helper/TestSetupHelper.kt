package shirates.helper

import shirates.core.driver.TestDrive
import shirates.core.driver.TestElement
import shirates.core.driver.branchextension.emulator
import shirates.core.driver.branchextension.realDevice
import shirates.core.driver.commandextension.*
import shirates.core.logging.TestLog
import shirates.core.utility.image.saveImage
import java.io.File
import java.nio.file.Files

object TestSetupHelper : TestDrive {

    /**
     * Setup Image Android Settings Top Screen
     */
    fun setupImageAndroidSettingsTopScreen() {

        val path = "images/androidSettingsTopScreen"
        val dir = TestLog.testResults.resolve(path)
        if (Files.exists(dir).not()) File(dir.toUri()).mkdirs()

        fun crop(nickname: String) {
            it.selectWithScrollDown(nickname)
                .cropImage()
                .lastCropInfo!!.croppedImage!!
                .saveImage(TestLog.testResults.resolve("$path/$nickname").toString())
        }

        it.macro("[Android設定トップ画面]")

        crop("[ネットワークとインターネットアイコン]")
        crop("[接続済みのデバイスアイコン]")
        crop("[アプリアイコン]")
        crop("[通知アイコン]")
        crop("[バッテリーアイコン]")
        crop("[ストレージアイコン]")
        crop("[着信音とバイブレーションアイコン]")
        crop("[ディスプレイアイコン]")
        crop("[壁紙とスタイルアイコン]")
        crop("[ユーザー補助アイコン]")
        crop("[セキュリティアイコン]")
        crop("[プライバシーアイコン]")
        crop("[位置情報アイコン]")
        crop("[緊急情報と緊急通報アイコン]")
        crop("[パスワードとアカウントアイコン]")
        crop("[Googleアイコン]")
        crop("[システムアイコン]")
        realDevice {
            crop("[デバイス情報アイコン]")
        }
        emulator {
            crop("[エミュレートされたデバイスについてアイコン]")
        }
        crop("[ヒントとサポートアイコン]")
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

}