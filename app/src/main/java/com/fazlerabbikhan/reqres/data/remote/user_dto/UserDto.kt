package com.fazlerabbikhan.reqres.data.remote.user_dto

import com.fazlerabbikhan.reqres.domain.model.User

data class UserDto(
    val data: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)

//fun UserDto.toUser(): List<User> {
//    return data.map { user ->
//        User(
//            id = user.id,
//            avatar = user.avatar,
//            first_name = user.first_name,
//            last_name = user.last_name,
//            email = user.email
//        )
//    }
//}

//fun UserDto.toUser(): User {
//    return User(
//        id = data.map { it.id }[0],
//        avatar = data.map { it.avatar }[0],
//        first_name = data.map { it.first_name }[0],
//        last_name = data.map { it.last_name }[0],
//        email = data.map { it.email }[0]
//    )
//}