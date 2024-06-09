package com.teamsparta.todolist.security.oauth

import com.teamsparta.todolist.security.oauth.oauth2Config.KakaoOAuth2Config
import com.teamsparta.todolist.security.oauth.dto.OAuth2TokenResponse
import com.teamsparta.todolist.security.oauth.dto.OAuth2UserInfoResponse
import org.springframework.http.HttpStatusCode
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestClient
import org.springframework.web.client.body

@Component
class OAuth2LoginClient(
    private val kakaoOAuth2Config: KakaoOAuth2Config,
    private val restClient: RestClient
) {

    fun generateLoginPage(): String =
        StringBuilder(kakaoOAuth2Config.authServerBaseUrl)
        .append("/oauth/authorize")
            .append("?client_id=").append(kakaoOAuth2Config.clientId)
            .append("&redirect_url=").append(kakaoOAuth2Config.redirectUrl)
            .append("&response_type=code").append("code")
            .toString()

    fun getAccessToken(code: String): String {
        val requestData= mutableMapOf(
            "grand_type" to "authorization_code",
            "client_id" to kakaoOAuth2Config.clientId,
            "code" to code,
        )
        return restClient.post()
            .uri("${kakaoOAuth2Config.resourceServerBaseUrl}/oauth/token")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .body(LinkedMultiValueMap<String, String>().apply { this.setAll(requestData) })
            .retrieve()
            .onStatus(HttpStatusCode::isError) { _, _ ->
                throw RuntimeException("카카오 AccessToken 조회 실패")
            }
            .body<OAuth2TokenResponse>()
            ?.accessToken
            ?: throw RuntimeException("카카오 AccessToken 조회 실패")
    }

    fun retrieveUserInfo(accessToken: String): OAuth2UserInfoResponse {
        return restClient.get()
            .uri("${kakaoOAuth2Config.resourceServerBaseUrl}/v2/user/me")
            .header("Authorization", "Bearer $accessToken")
            .retrieve()
            .onStatus(HttpStatusCode::isError) { _, _ ->
                throw RuntimeException("UserInfo 조회 실패")
            }
            .body<OAuth2UserInfoResponse>()
            ?: throw RuntimeException("UserInfo 조회 실패")
    }
}