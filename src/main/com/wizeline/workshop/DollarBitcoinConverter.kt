package com.wizeline.workshop

class DollarBitcoinConverter(

        private val getBitcoinTicker: GetBitcoinTicker = GetBitcoinTicker()

) {

    fun execute(dollar: String?): DollarBitcoinModel {
        val amount = dollar?.toDoubleOrNull()
        return if (amount is Double) {
            getBitcoinTicker.execute()
                    .mapNotNull { it.price?.toDoubleOrNull() }
                    .filter { it > 0.0 }
                    .map { amount / it }
                    .map { DollarBitcoinModel(amount.toDollar(), it.toBitcoin()) }
                    .firstOrNull()
                    ?: throw NoSuchElementException("No available ticker")
        } else {
            throw IllegalArgumentException("Cannot convert $dollar")
        }
    }

}
