package tutorial.basic

import org.apache.commons.io.FileUtils
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.TestElement
import shirates.core.driver.commandextension.*
import shirates.core.logging.TestLog
import shirates.core.testcode.UITest
import java.io.File
import java.nio.file.Path

@Testrun("unittestConfig/android/設定/testrun.properties")
class FindImage1_prepare_ja : UITest() {

    private fun TestElement.cropAndCopy(fileName: String, directory: Path = TestLog.directoryForLog): TestElement {

        this.cropImage(fileName)
        FileUtils.copyFile(
            directory.resolve(fileName).toFile(),
            File("unittestConfig/android/設定/screens/images/$fileName")
        )
        return this
    }

    @Test
    fun prepareImage() {

        scenario {
            condition {
                it.screenIs("[Android設定トップ画面]")
            }.action {
                it.select("ネットワークとインターネット").leftImage().cropAndCopy("ネットワークとインターネット.png")
                it.selectWithScrollDown("ディスプレイ").leftImage().cropAndCopy("ディスプレイ.png")
                it.selectWithScrollDown("ヒントとサポート").leftImage().cropAndCopy("ヒントとサポート.png")
            }
        }
    }
}