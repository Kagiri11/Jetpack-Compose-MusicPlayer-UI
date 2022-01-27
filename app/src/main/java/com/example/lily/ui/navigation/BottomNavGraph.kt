package com.example.lily.ui.navigation

import android.util.Log
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.lily.ui.screens.Trending
import com.example.lily.ui.screens.album.AlbumScreen
import com.example.lily.ui.screens.search.SearchScreen
import com.example.lily.ui.screens.settings.SettingsScreen
import com.example.lily.ui.screens.tracks.TracksScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@ExperimentalMaterialApi
@Composable
fun BottomNavGraph(navController: NavHostController){
    val systemUIController = rememberSystemUiController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = navBackStackEntry?.destination
    if(currentScreen?.label == BottomNavScreen.AlbumScreen.route){
        systemUIController.setStatusBarColor(color = Color.Red)
    }
    NavHost(navController = navController, startDestination = BottomNavScreen.TrendingScreen.route){
        composable(route = BottomNavScreen.TrendingScreen.route){
            Trending(navController = navController)
        }
        composable(route = BottomNavScreen.TracksScreen.route){
            TracksScreen()
        }
        composable(route = BottomNavScreen.SearchScreen.route){
            SearchScreen()
        }
        composable(route = BottomNavScreen.SettingScreen.route){
            SettingsScreen()
        }
        composable(
            route = BottomNavScreen.AlbumScreen.route,
            arguments = listOf(navArgument("albumId"){
                type = NavType.IntType
            }
            )
        ){
            Log.d("albumId",it.arguments?.getInt("albumId").toString())
            val id = it.arguments!!.getInt("albumId")

            AlbumScreen(navController = navController,id)
        }
    }
}