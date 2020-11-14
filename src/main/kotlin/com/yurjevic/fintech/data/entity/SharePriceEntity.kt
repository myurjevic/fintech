package com.yurjevic.fintech.data.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "SHARE_PRICE", schema = "public")
data class SharePriceEntity (
		@Id
		@JsonIgnore
		@GeneratedValue(strategy = GenerationType.AUTO)
		var id: Long? = 0,

		@Column(name = "company_id", nullable = false)
		var companyId: String,

		@Column(name = "date", nullable = false)
		@DateTimeFormat(style = "dd-mm-yyyy")
		var date: LocalDateTime,

		@Column(name = "share_price", nullable = false)
		var sharePrice: Int
)