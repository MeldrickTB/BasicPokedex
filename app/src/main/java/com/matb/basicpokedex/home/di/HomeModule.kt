package com.matb.basicpokedex.home.di

import com.matb.basicpokedex.home.data.remote.HomeApi
import com.matb.basicpokedex.home.data.repository.HomeRepositoryImpl
import com.matb.basicpokedex.home.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

/**
 * Created by meldricktb$ on 13/09/23$.
 */
@Module
@InstallIn(SingletonComponent::class)
object HomeModule {
    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        ).build()
    }

    @Singleton
    @Provides
    fun provideApi(okHttpClient: OkHttpClient): HomeApi {
        return Retrofit.Builder().baseUrl(HomeApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient).build().create()
    }

    @Provides
    @Singleton
    fun provideRepository(api: HomeApi): HomeRepository {
        return HomeRepositoryImpl(api)
    }
}