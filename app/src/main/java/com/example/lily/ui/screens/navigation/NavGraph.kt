package com.example.lily.ui.screens.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lily.ui.screens.Trending
import com.example.lily.ui.screens.album.AlbumScreen


@ExperimentalMaterialApi
@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = Screen.Trending.route){
        composable(route = Screen.Trending.route){
            Trending(navController=navController)
        }
        composable(route = Screen.AlbumScreen.route){
            AlbumScreen(navController=navController)
        }
    }
}