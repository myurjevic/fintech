package com.yurjevic.fintech.data.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "EXCHANGE_TRADED_FUND", schema = "public")
data class ExchangeTradedFundEntity (
		@Id
		@JsonIgnore
		@GeneratedValue(strategy = GenerationType.AUTO)
		var id: Long? = 0,

		@Column(name = "company_id", nullable = false)
		var companyId: String = "",

		@Column(name = "company_name", nullable = false)
		var companyName: String = ""
)