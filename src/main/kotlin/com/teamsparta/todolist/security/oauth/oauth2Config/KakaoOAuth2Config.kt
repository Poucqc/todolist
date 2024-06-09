package com.teamsparta.todolist.security.oauth.oauth2Config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "oauth2.kakao")
data class KakaoOAuth2Config(
    val clientId: String = "",
    val redirectUrl: String = "",
    val authServerBaseUrl: String = "",
    val resourceServerBaseUrl: String = ""
)
