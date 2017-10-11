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

    // TODO create a function named "execute" that returns a List<Ticker>
    // TODO inside the execute function uses the dataSource.getTickets using "bitcoin" as coin
    // TODO the previous method returns a retrofit object, you need to call their execute() method an then call the body() method
    // TODO at this point you have a nullable list, uses the safe call "?." to filter the list to have only bitcoin tickers: .filter { it.id == "bitcoin" }
    // TODO uses the elvis operator to send an emptyList if you receive a null: ?: emptyList()

}
