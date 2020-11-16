package com.yurjevic.fintech.usecase

import com.yurjevic.fintech.data.entity.ExchangeTradedFundEntity
import com.yurjevic.fintech.data.entity.InvestmentEntity
import com.yurjevic.fintech.data.entity.PortfolioEntity
import com.yurjevic.fintech.data.entity.SharePriceEntity
import com.yurjevic.fintech.data.repository.ExchangeTradedFundRepository
import com.yurjevic.fintech.data.repository.PortfolioRepository
import com.yurjevic.fintech.data.repository.SharePriceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.Period
import kotlin.math.pow

@Service
class FintechService @Autowired constructor(
		private val exchangeTradedFundRepository: ExchangeTradedFundRepository,
		private val portfolioRepository: PortfolioRepository,
		private val sharePriceRepository: SharePriceRepository
) : FintechServiceInterface {

	override fun listAllExchangeTradedFunds(): List<ExchangeTradedFundEntity> {
		val etfs = exchangeTradedFundRepository.findAll().toList()
		return etfs
	}

	override fun listAllPortfolios(): List<PortfolioEntity> {
		val portfolios = portfolioRepository.findAll().toList()

		portfolios.forEach { portfolio ->
			run {
				if (portfolio.investments.count() != 0) {
					processInvestments(portfolio.startDate, portfolio.endDate, portfolio.investments)
				}
			}
		}
		return portfolios
	}

	private fun processInvestments(startDate: LocalDate, endDate: LocalDate, investments: List<InvestmentEntity>) {
		investments.forEach { investment ->
			if(sharePriceRepository.existsByShareDateAndEtf(startDate,investment.etf) and sharePriceRepository.existsByShareDateAndEtf(endDate,investment.etf)){
				val startSharePriceData = sharePriceRepository.findAllByShareDateAndEtf(startDate, investment.etf).get(0)
				val endSharePriceData = sharePriceRepository.findAllByShareDateAndEtf(endDate, investment.etf).get(0)
				val period = Period.between(startDate, endDate)
				calculateProfitAndAnnualizedReturn(period.years, investment.shareAmount, startSharePriceData, endSharePriceData)
			} else {
				println("No share value data found for ${investment.etf} investment for dates $startDate or $endDate")
			}
		}
	}

	private fun calculateProfitAndAnnualizedReturn(years : Int, shareAmount : Long, startSharePriceData: SharePriceEntity, endSharePriceData: SharePriceEntity) {
		val startAmount = startSharePriceData.priceClose * shareAmount
		val endAmount = endSharePriceData.priceClose * shareAmount
		val profit = endAmount - startAmount

		val totalInvestmentReturn = profit /startAmount

		val yearly = totalInvestmentReturn.pow(0.1) -1

		println("Years: $years, " +
				"Start Amount: $startAmount, " +
				"End Amount: $endAmount, " +
				"Total Investment Return: $profit, " +
				"TotalInvestmentReturn: $totalInvestmentReturn, " +
				"Annualized Return: $yearly")
	}

}