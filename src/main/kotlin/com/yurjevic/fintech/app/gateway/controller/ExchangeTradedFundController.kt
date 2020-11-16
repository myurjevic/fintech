package com.yurjevic.fintech.app.gateway.controller

import com.yurjevic.fintech.data.entity.ExchangeTradedFundEntity
import com.yurjevic.fintech.usecase.FintechServiceInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/fintech/etf")
class ExchangeTradedFundController @Autowired constructor(
		private val fintechService: FintechServiceInterface) : ExchangeTradedFundInterface {

	@GetMapping("/all")
	override fun listAllExchangeTradedFunds(): List<ExchangeTradedFundEntity> {
		return fintechService.listAllExchangeTradedFunds()
	}
}