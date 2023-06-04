package tutorial.inaction

import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.TestElement
import shirates.core.driver.commandextension.*
import shirates.core.driver.rootElement
import shirates.core.driver.wait
import shirates.core.logging.TestLog
import shirates.core.testcode.UITest
import shirates.core.utility.toPath
import java.nio.file.Files
import java.nio.file.StandardCopyOption

@Testrun("testConfig/android/マップ/testrun.properties")
class CroppingImages1_ja : UITest() {

    @Test
    fun croppingMapsImages() {

        scenario {
            case(1) {
                condition {
                    it.terminateApp()
                    it.macro("[マップトップ画面]")
                        .screenIs("[マップトップ画面]")
                        .wait()     // アニメーションが終了するのを待ちます
                }.action {
                    rootElement.cropImage("[マップトップ画面].png")
                    it.select("[スポットタブ]").cropAndCopy("[スポットタブ(選択状態)].png")
                    it.select("[経路タブ]").cropAndCopy("[経路タブ画像].png")
                    it.select("[保存済みタブ]").cropAndCopy("[保存済みタブ].png")
                    it.select("[投稿タブ]").cropAndCopy("[投稿タブ].png")
                    it.select("[お知らせタブ]").cropAndCopy("[お知らせタブ].png")
                }
            }
            case(2) {
                action {
                    it.tap("[経路タブ]")
                        .screenIs("[マップ経路画面]")
                        .wait()
                    it.select("[スポットタブ]").cropAndCopy("[スポットタブ].png")
                    it.select("[経路タブ]").cropAndCopy("[経路タブ(選択状態)].png")
                }
            }
            case(3) {
                action {
                    it.tap("[保存済みタブ]")
                        .wait()     // アニメーションが終了するのを待ちます
                    it.select("[保存済みタブ]").cropAndCopy("[保存済みタブ(選択状態)].png")
                }
            }
            case(4) {
                action {
                    it.tap("[投稿タブ]")
                        .wait()     // アニメーションが終了するのを待ちます
                    it.select("[投稿タブ]").cropAndCopy("[投稿タブ(選択状態)].png")
                }
            }
            case(5) {
                action {
                    it.tap("[お知らせタブ]")
                        .wait()     // アニメーションが終了するのを待ちます
                    it.select("[お知らせタブ]").cropAndCopy("[お知らせタブ(選択状態)].png")
                }
            }
        }
    }

    private fun TestElement.cropAndCopy(fileName: String) {

        this.cropImage(fileName = fileName)

        val targetDir = "testConfig/android/マップ/screens/images".toPath()
        if (Files.exists(targetDir).not()) {
            Files.createDirectory(targetDir)
        }
        val source = TestLog.directoryForLog.resolve(fileName)
        val target = targetDir.resolve(fileName)
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING)
    }

}