package com.teamsparta.todolist.security.oauth.dto

data class OAuth2UserInfoResponse(
    val id : Long,
    val properties:OAuth2UserPropertiesResponse
)
