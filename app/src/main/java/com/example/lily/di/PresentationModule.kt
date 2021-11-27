package com.example.lily.di

import com.example.lily.ui.screens.album.AlbumViewModel
import com.example.lily.ui.screens.tracks.TracksViewModel
import com.example.lily.ui.screens.trending.TrendingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
   viewModel { TrendingViewModel(get(),get()) }
   viewModel { AlbumViewModel(get()) }
   viewModel { TracksViewModel(get()) }
}