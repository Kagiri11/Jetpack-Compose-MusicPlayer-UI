package com.example.lily.ui.screens.tracks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberImagePainter
import com.example.lily.ui.screens.trending.CustomText
import org.koin.androidx.compose.getViewModel

val images = listOf(
    "https://bravewords.com/medias-static/images/news/2021/61157E5C-dire-straits-bassist-john-illsley-to-release-my-life-in-dire-straits-memoir-in-november-features-foreword-by-mark-knopfler-image.jpeg",
    "https://press.warnerrecords.com/wp-content/uploads/2019/12/Popcaan-by-Jamal-Burger-150x150.jpg",
    "https://direct.rhapsody.com/imageserver/images/alb.355323472/500x500.jpg",
    "https://www.reggaeville.com/fileadmin/user_upload/seanpaul.jpg",
    "https://1.bp.blogspot.com/-Kf2jsiheeFI/X0C-xVHJwDI/AAAAAAAAD5Y/YBPGNgiA7gUZku4dbjNO9UV-ULqetZwowCLcBGAsYHQ/w320-h317/Solana-ft.-Joeboy-%25E2%2580%2593-Far-Away.jpg",
    "https://resources.tidal.com/images/debf2942/0f33/44c7/89f9/dc9c681f3ffd/320x320.jpg",
    "https://resources.tidal.com/images/3b4e281e/eac3/49a8/9ea9/5753ede959f9/320x320.jpg"
)

@Composable
fun TracksScreen(modifier: Modifier = Modifier) {

    val tracksViewModel : TracksViewModel = getViewModel()
    val songs = tracksViewModel.tracks.value

    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color.White
    ) {
        ConstraintLayout(modifier = modifier.fillMaxSize()) {
            val (screenTitle, trackList) = createRefs()
            CustomText(
                text = "Songs",
                style = MaterialTheme.typography.h1,
                modifier = modifier.constrainAs(screenTitle) {
                    top.linkTo(parent.top, margin = 30.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                })
            LazyColumn(modifier = modifier.constrainAs(trackList){
                top.linkTo(screenTitle.bottom,margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                height= Dimension.fillToConstraints
            },
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ){
                items(songs.data){ song->
                    TrackItem(trackCover = song.album.cover_medium,songArtistName = song.artist.name,songTitle = song.title_short,songDuration = song.duration)
                }
            }
        }
    }
}

@Composable
fun TrackItem(
    modifier: Modifier = Modifier,
    trackCover: String?="",
    songArtistName: String? = "NewDay",
    songTitle: String?="Painting in the sky",
    songDuration: Int
) {
    val minutes = songDuration/60
    val seconds = songDuration%60
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        ConstraintLayout(modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()) {
            val (trackImage, trackArtist, trackTitle, trackDuration) = createRefs()
            Card(modifier = modifier
                .size(60.dp)
                .constrainAs(trackImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start, margin = 20.dp)
                    bottom.linkTo(parent.bottom)

                }, shape = RoundedCornerShape(20)
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
                text = songTitle?:"",
                style = MaterialTheme.typography.body1,
                modifier = modifier.constrainAs(trackTitle) {
                top.linkTo(trackImage.top)
                    start.linkTo(trackImage.end,margin = 20.dp)
                })
            CustomText(
                text = songArtistName?:" ",
                style = MaterialTheme.typography.body2,
                modifier = modifier.constrainAs(trackArtist) {
                    top.linkTo(trackTitle.bottom,margin = 10.dp)
                    start.linkTo(trackImage.end,margin = 20.dp)
                })
            CustomText(
                text = "$minutes:$seconds",
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
    TracksScreen()
}

