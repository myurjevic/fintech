package com.yurjevic.fintech.usecase

import com.yurjevic.fintech.data.entity.ExchangeTradedFundEntity

interface ExchangeTradedFundServiceInterface  {
	fun listAll() : List<ExchangeTradedFundEntity>
}