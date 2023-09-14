package com.matb.basicpokedex.detail.di

import com.matb.basicpokedex.detail.data.DetailRepositoryImpl
import com.matb.basicpokedex.detail.data.remote.dto.DetailApi
import com.matb.basicpokedex.detail.domain.repository.DetailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

/**
 * Created by meldricktb$ on 13/09/23$.
 */
@Module
@InstallIn(SingletonComponent::class)
object DetailModule {
    @Singleton
    @Provides
    fun provideApi(okHttpClient: OkHttpClient): DetailApi {
        return Retrofit.Builder().baseUrl(DetailApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient).build().create()
    }

    @Provides
    @Singleton
    fun provideRepository(api: DetailApi): DetailRepository {
        return DetailRepositoryImpl(api)
    }
}