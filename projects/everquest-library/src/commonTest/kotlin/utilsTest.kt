import xyz.sfx.xyz.sfx.utils.randomPassword
import kotlin.test.Test
import kotlin.test.assertEquals

@Test
fun testRandomPassword() {
    assertEquals("common2", randomPassword())
}