package com.yurjevic.fintech.app.gateway.controller

import com.yurjevic.fintech.data.entity.ExchangeTradedFundEntity
import com.yurjevic.fintech.usecase.ExchangeTradedFundServiceInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/etf")
class CompanyController @Autowired constructor(
		private val exchangeTradedFundService: ExchangeTradedFundServiceInterface) : CompanyInterface {

	@GetMapping("/all")
	override fun listAll(): List<ExchangeTradedFundEntity> {
		return exchangeTradedFundService.listAll()
	}
}