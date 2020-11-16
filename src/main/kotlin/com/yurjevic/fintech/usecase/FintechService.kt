package com.yurjevic.fintech.usecase

import com.yurjevic.fintech.data.entity.ExchangeTradedFundEntity
import com.yurjevic.fintech.data.entity.PortfolioEntity
import com.yurjevic.fintech.data.repository.ExchangeTradedFundRepository
import com.yurjevic.fintech.data.repository.PortfolioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FintechService @Autowired constructor(
		private val exchangeTradedFundRepository: ExchangeTradedFundRepository,
		private val portfolioRepository: PortfolioRepository) : FintechServiceInterface {
	override fun listAllExchangeTradedFunds() : List<ExchangeTradedFundEntity>{
		val etfs = exchangeTradedFundRepository.findAll().toList()
		return etfs
	}

	override fun listAllPortfolios(): List<PortfolioEntity> {
		val portfolios = portfolioRepository.findAll().toList()
		return portfolios
	}
}