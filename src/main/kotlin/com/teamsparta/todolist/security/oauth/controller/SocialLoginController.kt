package com.teamsparta.todolist.security.oauth.controller

import com.teamsparta.todolist.security.oauth.oauth2LoginService.OAuth2LoginService
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SocialLoginController(
    private val oAuth2LoginService : OAuth2LoginService
) {

    @GetMapping("oauth2/login/kakao")
    fun redirectKakaoLoginPage(
        response: HttpServletResponse,
    ) {
    val loginPage = oAuth2LoginService.generateLoginPage()
        response.sendRedirect(loginPage)
    }

    @GetMapping("oauth2/login/callback")
    fun callbackLoginPage(
        @RequestParam code: String,
    ) : ResponseEntity<String> {
        val accessToken= oAuth2LoginService.login(code)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(accessToken)
    }
}