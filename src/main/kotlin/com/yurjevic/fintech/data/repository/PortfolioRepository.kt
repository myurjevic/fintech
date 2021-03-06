package com.yurjevic.fintech.data.repository

import com.yurjevic.fintech.data.entity.PortfolioEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PortfolioRepository : JpaRepository<PortfolioEntity, Long> {
}