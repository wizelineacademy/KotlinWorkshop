package com.wizeline.workshop

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetBitcoinTicker(

        private val baseUrl: String = "https://api.coinmarketcap.com/"

) {

    private val dataSource by lazy {
        Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().build())
                .build()
                .create(DataSource::class.java)
    }

    fun execute(): List<Ticker> {
        return dataSource.getTickets("bitcoin")
                .execute()
                .body()
                ?.filter { it.id == "bitcoin" }
                ?: emptyList()
    }

}
