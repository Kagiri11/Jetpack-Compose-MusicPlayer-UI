package com.example.lily.ui.screens.settings

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SettingsScreen(modifier: Modifier = Modifier){
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color.White
    ) {

    }
}

@Composable
@Preview
fun SettingsScreenPreview(){
    SettingsScreen()
}