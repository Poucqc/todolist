package com.teamsparta.todolist.security.oauth.socialMemberRepository

import com.teamsparta.todolist.security.oauth.socialMemberModel.SocialMember
import org.springframework.data.jpa.repository.JpaRepository

interface SocialMemberRepository: JpaRepository<SocialMember, Long> {

    fun findByProviderNameAndProviderId(providerName: String, providerId: String) : SocialMember?
}