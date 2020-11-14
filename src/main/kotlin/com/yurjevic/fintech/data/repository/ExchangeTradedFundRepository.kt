package com.yurjevic.fintech.data.repository

import com.yurjevic.fintech.data.entity.ExchangeTradedFundEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExchangeTradedFundRepository : JpaRepository<ExchangeTradedFundEntity, Long> {

}