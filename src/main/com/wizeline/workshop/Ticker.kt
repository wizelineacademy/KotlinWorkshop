package com.wizeline.workshop

import com.google.gson.annotations.SerializedName

class Ticker {

    @SerializedName("id")
    var id: String? = null

    @SerializedName("price_usd")
    var price: String? = null

}
