package com.example.lily.ui.screens.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.example.lily.R

sealed class Screen(val route:String){
    object Trending : Screen(route="trending_screen")
    object AlbumScreen: Screen(route="album_screen/{albumId}")
}

sealed class BottomNavScreen(
    val route: String,
    val title: String,
    val icon: Int
){
    object TrendingScreen: BottomNavScreen(
        route = "trending",
        title = "Trending",
        icon = R.drawable.ic_trending
    )
    object TracksScreen: BottomNavScreen(
        route = "tracks",
        title = "Tracks",
        icon = R.drawable.ic_library_music
    )

    object SearchScreen: BottomNavScreen(
        route = "search",
        title = "Search",
        icon = R.drawable.ic_search
    )

    object SettingScreen: BottomNavScreen(
        route = "settings",
        title = "Settings",
        icon = R.drawable.ic_settings
    )
    object AlbumScreen: BottomNavScreen(route="album_screen/{albumId}",title = "album",R.drawable.ic_search)

}
