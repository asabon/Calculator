package net.asabon.calculator

import androidx.compose.ui.platform.LocalContext
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun calculate_test() {
        assertEquals(0, calculate(null, "+", 0))
        assertEquals(0, calculate(null, "-", 0))
        assertEquals(0, calculate(null, "*", 0))
        //assertEquals(0, calculate(null, "/", 0))

        assertEquals(0, calculate(0, "+", 0))
        assertEquals(0, calculate(0, "-", 0))
        assertEquals(0, calculate(0, "*", 0))
        //assertEquals(0, calculate(0, "/", 0))
    }
}