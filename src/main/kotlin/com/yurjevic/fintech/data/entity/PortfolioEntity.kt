package com.yurjevic.fintech.data.entity

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "PORTFOLIO", schema = "public")
data class PortfolioEntity(
		@Id
		@Column(name = "id", nullable = false)
		var id: Long = 0,

		@Column(name = "portfolio_name", nullable = false)
		var portfolioName: String = "",

		@Column(name = "start_date", nullable = false, columnDefinition = "DATE")
		@JsonFormat(pattern = "yyyy-MM-dd")
		var startDate: LocalDate = LocalDate.now(),

		@Column(name = "end_date", nullable = true, columnDefinition = "DATE")
		@JsonFormat(pattern = "yyyy-MM-dd")
		var endDate: LocalDate = LocalDate.now(),

		@OneToMany(mappedBy="portfolio")
		var investments : List<InvestmentEntity> = ArrayList()
)