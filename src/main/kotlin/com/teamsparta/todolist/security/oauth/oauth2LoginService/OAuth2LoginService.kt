package com.teamsparta.todolist.security.oauth.oauth2LoginService

import com.teamsparta.todolist.domain.user.model.UserRole
import com.teamsparta.todolist.security.jwt.JwtPlugin
import com.teamsparta.todolist.security.oauth.OAuth2LoginClient
import com.teamsparta.todolist.security.oauth.socialMemberService.SocialMemberService
import org.springframework.stereotype.Service

@Service
class OAuth2LoginService(
    private val jwtPlugin: JwtPlugin,
    private val oAuth2LoginClient: OAuth2LoginClient,
    private val socialMemberService: SocialMemberService,
) {

    fun generateLoginPage() : String = oAuth2LoginClient.generateLoginPage()

    fun login(code: String): String =
        oAuth2LoginClient.getAccessToken(code)
            .let(oAuth2LoginClient::retrieveUserInfo)
            .let(socialMemberService::registerIfAbsent)
            .let { jwtPlugin.generateAccessToken(it.id.toString(), it.name, UserRole.User ) }

}