package com.example.network.di

import com.example.network.apis.ApiDirect
import com.example.network.apis.ApiService
import com.example.network.utils.Constants.BASE_URL
import com.example.network.utils.Constants.BASE_URL2
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule= module {
    val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()
    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(BASE_URL)
            .build()
            .create(ApiService::class.java)
    }
}
