package com.example.lily

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.lily.ui.screens.ParentScreen
import com.example.lily.ui.screens.Trending
import com.example.lily.ui.theme.LILYTheme

class MainActivity : ComponentActivity() {

    lateinit var navHostController: NavHostController

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LILYTheme {
                ParentScreen()
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun MainLayout(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (navScreen, bottomNav) = createRefs()
        Trending(
            modifier = Modifier.constrainAs(navScreen){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(bottomNav.top)
            },
            navController = rememberNavController()
        )
        LilyBottomNav(
            modifier = Modifier.constrainAs(bottomNav){
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LILYTheme {
        Greeting("Android")
    }
}

@Composable
@Preview
fun LilyBottomNav(modifier: Modifier = Modifier){
    BottomNavigation(
        modifier = modifier
        ,
        elevation = 20.dp,backgroundColor = Color.White

    ) {

    }
}
