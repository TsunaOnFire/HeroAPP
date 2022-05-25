package com.aph.diusframi.core.di

import com.aph.diusframi.data.network.CharacterApiClient
import com.aph.diusframi.data.network.HeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private fun getClient(): OkHttpClient = OkHttpClient.Builder().addInterceptor(HeaderInterceptor()).build()

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()
    }

    @Singleton
    @Provides
    fun provideCharacterApiClient(retrofit: Retrofit):CharacterApiClient{
        return retrofit.create(CharacterApiClient::class.java)
    }
}