package com.fazlerabbikhan.reqresjc.di

import com.fazlerabbikhan.reqresjc.common.Constants
import com.fazlerabbikhan.reqresjc.data.remote.ReqresApi
import com.fazlerabbikhan.reqresjc.data.repository.UserRepositoryImpl
import com.fazlerabbikhan.reqresjc.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideReqresApi(): ReqresApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ReqresApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: ReqresApi): UserRepository {
        return UserRepositoryImpl(api)
    }
}