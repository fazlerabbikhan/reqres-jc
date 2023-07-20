package com.fazlerabbikhan.reqresjc.domain.repository

import com.fazlerabbikhan.reqresjc.data.remote.user_detail_dto.UserDetailDto
import com.fazlerabbikhan.reqresjc.data.remote.users_dto.UsersDto

interface UserRepository {

    suspend fun getUsers(): UsersDto

    suspend fun getUserById(userId: String): UserDetailDto
}