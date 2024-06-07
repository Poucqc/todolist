package com.teamsparta.todolist.security.jwt.Config

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(JwtPluginConfiguration::class)
class JwtConfig {
    @Bean
    fun jwtPluginConfiguration() : JwtPluginConfiguration {
        return JwtPluginConfiguration()
    }
}