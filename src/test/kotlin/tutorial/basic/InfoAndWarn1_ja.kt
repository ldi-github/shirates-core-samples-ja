package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.logging.TestLog.info
import shirates.core.logging.TestLog.warn
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class InfoAndWarn1_ja : UITest() {

    @Test
    @Order(10)
    fun infoAndWarn1() {

        scenario {
            case(1) {
                action {
                    info("ニックネームは、テストコードを読みやすく、理解しやすくするためのShiratesの重要なコンセプトの1つです。画面、要素、アプリ、テストデータ項目に対してニックネームをニックネームファイルに定義し、テストコードで使用することができます。ニックネームを使ったメッセージは、自然言語として読むことができるほど使いやすいです。特に画面要素では、要素を見つけるための実装の複雑さをニックネームで隠蔽し、AndroidプラットフォームとiOSプラットフォームの違いを吸収することができます。その結果、あるプラットフォーム用のテストコードを書いた後、他のプラットフォームへのギャップを埋めるための追加や修正を少しの手間で行うことができます。")
                    warn("ニックネームは、テストコードを読みやすく、理解しやすくするためのShiratesの重要なコンセプトの1つです。画面、要素、アプリ、テストデータ項目に対してニックネームをニックネームファイルに定義し、テストコードで使用することができます。ニックネームを使ったメッセージは、自然言語として読むことができるほど使いやすいです。特に画面要素では、要素を見つけるための実装の複雑さをニックネームで隠蔽し、AndroidプラットフォームとiOSプラットフォームの違いを吸収することができます。その結果、あるプラットフォーム用のテストコードを書いた後、他のプラットフォームへのギャップを埋めるための追加や修正を少しの手間で行うことができます。")
                }
            }
        }
    }

}