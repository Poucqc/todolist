package com.teamsparta.todolist.security.jwt.Config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "auth.jwt")
data class JwtPluginConfiguration (
    var issuer: String = "",
    var secretKey: String = "",
    var tokenExpiration: Long = 0
)