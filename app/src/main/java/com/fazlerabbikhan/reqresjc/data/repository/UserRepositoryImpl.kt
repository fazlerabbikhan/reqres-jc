package com.fazlerabbikhan.reqresjc.data.repository

import com.fazlerabbikhan.reqresjc.data.remote.ReqresApi
import com.fazlerabbikhan.reqresjc.data.remote.user_detail_dto.UserDetailDto
import com.fazlerabbikhan.reqresjc.data.remote.users_dto.UsersDto
import com.fazlerabbikhan.reqresjc.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: ReqresApi
) : UserRepository {

    override suspend fun getUsers(): UsersDto {
        return api.getUsers()
    }

    override suspend fun getUserById(userId: String): UserDetailDto {
        return api.getUserById(userId)
    }
}