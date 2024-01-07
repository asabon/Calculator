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

    @Test
    fun getHistoryDisplay_test() {
        val calculator = Calculator()
        val message = "111 +"
        calculator.setHistoryDisplay(message)
        assertEquals(message, calculator.getHistoryDisplay())
    }

    @Test
    fun operation_NumberInput() {
        val calculator = Calculator()
        calculator.operation(1)
        calculator.operation(2)
        calculator.operation(3)
        calculator.operation(4)
        calculator.operation(5)
        assertEquals("12345", calculator.getMainDisplay())
    }

    @Test
    fun operation_Clear() {
        val calculator = Calculator()
        calculator.operation(1)
        calculator.operation(2)
        calculator.operation(3)
        calculator.operation(4)
        calculator.operation(5)
        calculator.operation("C")
        assertEquals("", calculator.getMainDisplay())
    }

    @Test
    fun operation_SingleAdd() {
        val calculator = Calculator()
        /* === 起動直後 === */
        assertEquals("", calculator.getMainDisplay())
        assertEquals("", calculator.getHistoryDisplay())
        calculator.operation(1)
        /* === "1" を入力後 === */
        assertEquals("1", calculator.getMainDisplay())
        assertEquals("", calculator.getHistoryDisplay())
        calculator.operation("+")
        /* === "+" を入力後 === */
        assertEquals("", calculator.getMainDisplay())
        assertEquals("1 + ", calculator.getHistoryDisplay())
        calculator.operation(2)
        /* === "2" を入力後 === */
        assertEquals("2", calculator.getMainDisplay())
        assertEquals("1 + ", calculator.getHistoryDisplay())
        calculator.operation("=")
        /* === "2" を入力後 === */
        assertEquals("3", calculator.getMainDisplay())
        assertEquals("1 + 2 = ", calculator.getHistoryDisplay())
    }
}
