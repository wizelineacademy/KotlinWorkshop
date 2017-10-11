package com.wizeline.workshop

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DataSource {

    @GET("v1/ticker/{coin}/")
    fun getTickets(
            @Path("coin") coin: String
    ): Call<Array<Ticker>>

}
