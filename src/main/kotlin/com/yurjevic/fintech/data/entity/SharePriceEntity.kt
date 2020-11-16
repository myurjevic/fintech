package com.yurjevic.fintech.data.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigInteger
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "SHARE_PRICE", schema = "public")
class SharePriceEntity (
	@Id
	@JsonIgnore
	@Column(name = "id", nullable = false)
	var id: Long = 0,

	@Column(name = "etf_fk", nullable = false)
	var etf: String = "",

	@Column(name = "share_date", nullable = false)
	var shareDate : LocalDate = LocalDate.now(),

	@Column(name = "price_open", columnDefinition = "NUMERIC(19,4)", nullable = false)
	var priceOpen : Double = 0.0000,

	@Column(name = "price_high", columnDefinition = "NUMERIC(19,4)",  nullable = false)
	var priceHigh : Double = 0.0000,

	@Column(name = "price_low", columnDefinition = "NUMERIC(19,4)", nullable = false)
	var priceLow : Double = 0.0000,

	@Column(name = "price_close", columnDefinition = "NUMERIC(19,4)",  nullable = false)
	var priceClose : Double = 0.0000
)
