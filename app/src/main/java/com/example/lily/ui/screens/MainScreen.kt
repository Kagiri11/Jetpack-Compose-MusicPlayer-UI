package com.example.lily.ui.screens

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lily.ui.screens.navigation.BottomNavGraph
import com.example.lily.ui.screens.navigation.BottomNavScreen
import com.example.lily.ui.screens.navigation.SetupNavGraph
import com.example.lily.R

@ExperimentalMaterialApi
@Composable
fun ParentScreen(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { LilyBottomNavigation(navHostController = navController)},
    ){

        BottomNavGraph(navController = navController)
    }
}


@Composable
fun LilyBottomNavigation(navHostController: NavHostController){
    val navigationScreens = listOf(
        BottomNavScreen.TracksScreen,
        BottomNavScreen.TrendingScreen,
        BottomNavScreen.SearchScreen,
        BottomNavScreen.SettingScreen,
    )
    
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentScreen = navBackStackEntry?.destination
    BottomNavigation(
        backgroundColor = Color.White
    ) {
        navigationScreens.forEach { screen->
            AddBottomNavItem(screen =screen , currentScreen = currentScreen , navController = navHostController)
        }
    }
}

@Composable
fun RowScope.AddBottomNavItem(
    screen: BottomNavScreen,
    currentScreen: NavDestination?,
    navController: NavHostController
){
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
           Icon(painter = painterResource(id = screen.icon), contentDescription = screen.title)
        },
        selected = currentScreen?.hierarchy?.any { 
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        },
        alwaysShowLabel = false
    )
}