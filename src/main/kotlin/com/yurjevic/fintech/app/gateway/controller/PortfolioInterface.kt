package com.yurjevic.fintech.app.gateway.controller

import com.yurjevic.fintech.data.entity.PortfolioEntity
import com.yurjevic.fintech.domain.PortfolioDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

interface PortfolioInterface {
	fun portfolioHistory(name: String): String
	fun createPortfolio(portfolio: PortfolioDTO) : PortfolioEntity
	fun porfolioAnalisis(@PathVariable name: String): String
}