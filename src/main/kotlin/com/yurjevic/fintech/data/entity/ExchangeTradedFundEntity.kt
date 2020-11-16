package com.yurjevic.fintech.data.entity

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "EXCHANGE_TRADED_FUND", schema = "public")
data class ExchangeTradedFundEntity(
		@Id
		@JsonIgnore
		@Column(name = "id", nullable = false)
		var id: Long = 0,

		@Column(name = "short_name", nullable = false)
		var shortName: String = "",

		@Column(name = "long_name", nullable = false)
		var longName: String = "",

		@Column(name = "fund_open_date", nullable = false, columnDefinition = "DATE")
		@JsonFormat(pattern = "yyyy-MM-dd")
		var fundOpenDate: LocalDate = LocalDate.now(),

		@Column(name = "fund_close_date", nullable = true, columnDefinition = "DATE")
		@JsonFormat(pattern = "yyyy-MM-dd")
		var fundCloseDate: LocalDate = LocalDate.now()
)