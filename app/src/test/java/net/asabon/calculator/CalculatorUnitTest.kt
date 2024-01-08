package net.asabon.calculator

import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatorUnitTest {
    @Test
    fun getMainDisplay_test() {
        val calculator = Calculator()
        calculator.setMainDisplay("000")
        assertEquals("000", calculator.getMainDisplay())
    }

    /*
    @Test
    fun getHistoryDisplay_test() {
        val calculator = Calculator()
        val message = "111 +"
        calculator.setSubDisplay(message)
        assertEquals(message, calculator.getSubDisplay())
    }
     */

    @Test
    fun operation_NumberInput() {
        val calculator = Calculator()
        calculator.pushKey("1")
        calculator.pushKey("2")
        calculator.pushKey("3")
        calculator.pushKey("4")
        calculator.pushKey("5")
        assertEquals("12345", calculator.getMainDisplay())
        //assertEquals("", calculator.getSubDisplay())
    }

    @Test
    fun operation_Clear() {
        val calculator = Calculator()
        calculator.pushKey("1")
        calculator.pushKey("2")
        calculator.pushKey("C")
        assertEquals("", calculator.getMainDisplay())
        //assertEquals("", calculator.getSubDisplay())
    }

    @Test
    fun operation_SingleAdd() {
        val calculator = Calculator()
        /* === 起動直後 === */
        assertEquals("", calculator.getMainDisplay())
        //assertEquals("", calculator.getSubDisplay())

        /* === "1" を入力 === */
        calculator.pushKey("1")
        assertEquals("1", calculator.getMainDisplay())
        //assertEquals("", calculator.getSubDisplay())

        /* === "+" を入力 === */
        calculator.pushKey("+")
        assertEquals("", calculator.getMainDisplay())
        //assertEquals("1.0 + ", calculator.getSubDisplay())

        /* === "2" を入力 === */
        calculator.pushKey("2")
        assertEquals("2", calculator.getMainDisplay())
        //assertEquals("1.0 + ", calculator.getSubDisplay())

        /* === "=" を入力 === */
        calculator.pushKey("=")
        assertEquals("3.0", calculator.getMainDisplay())
        //assertEquals("1.0 + 2.0 = ", calculator.getSubDisplay())
    }

    @Test
    fun operation_NumberAfterEqual() {
        val calculator = Calculator()
        calculator.pushKey("1")
        calculator.pushKey("+")
        calculator.pushKey("2")
        calculator.pushKey("=")
        /* === "=" の後に数値キーを入力 === */
        calculator.pushKey("4")
        assertEquals("4", calculator.getMainDisplay())
        //assertEquals("", calculator.getSubDisplay())
        calculator.pushKey("5")
        assertEquals("45", calculator.getMainDisplay())
        //assertEquals("", calculator.getSubDisplay())
    }

    @Test
    fun operation_PlusAfterEqual() {
        val calculator = Calculator()
        calculator.pushKey("1")
        calculator.pushKey("+")
        calculator.pushKey("2")
        calculator.pushKey("=")
        /* === "=" の後に演算キーを入力 === */
        calculator.pushKey("+")
        assertEquals("", calculator.getMainDisplay())
        //assertEquals("3.0 + ", calculator.getSubDisplay())
    }
}
