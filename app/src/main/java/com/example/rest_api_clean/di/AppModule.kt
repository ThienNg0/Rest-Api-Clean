package com.example.rest_api_clean.di

import android.app.Application
import androidx.room.Room
import com.example.rest_api_clean.data.local.UserDao
import com.example.rest_api_clean.data.local.UserDatabase
import com.example.rest_api_clean.data.remote.UserApiService
import com.example.rest_api_clean.data.repository.UserRepositoryImpl
import com.example.rest_api_clean.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    companion object {
        @Provides
        @Singleton
        fun provideRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        @Singleton
        fun provideUserApiService(retrofit: Retrofit): UserApiService {
            return retrofit.create(UserApiService::class.java)
        }

        @Provides
        @Singleton
        fun provideUserDatabase(application: Application): UserDatabase {
            return Room.databaseBuilder(
                application,
                UserDatabase::class.java,
                "user_database"
            ).build()
        }

        @Provides
        @Singleton
        fun provideUserDao(database: UserDatabase): UserDao {
            return database.userDao()
        }
    }
}