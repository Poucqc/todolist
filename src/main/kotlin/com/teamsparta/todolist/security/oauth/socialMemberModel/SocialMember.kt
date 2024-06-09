package com.teamsparta.todolist.security.oauth.socialMemberModel

import jakarta.persistence.*

@Entity
class SocialMember(

    val providerName : String,

    val providerId : String,

    var name: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null
}
