package com.teamsparta.todolist.security

import com.teamsparta.todolist.domain.user.dto.UserResponse
import com.teamsparta.todolist.domain.user.dto.TokenResponse
import com.teamsparta.todolist.domain.user.model.User
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.Date


@Component
class JwtTokenUtil {

    private val SECRET_KEY = "your-secret-key"
    private val EXPIRATION_TIME = 864_000_000 // 10 days

    // 사용자 정보를 토큰에 추가하여 토큰 생성
    fun generateToken(user: UserResponse): TokenResponse {
        val now = Date()
        val expiryDate = Date(now.time + EXPIRATION_TIME)

        val token = Jwts.builder()
            .setSubject(user.name)
            .claim("id", user.id)
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
            .compact()

        return TokenResponse(token)
    }

    fun getUserFromToken(token: String): User? {
        val claims: Jws<Claims> = Jwts.parser()
            .setSigningKey(SECRET_KEY)
            .parseClaimsJws(token)

        val username: String = claims.body.subject

        return User(name = username, password = "")
    }


    // 토큰 유효성 검사
    fun validateToken(token: String): Boolean {
        return try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token)
            true
        } catch (e: Exception) {
            false
        }
    }
}
