package com.yurjevic.fintech.app.gateway.controller

import com.yurjevic.fintech.domain.CompanyDTO

interface CompanyInterface {
	fun createNewCompany (companyDTO : CompanyDTO) : CompanyDTO
}