package com.example.appplantery.common.model

import java.util.UUID

object DataBase {

    val usersAuth = hashSetOf<UserAuth>()
    val photos = hashSetOf<Photo>()

    var sessionAuth: UserAuth? = null

    init {
        usersAuth.add(UserAuth(UUID.randomUUID().toString(), "UserA", "userA@gmail.com", "12345678"))
        usersAuth.add(UserAuth(UUID.randomUUID().toString(), "UserB", "userB@gmail.com", "87654321"))

//        sessionAuth = usersAuth.first()
    }
}