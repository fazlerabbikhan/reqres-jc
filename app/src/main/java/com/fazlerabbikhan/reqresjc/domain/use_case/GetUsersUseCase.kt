package com.fazlerabbikhan.reqresjc.domain.use_case

import com.fazlerabbikhan.reqresjc.common.Resource
import com.fazlerabbikhan.reqresjc.data.remote.user_dto.toUser
import com.fazlerabbikhan.reqresjc.domain.model.User
import com.fazlerabbikhan.reqresjc.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke(): Flow<Resource<List<User>>> = flow {
        try {
            emit(Resource.Loading<List<User>>())
            val users = repository.getUsers().data.map { it.toUser() }
            emit(Resource.Success<List<User>>(users))
        } catch(e: HttpException) {
            emit(Resource.Error<List<User>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error<List<User>>("Couldn't reach server. Check your internet connection."))
        }
    }
}