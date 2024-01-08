package net.asabon.calculator

import org.junit.Assert.assertEquals
import org.junit.Test

class NumberUnitTest {
    @Test
    fun number_123() {
        val number = Number()
        assertEquals("1",     number.putKey("1"))
        assertEquals("12",    number.putKey("2"))
        assertEquals("123",   number.putKey("3"))
        assertEquals("123",   number.getNumber())
    }

    @Test
    fun number_Double() {
        val number = Number()
        assertEquals("1",    number.putKey("1"))
        assertEquals("12",   number.putKey("2"))
        assertEquals("12.",  number.putKey("."))
        assertEquals("12.3", number.putKey("3"))
    }

    @Test
    fun number_Double2() {
        val number = Number()
        assertEquals("1",    number.putKey("1"))
        assertEquals("12",   number.putKey("2"))
        assertEquals("12.",  number.putKey("."))
        assertEquals("12.",  number.putKey(".")) /* 無視される */
    }

    @Test
    fun number_Double3() {
        val number = Number()
        assertEquals("1",     number.putKey("1"))
        assertEquals("12",    number.putKey("2"))
        assertEquals("12.",   number.putKey("."))
        assertEquals("12.",   number.putKey(".")) /* 無視される */
        assertEquals("12.3",  number.putKey("3"))
    }
}
