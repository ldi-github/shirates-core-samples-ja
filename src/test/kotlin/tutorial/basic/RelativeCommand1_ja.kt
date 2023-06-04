package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.driver.commandextension.*
import shirates.core.testcode.UITest

@Testrun("testConfig/android/設定/testrun.properties")
class RelativeCommand1_ja : UITest() {

    @Test
    @Order(10)
    fun relative_direction() {

        scenario {
            case(1) {
                condition {
                    it.macro("[壁紙画面]")
                }.expectation {
                    it.exist("都市景観")
                        .relative(":right").textIs("暮らし")
                    it.select("都市景観")
                        .relative(":right(2)").textIs("テクスチャ")
                    it.select("都市景観")
                        .relative(":right(100)").thisIsEmpty()
                    it.select("都市景観")
                        .relative(":belowImage").classIs("android.widget.ImageView")
                }
            }
            case(2) {
                expectation {
                    it.exist("都市景観")
                        .right().textIs("暮らし")
                    it.select("都市景観")
                        .right(2).textIs("テクスチャ")
                    it.select("都市景観")
                        .right(100).thisIsEmpty()
                    it.select("都市景観")
                        .belowImage().classIs("android.widget.ImageView")
                }
            }
            case(3) {
                expectation {
                    it.exist("都市景観") {
                        right().textIs("暮らし")
                        right(2).textIs("テクスチャ")
                        right(100).thisIsEmpty()
                        aboveImage().classIs("android.widget.ImageView")
                    }
                }
            }
        }
    }

    @Test
    @Order(20)
    fun relative_flow() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.exist("ネットワークとインターネット")
                        .relative(":flow").textIs("モバイル、Wi-Fi、アクセス ポイント")
                        .relative(":flow").classIs("android.widget.ImageView")
                        .relative(":flow").textIs("接続済みのデバイス")
                        .relative(":flow").textIs("Bluetooth、ペア設定")
                        .relative(":flow").classIs("android.widget.ImageView")
                }
            }
            case(2) {
                expectation {
                    it.exist("ネットワークとインターネット")
                        .flow().textIs("モバイル、Wi-Fi、アクセス ポイント")
                        .flow().classIs("android.widget.ImageView")
                        .flow().textIs("接続済みのデバイス")
                        .flow().textIs("Bluetooth、ペア設定")
                        .flow().classIs("android.widget.ImageView")
                }
            }
            case(3) {
                expectation {
                    it.exist("ネットワークとインターネット") {
                        flow().textIs("モバイル、Wi-Fi、アクセス ポイント")
                        flow(2).classIs("android.widget.ImageView")
                        flow(3).textIs("接続済みのデバイス")
                        flow(4).textIs("Bluetooth、ペア設定")
                        flow(5).classIs("android.widget.ImageView")
                    }
                }
            }
        }
    }

    @Test
    @Order(30)
    fun relative_vflow() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.exist("ネットワークとインターネット")
                        .relative(":vflow").textIs("モバイル、Wi-Fi、アクセス ポイント")
                        .relative(":vflow").textIs("接続済みのデバイス")
                        .relative(":vflow").textIs("Bluetooth、ペア設定")
                        .relative(":vflow").textIs("アプリ")
                }
            }
            case(2) {
                expectation {
                    it.exist("ネットワークとインターネット")
                        .vflow().textIs("モバイル、Wi-Fi、アクセス ポイント")
                        .vflow().textIs("接続済みのデバイス")
                        .vflow().textIs("Bluetooth、ペア設定")
                        .vflow().textIs("アプリ")
                }
            }
            case(3) {
                expectation {
                    it.exist("ネットワークとインターネット") {
                        vflow().textIs("モバイル、Wi-Fi、アクセス ポイント")
                        vflow(2).textIs("接続済みのデバイス")
                        vflow(3).textIs("Bluetooth、ペア設定")
                        vflow(4).textIs("アプリ")
                    }
                }
            }
        }
    }

    @Test
    @Order(40)
    fun relative_xml() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.exist("ネットワークとインターネット").parent()
                        .apply {
                            relative(":child").textIs("ネットワークとインターネット")
                            relative(":child(2)").textIs("モバイル、Wi-Fi、アクセス ポイント")
                        }
                }
            }
            case(2) {
                expectation {
                    it.exist("ネットワークとインターネット").parent()
                        .apply {
                            child().textIs("ネットワークとインターネット")
                            child(2).textIs("モバイル、Wi-Fi、アクセス ポイント")
                        }
                }
            }
        }
    }

    @Test
    @Order(50)
    fun relative_nickname() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.exist("ネットワークとインターネット")
                        .exist("[:Summary]").textIs("モバイル、Wi-Fi、アクセス ポイント")
                }
            }
            case(2) {
                expectation {
                    /**
                     * See nickname definition in testConfig/android/設定/screens/[Android設定トップ画面].json

                    "[:Summary]": ":belowLabel"

                     */
                    it.exist("[ネットワークとインターネット]")
                        .exist("[:Summary]").textIs("モバイル、Wi-Fi、アクセス ポイント")
                }
            }
        }

    }
}