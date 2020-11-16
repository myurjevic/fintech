package com.yurjevic.fintech.usecase

import com.yurjevic.fintech.data.entity.ExchangeTradedFundEntity
import com.yurjevic.fintech.data.entity.PortfolioEntity

interface FintechServiceInterface  {
	fun listAllExchangeTradedFunds() : List<ExchangeTradedFundEntity>
	fun listAllPortfolios() : List<PortfolioEntity>
}