package com.wizeline.workshop

class DollarBitcoinConverter(

        private val getBitcoinTicker: GetBitcoinTicker = GetBitcoinTicker()

) {

    fun execute(dollar: String?): DollarBitcoinModel {
        // TODO using the safe operator "?." call to toDoubleOrNull to get the double value from the dollar argument and save on a value named amount
        // TODO using the smart cast check if the amount is a non null double: "if (amount is Double)"
        // TODO if the amount is null throw an IllegalArgumentException with the message "Cannot convert $dollar"
        // TODO if the amount is a valid non null double, call "getBitcoinTicker.execute()" to get a list of tickers to make the conversion
        // TODO filter the ticker list to remove all null tickers and all tickers with null price: ".mapNotNull { it.price?.toDoubleOrNull() }"
        // TODO filter again to remove values less than zero: .filter { it > 0.0 }
        // TODO map the list to have the converted value: .map { amount / it }
        // TODO map the list with converted values to our data class model: .map { DollarBitcoinModel(amount.toDollar(), it.toBitcoin()) }
        // TODO get the first element of the list or null if after the filters we have no more elements: .firstOrNull()
        // TODO uses the elvis operator "?:" to throw an NoSuchElementException with the message "No available ticker" if the pipe result is null
    }

}
