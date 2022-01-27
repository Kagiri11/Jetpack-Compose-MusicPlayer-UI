package com.example.lily.ui.navigation

import android.util.Log
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.lily.ui.screens.trending.Trending
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
        composable(
            route = Screen.AlbumScreen.route,
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