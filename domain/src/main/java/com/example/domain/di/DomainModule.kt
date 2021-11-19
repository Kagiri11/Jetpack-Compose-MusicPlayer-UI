package com.example.domain.di

import com.example.domain.usecases.FetchAlbum
import com.example.domain.usecases.FetchTrack
import org.koin.dsl.module

val domainModule = module {
    single { FetchAlbum(get()) }
    single { FetchTrack(get()) }
}