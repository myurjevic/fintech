package com.yurjevic.fintech.app.gateway.controller

import com.yurjevic.fintech.data.entity.ExchangeTradedFundEntity
import com.yurjevic.fintech.data.entity.PortfolioEntity

interface ExchangeTradedFundInterface {
	fun listAllExchangeTradedFunds () : List<ExchangeTradedFundEntity>
}

interface PortfolioInterface {
	fun getPortfolios() : List<PortfolioEntity>
}