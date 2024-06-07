package com.teamsparta.todolist.security.jwt

import com.teamsparta.todolist.domain.user.model.UserRole
import com.teamsparta.todolist.security.jwt.Config.JwtPluginConfiguration
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.time.Duration
import java.time.Instant
import java.util.*

@Component
class JwtPlugin(
    private val jwtPluginConfiguration: JwtPluginConfiguration
) {

    fun validateToken(jwtToken : String) : Result<Jws<Claims>> {
        return kotlin.runCatching {
            val key = Keys.hmacShaKeyFor(jwtPluginConfiguration.secretKey
                .toByteArray(charset("UTF-8")))
            Jwts.parser()
                .verifyWith(key).build()
                .parseSignedClaims(jwtToken)
        }
    }

    fun generateAccessToken(subject: String, username: String, role : UserRole): String {
        return generateToken(subject, username, role, Duration.ofHours(jwtPluginConfiguration.tokenExpiration))
    }


    private fun generateToken(subject: String, username: String, role : UserRole, expiration : Duration): String {
        val claims = Jwts.claims()
            .add(mapOf("role" to role.name, "username" to username)).build()

        val now = Instant.now()
        val key = Keys.hmacShaKeyFor(jwtPluginConfiguration.secretKey
            .toByteArray(charset("UTF-8")))

        return Jwts.builder()
            .subject(subject)
            .issuer(jwtPluginConfiguration.issuer)
            .issuedAt(Date.from(now))
            .expiration(Date.from(now.plus(expiration)))
            .claims(claims)
            .signWith(key)
            .compact()
    }
}