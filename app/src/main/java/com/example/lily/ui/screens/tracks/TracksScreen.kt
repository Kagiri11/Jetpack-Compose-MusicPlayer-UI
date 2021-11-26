package com.example.lily.ui.screens.tracks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import com.example.lily.ui.screens.CustomText

@Composable
fun TracksScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color.White
    ) {
        ConstraintLayout(modifier = modifier.fillMaxSize()) {
            val (screenTitle, trackList) = createRefs()
            CustomText(
                text = "Songs",
                style = MaterialTheme.typography.h6,
                modifier = modifier.constrainAs(screenTitle) {
                    top.linkTo(parent.top, margin = 30.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                })

        }

    }
}

@Composable
fun TrackItem(
    modifier: Modifier = Modifier,
    trackCover: String="",
    songArtistName: String = "NewDay",
    songTitle: String="Painting in the sky",
    songDuration: String="3:14"
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(color = Color.White)
    ) {
        ConstraintLayout(modifier = modifier.fillMaxSize()) {
            val (trackImage, trackArtist, trackTitle, trackDuration) = createRefs()
            Card(modifier = modifier
                .size(80.dp)
                .constrainAs(trackImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start, margin = 20.dp)
                    bottom.linkTo(parent.bottom)

                }, backgroundColor = Color.Magenta, shape = RoundedCornerShape(20)
            ) {
                val imagePainter = rememberImagePainter(
                    data = trackCover,
                    builder = {
                        this.crossfade(1000)
                    }

                ) as Painter
                Image(
                    painter = imagePainter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize()
                )
            }
            CustomText(
                text = songTitle,
                style = MaterialTheme.typography.body1,
                modifier = modifier.constrainAs(trackTitle) {
                top.linkTo(trackImage.top)
                    start.linkTo(trackImage.end,margin = 20.dp)
                })
            CustomText(
                text = songArtistName,
                style = MaterialTheme.typography.body2,
                modifier = modifier.constrainAs(trackArtist) {
                    top.linkTo(trackTitle.bottom,margin = 10.dp)
                    start.linkTo(trackImage.end,margin = 20.dp)
                })
            CustomText(
                text = songDuration,
                style = MaterialTheme.typography.body2,
                modifier = modifier.constrainAs(trackDuration) {
                    bottom.linkTo(trackArtist.bottom)
                    end.linkTo(parent.end,margin = 20.dp)
                })
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TrackScreenPreview() {
    TrackItem()
}

