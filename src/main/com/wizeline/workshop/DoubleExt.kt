package com.wizeline.workshop

import java.text.DecimalFormat

fun Double.toDollar(): String {
    return DecimalFormat("$ ###,###,##0.00").format(this)
}

// TODO see the previous function, it is an extension to Double class named "toDollar()"
// TODO create the second extension to Double class named "toBitcoin" using the pattern "0.00000000 BTC"
