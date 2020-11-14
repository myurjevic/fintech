package com.yurjevic.fintech.app.gateway.controller

import com.yurjevic.fintech.domain.CompanyDTO
import com.yurjevic.fintech.usecase.ExchangeTradedFundServiceInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/company")
class CompanyController  @Autowired constructor(
		private val exchangeTradedFundServiceInterface: ExchangeTradedFundServiceInterface): CompanyInterface {

	@PostMapping("/create")
	override fun createNewCompany (@RequestBody companyDTO : CompanyDTO) : CompanyDTO {
		exchangeTradedFundServiceInterface.createCompany(companyDTO)
		return companyDTO
	}

	@PostMapping("/dailyprice")
	fun addDailySharePrice () : String{
		//exchangeTradedFundService.createCompany(entity)
		return "price"
	}
}