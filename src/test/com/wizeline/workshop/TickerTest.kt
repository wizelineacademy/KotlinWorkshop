package com.wizeline.workshop

import com.google.gson.Gson
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class TickerTest {

    private val id = "bitcoin"
    private val price = "4241.53"
    private val json = """
            |{
            |   "id": "$id",
            |   "name": "Bitcoin",
            |   "symbol": "BTC",
            |   "rank": "1",
            |   "price_usd": "$price",
            |   "price_btc": "1.0",
            |   "24h_volume_usd": "2485710000.0",
            |   "market_cap_usd": "70044308305.0",
            |   "available_supply": "16513925.0",
            |   "total_supply": "16513925.0",
            |   "percent_change_1h": "-0.53",
            |   "percent_change_24h": "-1.79",
            |   "percent_change_7d": "19.97",
            |   "last_updated": "1503076460"
            |}
            """.trimMargin()

    @Test
    fun testParser() {
        val ticker = Gson().fromJson(json, Ticker::class.java)
        assertThat(ticker.id).isEqualTo(id)
        assertThat(ticker.price).isEqualTo(price)
    }

}
