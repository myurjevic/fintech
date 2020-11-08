package com.yurjevic.fintech.data.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import java.util.stream.Collectors
import javax.persistence.EntityManager
import javax.persistence.metamodel.EntityType


@Configuration
open class RepositoryRestConfig : RepositoryRestConfigurer {
	@Autowired
	private val entityManager: EntityManager? = null

	override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration) {
		config.exposeIdsFor(*entityManager!!.metamodel.entities.stream().map { e: EntityType<*> -> e.javaType }.collect(Collectors.toList()).toTypedArray())
	}
}
