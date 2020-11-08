package com.yurjevic.fintech.app.gateway.controller

import com.yurjevic.fintech.data.entity.PortfolioEntity
import com.yurjevic.fintech.data.repository.PortfolioRepository
import com.yurjevic.fintech.domain.PortfolioDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/fintech/portfolio")
class PortfolioController @Autowired constructor(
		private val portfolioRepository: PortfolioRepository): PortfolioInterface {
	@GetMapping("/search/{name}/")
	override fun portfolioHistory(@PathVariable name: String): String {
		val portfolios = portfolioRepository.findByName(name)
		return portfolios!!.first()!!.name
	}

	@PostMapping("/create/")
	override fun createPortfolio(@RequestBody portfolio: PortfolioDTO) : PortfolioEntity {
		val portfolioEntity = PortfolioEntity(name = portfolio.name, value = portfolio.value)
		return portfolioRepository.save(portfolioEntity)
	}

	@GetMapping("/analisis/{name}/")
	override fun porfolioAnalisis(@PathVariable name: String): String {
		val portfolios = portfolioRepository.findByName(name)
		return portfolios!!.first()!!.name
	}
}