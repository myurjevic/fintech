package com.yurjevic.fintech.data.configuration

import org.hibernate.boot.model.naming.ImplicitNamingStrategy
import org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl
import org.hibernate.boot.model.naming.PhysicalNamingStrategy
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EntityScan(basePackages = ["com.yurjevic.fintech.data.entity"])
@EnableJpaRepositories(basePackages = ["com.yurjevic.fintech.data.repository"])
open class JpaConfiguration {
	@Bean
	open fun physical(): PhysicalNamingStrategy {
		return PhysicalNamingStrategyStandardImpl()
	}

	@Bean
	open fun implicit(): ImplicitNamingStrategy {
		return ImplicitNamingStrategyLegacyJpaImpl()
	}
}