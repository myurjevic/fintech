package com.yurjevic.fintech.usecase

import com.yurjevic.fintech.data.entity.ExchangeTradedFundEntity
import com.yurjevic.fintech.domain.CompanyDTO

interface ExchangeTradedFundServiceInterface  {
	fun createCompany(companyDTO : CompanyDTO) : CompanyDTO
}