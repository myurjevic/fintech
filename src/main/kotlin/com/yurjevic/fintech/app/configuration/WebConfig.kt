package com.yurjevic.fintech.app.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
class WebConfig() {

	@Bean
	fun corsConfigurationSource(): CorsConfigurationSource? {
		val configuration = CorsConfiguration()
		configuration.allowedOrigins = mutableListOf("*")
		configuration.allowedMethods = mutableListOf("HEAD",
				"GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
		configuration.allowCredentials = true
		configuration.allowedHeaders = mutableListOf("*")
		configuration.exposedHeaders = mutableListOf("X-Auth-Token", "Authorization", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
		val source = UrlBasedCorsConfigurationSource()
		source.registerCorsConfiguration("/**", configuration)
		return source
	}
}