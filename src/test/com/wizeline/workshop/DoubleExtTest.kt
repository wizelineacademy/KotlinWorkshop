package com.wizeline.workshop

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DoubleExtTest {

    @Test
    fun testToDollarBasicValue() {
        val dollar = 1.00.toDollar()
        assertThat(dollar).isEqualTo("$ 1.00")
    }

    @Test
    fun testToDollarDecimalValue() {
        val dollar = 0.23456.toDollar()
        assertThat(dollar).isEqualTo("$ 0.23")
    }

    @Test
    fun testToDollarThousandValue() {
        val dollar = 1234.56.toDollar()
        assertThat(dollar).isEqualTo("$ 1,234.56")
    }

    @Test
    fun testToDollarBasicNegativeValue() {
        val dollar = (-1.00).toDollar()
        assertThat(dollar).isEqualTo("-$ 1.00")
    }

    @Test
    fun testToDollarDecimalNegativeValue() {
        val dollar = (-0.23456).toDollar()
        assertThat(dollar).isEqualTo("-$ 0.23")
    }

    @Test
    fun testToDollarThousandNegativeValue() {
        val dollar = (-1234.56).toDollar()
        assertThat(dollar).isEqualTo("-$ 1,234.56")
    }

    @Test
    fun testToBitcoinBasicValue() {
        val bitcoin = 1.00.toBitcoin()
        assertThat(bitcoin).isEqualTo("1.00000000 BTC")
    }

    @Test
    fun testToBitcoinDecimalValue() {
        val bitcoin = 0.1234567890.toBitcoin()
        assertThat(bitcoin).isEqualTo("0.12345679 BTC")
    }

    @Test
    fun testToBitcoinThousandValue() {
        val bitcoin = 1234.56.toBitcoin()
        assertThat(bitcoin).isEqualTo("1234.56000000 BTC")
    }

    @Test
    fun testToBitcoinBasicNegativeValue() {
        val bitcoin = (-1.00).toBitcoin()
        assertThat(bitcoin).isEqualTo("-1.00000000 BTC")
    }

    @Test
    fun testToBitcoinDecimalNegativeValue() {
        val bitcoin = (-0.1234567890).toBitcoin()
        assertThat(bitcoin).isEqualTo("-0.12345679 BTC")
    }

    @Test
    fun testToBitcoinThousandNegativeValue() {
        val bitcoin = (-1234.56).toBitcoin()
        assertThat(bitcoin).isEqualTo("-1234.56000000 BTC")
    }

}
