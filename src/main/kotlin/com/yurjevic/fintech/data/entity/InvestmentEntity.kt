package com.yurjevic.fintech.data.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "INVESTMENT", schema = "public")
data class InvestmentEntity(
		@Id
		@JsonIgnore
		@Column(name = "id", nullable = false)
		var id: Long = 0,

		@Column(name = "etf_fk", nullable = false)
		var etf: String = "",

		@Column(name = "share_amount", nullable = false)
		var shareAmount: Long = 0,

		@ManyToOne
		@JsonIgnore
		@JoinColumn(name = "portfolio_fk", insertable = false, updatable = false)
		var portfolio: PortfolioEntity = PortfolioEntity(),

		@Transient
		var stockProfit: Long = 0
)