package com.teamsparta.todolist.security.oauth.socialMemberService

import com.teamsparta.todolist.security.oauth.socialMemberRepository.SocialMemberRepository
import com.teamsparta.todolist.security.oauth.socialMemberModel.SocialMember
import com.teamsparta.todolist.security.oauth.dto.OAuth2UserInfoResponse
import org.springframework.stereotype.Service

@Service
class SocialMemberService(
    private val socialMemberRepository: SocialMemberRepository
) {

    fun registerIfAbsent(userInfo : OAuth2UserInfoResponse): SocialMember =
        socialMemberRepository.findByProviderNameAndProviderId("KAKAO", userInfo.id.toString())
            ?:socialMemberRepository.save(
                SocialMember(
                    providerName = "KAKAO",
                    providerId = userInfo.id.toString(),
                    name = userInfo.properties.nickname
                )
            )
}