package com.yurjevic.fintech.usecase

import com.yurjevic.fintech.data.entity.ExchangeTradedFundEntity
import com.yurjevic.fintech.data.repository.ExchangeTradedFundRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ExchangeTradedFundService @Autowired constructor(private val exchangeTradedFundRepository: ExchangeTradedFundRepository) : ExchangeTradedFundServiceInterface {
	override fun listAll() : List<ExchangeTradedFundEntity>{
		return exchangeTradedFundRepository.findAll().toList()
	}
}