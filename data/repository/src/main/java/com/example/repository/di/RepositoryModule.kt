package com.example.repository.di

import com.example.domain.repository.AppRepository
import com.example.repository.sources.AppRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module{
    single<AppRepository>{AppRepositoryImpl(get())}
}