package com.wizeline.workshop

import java.text.DecimalFormat

fun Double.toDollar(): String {
    return DecimalFormat("$ ###,###,##0.00").format(this)
}

fun Double.toBitcoin(): String {
    return DecimalFormat("0.00000000 BTC").format(this)
}
