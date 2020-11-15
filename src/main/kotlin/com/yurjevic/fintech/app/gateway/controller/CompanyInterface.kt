package com.yurjevic.fintech.app.gateway.controller

import com.yurjevic.fintech.data.entity.ExchangeTradedFundEntity

interface CompanyInterface {
	fun listAll () : List<ExchangeTradedFundEntity>
}