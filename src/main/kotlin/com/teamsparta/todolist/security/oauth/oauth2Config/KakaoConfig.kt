package com.teamsparta.todolist.security.oauth.oauth2Config

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(KakaoOAuth2Config::class)
class KakaoConfig {
    @Bean
    fun KakaoOAuth2Config(): KakaoOAuth2Config {
        return KakaoOAuth2Config()
    }
}