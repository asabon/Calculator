package net.asabon.calculator

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private lateinit var mainActivity : MainActivity

    @Before
    fun setUp() {
        mainActivity = MainActivity()
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("net.asabon.calculator", appContext.packageName)
    }

    @Test
    fun calculator_Test() {
        val calculator = Calculator()
        calculator.operation("1")
        assertEquals("1", calculator.getMainDisplay())
    }
    @Test
    fun mainActivity_Test() {
        //mainActivity = MainActivity()
        //mainActivity.operation("")
    }
}
