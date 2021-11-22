package com.example.lily.ui.screens.navigation

sealed class Screen(val route:String){
    object Trending : Screen(route="trending_screen")
    object AlbumScreen: Screen(route="album_screen")
}
