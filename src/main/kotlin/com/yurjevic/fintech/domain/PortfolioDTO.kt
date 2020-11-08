package com.yurjevic.fintech.domain

import java.time.LocalDate

data class PortfolioDTO(
		val name : String = "Unnamed",
		val startDate : LocalDate = LocalDate.now(),
		val endDate : LocalDate = LocalDate.now(),
		val value : String = "0",
		val annualizedReturn : String = "0"
		//val stocks  : ArrayList<StockDetailDTO>
) {

	val stocksProfit: String =  periodProfit()

	fun periodProfit() : String{
		return "3000"
	}
}