package com.fazlerabbikhan.reqresjc.domain.repository

import com.fazlerabbikhan.reqresjc.data.remote.user_detail_dto.UserDetailDto
import com.fazlerabbikhan.reqresjc.data.remote.user_dto.UserDto

interface UserRepository {

    suspend fun getUsers(): UserDto

    suspend fun getUserById(userId: String): UserDetailDto
}