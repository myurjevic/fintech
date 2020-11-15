package com.yurjevic.fintech.data.entity

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "EXCHANGE_TRADED_FUND", schema = "public")
data class ExchangeTradedFundEntity(
		@Id
		@JsonIgnore
		@Column(name = "id", nullable = false)
		var uuid: UUID = UUID.randomUUID(),

		@Column(name = "company_id", nullable = false)
		var companyId: Long = 0,

		@Column(name = "company_symbol", nullable = false)
		var companySymbol: String = "",

		@Column(name = "company_name", nullable = false)
		var companyName: String = "",

		@Column(name = "trading_start_date", nullable = false, columnDefinition = "DATE")
		@JsonFormat(pattern = "yyyy-MM-dd")
		var tradingStartDate: LocalDate = LocalDate.now(),

		@Column(name = "trading_end_date", nullable = true, columnDefinition = "DATE")
		@JsonFormat(pattern = "yyyy-MM-dd")
		var tradingEndDate: LocalDate = LocalDate.now()
)