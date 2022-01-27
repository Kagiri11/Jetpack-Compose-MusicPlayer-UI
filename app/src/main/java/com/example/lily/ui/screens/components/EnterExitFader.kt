package com.example.lily.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun EnterExitFader(modifier: Modifier) {
    Image(
        painter = rememberImagePainter(data = ""),
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .drawWithCache {
                val gradient = Brush.verticalGradient(
                    colors = listOf( Color.White, Color.Transparent),
                    startY = size.height / 5,
                    endY = size.height
                )
                onDrawWithContent {
                    drawContent()
                    drawRect(gradient, blendMode = BlendMode.Multiply)
                }
            })
}