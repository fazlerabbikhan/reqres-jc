package com.fazlerabbikhan.reqresjc.data.remote

import com.fazlerabbikhan.reqresjc.data.remote.user_detail_dto.UserDetailDto
import com.fazlerabbikhan.reqresjc.data.remote.users_dto.UsersDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ReqresApi {

    @GET("/api/users?per_page=12")
    suspend fun getUsers(): UsersDto

    @GET("/api/users/{userId}")
    suspend fun getUserById(@Path("userId") userId: String): UserDetailDto
}