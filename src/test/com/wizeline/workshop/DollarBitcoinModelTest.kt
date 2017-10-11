package com.wizeline.workshop

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DollarBitcoinModelTest {

    private val dollar = "dollar"
    private val bitcoin = "bitcoin"

    @Test
    fun testInstantiate() {
        val dollarBitcoinModel = DollarBitcoinModel(dollar, bitcoin)
        assertThat(dollarBitcoinModel.dollar).isEqualTo(dollar)
        assertThat(dollarBitcoinModel.bitcoin).isEqualTo(bitcoin)
    }

    @Test
    fun testEquals() {
        assertThat(DollarBitcoinModel(dollar, bitcoin)).isEqualTo(DollarBitcoinModel(dollar, bitcoin))
        assertThat(DollarBitcoinModel(dollar, bitcoin)).isNotEqualTo(DollarBitcoinModel("Any", "Thing"))
    }

    @Test
    fun testToString() {
        assertThat(DollarBitcoinModel(dollar, bitcoin).toString()).isEqualTo("DollarBitcoinModel(dollar=$dollar, bitcoin=$bitcoin)")
    }

    @Test
    fun testComponentN() {
        val (dollar, bitcoin) = DollarBitcoinModel(dollar, bitcoin)
        assertThat(dollar).isEqualTo(this.dollar)
        assertThat(bitcoin).isEqualTo(this.bitcoin)
    }

    @Test
    fun testCopy() {
        val original = DollarBitcoinModel(dollar, bitcoin)
        val copy = original.copy()
        val different = DollarBitcoinModel("Any", "Thing")
        assertThat(original).isEqualTo(copy)
        assertThat(different).isNotEqualTo(copy)
    }

}
