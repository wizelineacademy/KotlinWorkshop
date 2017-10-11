package com.wizeline.workshop

import com.google.gson.stream.MalformedJsonException
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GetBitcoinTickerTest {

    private val price = "4241.53"

    @Test
    fun testExecute200() {
        val response = MockResponse().setResponseCode(200).setBody("""
            |[{
            |   "id": "bitcoin",
            |   "name": "Bitcoin",
            |   "symbol": "BTC",
            |   "rank": "1",
            |   "price_usd": $price,
            |   "price_btc": "1.0",
            |   "24h_volume_usd": "2485710000.0",
            |   "market_cap_usd": "70044308305.0",
            |   "available_supply": "16513925.0",
            |   "total_supply": "16513925.0",
            |   "percent_change_1h": "-0.53",
            |   "percent_change_24h": "-1.79",
            |   "percent_change_7d": "19.97",
            |   "last_updated": "1503076460"
            |}]
            """.trimMargin())

        val server = MockWebServer()
        server.enqueue(response)
        server.start()

        val getBitcoinTicker = GetBitcoinTicker("http://${server.hostName}:${server.port}/")
        val tickers = getBitcoinTicker.execute()
        assertThat(tickers.size).isEqualTo(1)
        assertThat(tickers[0].price).isEqualTo(price)
    }

    @Test
    fun testExecute200MultipleItems() {
        val response = MockResponse().setResponseCode(200).setBody("""
            |[{
            |   "id": "bitcoin",
            |   "name": "Bitcoin",
            |   "symbol": "BTC",
            |   "rank": "1",
            |   "price_usd": $price,
            |   "price_btc": "1.0",
            |   "24h_volume_usd": "2485710000.0",
            |   "market_cap_usd": "70044308305.0",
            |   "available_supply": "16513925.0",
            |   "total_supply": "16513925.0",
            |   "percent_change_1h": "-0.53",
            |   "percent_change_24h": "-1.79",
            |   "percent_change_7d": "19.97",
            |   "last_updated": "1503076460"
            |},{
            |   "id": "bitcoin",
            |   "name": "Bitcoin",
            |   "symbol": "BTC",
            |   "rank": "1",
            |   "price_usd": "1234.55",
            |   "price_btc": "1.0",
            |   "24h_volume_usd": "2485710000.0",
            |   "market_cap_usd": "70044308305.0",
            |   "available_supply": "16513925.0",
            |   "total_supply": "16513925.0",
            |   "percent_change_1h": "-0.53",
            |   "percent_change_24h": "-1.79",
            |   "percent_change_7d": "19.97",
            |   "last_updated": "1503076460"
            |}]
            """.trimMargin())

        val server = MockWebServer()
        server.enqueue(response)
        server.start()

        val getBitcoinTicker = GetBitcoinTicker("http://${server.hostName}:${server.port}/")
        val tickers = getBitcoinTicker.execute()
        assertThat(tickers.size).isEqualTo(2)
        assertThat(tickers[0].price).isEqualTo(price)
    }

    @Test
    fun testExecute200FilterItems() {
        val response = MockResponse().setResponseCode(200).setBody("""
            |[{
            |   "id": "dash",
            |   "name": "Dash",
            |   "symbol": "DASH",
            |   "rank": "8",
            |   "price_usd": "223.236",
            |   "price_btc": "0.0552203",
            |   "24h_volume_usd": "50150000.0",
            |   "market_cap_usd": "1674234322.0",
            |   "available_supply": "7499840.0",
            |   "total_supply": "7499840.0",
            |   "percent_change_1h": "-0.14",
            |   "percent_change_24h": "-8.72",
            |   "percent_change_7d": "9.83",
            |   "last_updated": "1503088751"
            |},{
            |   "id": "bitcoin",
            |   "name": "Bitcoin",
            |   "symbol": "BTC",
            |   "rank": "1",
            |   "price_usd": $price,
            |   "price_btc": "1.0",
            |   "24h_volume_usd": "2485710000.0",
            |   "market_cap_usd": "70044308305.0",
            |   "available_supply": "16513925.0",
            |   "total_supply": "16513925.0",
            |   "percent_change_1h": "-0.53",
            |   "percent_change_24h": "-1.79",
            |   "percent_change_7d": "19.97",
            |   "last_updated": "1503076460"
            |}]
            """.trimMargin())

        val server = MockWebServer()
        server.enqueue(response)
        server.start()

        val getBitcoinTicker = GetBitcoinTicker("http://${server.hostName}:${server.port}/")
        val tickers = getBitcoinTicker.execute()
        assertThat(tickers.size).isEqualTo(1)
        assertThat(tickers[0].price).isEqualTo(price)
    }

    @Test
    fun testExecute200Empty() {
        val response = MockResponse().setResponseCode(200).setBody("[]")

        val server = MockWebServer()
        server.enqueue(response)
        server.start()

        val getBitcoinTicker = GetBitcoinTicker("http://${server.hostName}:${server.port}/")
        val tickers = getBitcoinTicker.execute()
        assertThat(tickers).isEmpty()
    }

    @Test(expected = MalformedJsonException::class)
    fun testExecute200InvalidJson() {
        val response = MockResponse().setResponseCode(200).setBody("An invalid json")

        val server = MockWebServer()
        server.enqueue(response)
        server.start()

        val getBitcoinTicker = GetBitcoinTicker("http://${server.hostName}:${server.port}/")
        getBitcoinTicker.execute()
    }

    @Test
    fun testExecuteErrorCode() {
        val response = MockResponse().setResponseCode(400)

        val server = MockWebServer()
        server.enqueue(response)
        server.start()

        val getBitcoinTicker = GetBitcoinTicker("http://${server.hostName}:${server.port}/")
        val tickers = getBitcoinTicker.execute()
        assertThat(tickers).isEmpty()
    }

}
