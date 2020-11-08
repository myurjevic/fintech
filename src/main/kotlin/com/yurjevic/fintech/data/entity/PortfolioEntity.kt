package com.yurjevic.fintech.data.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "PORTFOLIO", schema = "public")
data class PortfolioEntity(
		@Id
		@JsonIgnore
		@GeneratedValue(strategy = GenerationType.AUTO)
		var id: Long? = 0,

		@Column(name = "name", nullable = false)
		var name: String = "Generic Portafolio",

		@Column(name = "value", nullable = false)
		var value: String = "$100.000"


)