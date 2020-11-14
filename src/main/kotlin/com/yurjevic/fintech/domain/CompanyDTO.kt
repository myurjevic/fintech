package com.yurjevic.fintech.domain

import com.fasterxml.jackson.annotation.JsonIgnore

data class CompanyDTO(
		@JsonIgnore
		var id: String = "",
		var companyName: String = "",
		var companyId: String = ""
)