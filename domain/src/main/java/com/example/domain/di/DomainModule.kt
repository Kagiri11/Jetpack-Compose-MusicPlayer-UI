package com.example.domain.di

import com.example.domain.usecases.FetchAlbum
import com.example.domain.usecases.FetchEditorial
import com.example.domain.usecases.FetchSongs
import org.koin.dsl.module

val domainModule = module {
    single { FetchAlbum(get()) }
    single { FetchEditorial(get()) }
    single { FetchSongs(get()) }
}