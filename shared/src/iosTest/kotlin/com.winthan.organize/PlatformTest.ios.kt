import com.winthan.organize.Platform
import kotlin.test.Test
import kotlin.test.assertTrue

@kotlinx.cinterop.ExperimentalForeignApi
@kotlin.experimental.ExperimentalNativeApi
actual class PlatformTest {

    private val platform = Platform()

    @Test
    actual fun testOperationSystemName() {
        assertTrue(
            actual = platform.osName.equals("iOS", ignoreCase = true)
                    || platform.osName == "iPadOS",
            message = "The OS name should either be iOS or iPadOS."
        )
    }

}