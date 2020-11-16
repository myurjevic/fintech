package com.yurjevic.fintech.app.gateway.controller

import com.yurjevic.fintech.data.entity.PortfolioEntity
import com.yurjevic.fintech.usecase.FintechServiceInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/fintech/portfolio")
class PortfolioController  @Autowired constructor(
		private val fintechService: FintechServiceInterface) : PortfolioInterface {

	@GetMapping("/all")
	override fun getPortfolios(): List<PortfolioEntity> {
		return fintechService.listAllPortfolios()
	}

}