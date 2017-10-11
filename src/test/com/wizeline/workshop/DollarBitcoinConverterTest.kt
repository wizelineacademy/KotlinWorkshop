package com.wizeline.workshop

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as whenever

class DollarBitcoinConverterTest {

    @Mock private lateinit var mockGetBitcoinTicker: GetBitcoinTicker

    private lateinit var mockTicker: Ticker

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mockTicker = Ticker().apply {
            price = "4075.22"
        }
    }

    @Test
    fun testExecuteSuccessCase() {
        whenever(mockGetBitcoinTicker.execute()).thenReturn(listOf(mockTicker))
        val model = DollarBitcoinConverter(mockGetBitcoinTicker).execute("1")
        assertThat(model).isEqualTo(DollarBitcoinModel("$ 1.00", "0.00024539 BTC"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun testExecuteNullAmount() {
        whenever(mockGetBitcoinTicker.execute()).thenReturn(listOf(mockTicker))
        DollarBitcoinConverter(mockGetBitcoinTicker).execute(null)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testExecuteInvalidAmount() {
        whenever(mockGetBitcoinTicker.execute()).thenReturn(listOf(mockTicker))
        DollarBitcoinConverter(mockGetBitcoinTicker).execute("An invalid string")
    }

    @Test
    fun testExecuteZeroAmount() {
        whenever(mockGetBitcoinTicker.execute()).thenReturn(listOf(mockTicker))
        val model = DollarBitcoinConverter(mockGetBitcoinTicker).execute("0")
        assertThat(model).isEqualTo(DollarBitcoinModel("$ 0.00", "0.00000000 BTC"))
    }

    @Test
    fun testExecuteNegativeAmount() {
        whenever(mockGetBitcoinTicker.execute()).thenReturn(listOf(mockTicker))
        val model = DollarBitcoinConverter(mockGetBitcoinTicker).execute("-1")
        assertThat(model).isEqualTo(DollarBitcoinModel("-$ 1.00", "-0.00024539 BTC"))
    }

    @Test(expected = NoSuchElementException::class)
    fun testExecuteNullPrice() {
        mockTicker.price = null
        whenever(mockGetBitcoinTicker.execute()).thenReturn(listOf(mockTicker))
        DollarBitcoinConverter(mockGetBitcoinTicker).execute("1")
    }

    @Test(expected = NoSuchElementException::class)
    fun testExecuteInvalidPrice() {
        mockTicker.price = "An invalid price"
        whenever(mockGetBitcoinTicker.execute()).thenReturn(listOf(mockTicker))
        DollarBitcoinConverter(mockGetBitcoinTicker).execute("1")
    }

    @Test(expected = NoSuchElementException::class)
    fun testExecuteZeroPrice() {
        mockTicker.price = "0"
        whenever(mockGetBitcoinTicker.execute()).thenReturn(listOf(mockTicker))
        DollarBitcoinConverter(mockGetBitcoinTicker).execute("1")
    }

    @Test(expected = NoSuchElementException::class)
    fun testExecuteNegativePrice() {
        mockTicker.price = "-1"
        whenever(mockGetBitcoinTicker.execute()).thenReturn(listOf(mockTicker))
        DollarBitcoinConverter(mockGetBitcoinTicker).execute("1")
    }

}
