package com.yurjevic.fintech.data.repository

import com.yurjevic.fintech.data.entity.SharePriceEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface SharePriceRepository : JpaRepository<SharePriceEntity, Long> {
	fun findAllByShareDateAndEtf(@Param("shareDate")shareDate: LocalDate, @Param("etf")etf: String): List<SharePriceEntity>
	fun existsByShareDateAndEtf(@Param("shareDate")shareDate: LocalDate, @Param("etf")etf: String): Boolean
}
