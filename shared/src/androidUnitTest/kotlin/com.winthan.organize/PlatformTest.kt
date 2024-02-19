import com.winthan.organize.Platform
import org.junit.Test
import kotlin.test.assertEquals

actual class PlatformTest {

    private val platform = Platform()

    @Test
    actual fun testOperationSystemName() {
        assertEquals(
            expected = "Android",
            actual = platform.osName,
            message = "The OS name should be Android."
        )
    }
}