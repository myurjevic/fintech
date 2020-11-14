package com.yurjevic.fintech.usecase

import com.yurjevic.fintech.data.entity.ExchangeTradedFundEntity
import com.yurjevic.fintech.data.repository.ExchangeTradedFundRepository
import com.yurjevic.fintech.domain.CompanyDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ExchangeTradedFundService @Autowired constructor(private val exchangeTradedFundRepository: ExchangeTradedFundRepository) : ExchangeTradedFundServiceInterface {
	override fun createCompany(companyDTO: CompanyDTO): CompanyDTO {
		val companyEntity = ExchangeTradedFundEntity(companyId = companyDTO.companyId, companyName = companyDTO.companyName)
		exchangeTradedFundRepository.save(companyEntity)
		return  companyDTO
	}
}