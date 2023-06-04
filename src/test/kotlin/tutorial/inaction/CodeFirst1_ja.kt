package tutorial.inaction

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import shirates.core.configuration.Testrun
import shirates.core.testcode.NoLoadRun
import shirates.core.testcode.UITest

@Testrun("testConfig/android/電卓/testrun.properties")
class CodeFirst1_ja : UITest() {

    @NoLoadRun
    @Test
    @DisplayName("電卓を起動")
    fun A0010() {

        scenario {

        }
    }

    @NoLoadRun
    @Test
    @DisplayName("足し算")
    fun A0020() {

        scenario {

        }
    }

    @NoLoadRun
    @Test
    @DisplayName("ゼロ除算")
    fun A0030() {

        scenario {

        }
    }

}