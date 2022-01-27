package com.example.lily.ui.screens.album

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.domain.models.album.AlbumTrack
import com.example.lily.ui.screens.trending.CustomText
import com.example.lily.ui.theme.fonts
import org.koin.androidx.compose.inject

@Composable
fun AlbumScreen(navController: NavController, albumId: Int) {
    val viewModel: AlbumViewModel by inject()
    viewModel.getAlbum(albumId)
    val album = viewModel.album.value

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (albumImage, musicCard, albumName) = createRefs()

        AlbumImage(
            modifier = Modifier.constrainAs(albumImage) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }, album.cover_xl
        )
        AlbumMusicCard(
            modifier = Modifier.constrainAs(musicCard) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(albumImage.bottom, margin = (-40).dp)
                height = Dimension.fillToConstraints
            },
            album.tracks.data
        )
        CustomText(
            text = album.title,
            style = TextStyle(
                color = Color.White,
                fontSize = 22.sp, fontWeight = FontWeight.Bold, fontFamily = fonts
            ),
            modifier = Modifier.constrainAs(albumName) {
                bottom.linkTo(musicCard.top, margin = 20.dp)
                end.linkTo(parent.end, margin = 20.dp)
            }
        )
//        createVerticalChain(albumImage,musicCard,chainStyle = ChainStyle.SpreadInside)
    }
}

@Composable
fun AlbumImage(modifier: Modifier = Modifier, albumImageUrl: String) {
    val img =
        rememberImagePainter(
            data = albumImageUrl,
        ) as Painter
    Image(
        painter = img,
        contentDescription = "",
        modifier = modifier
            .height(400.dp)
            .fillMaxWidth()
            .drawWithCache {
                val gradient = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Black),
                    startY = size.height / 9,
                    endY = size.height
                )
                onDrawWithContent {
                    drawContent()
                    drawRect(gradient, blendMode = BlendMode.Multiply)

                }
            },
        contentScale = ContentScale.Crop
    )
}

@Composable
fun AlbumMusicCard(modifier: Modifier = Modifier, songs: List<AlbumTrack>) {

    Card(
        modifier = modifier
            .fillMaxWidth(),
        backgroundColor = Color.White,
        shape = RoundedCornerShape(topStart = 50.dp),
        elevation = 10.dp
    ) {
        ConstraintLayout(
            modifier.fillMaxSize()
        ) {
            val (musicColumn, mybox) = createRefs()

            LazyColumn(
                modifier = modifier
                    .height(300.dp)
                    .constrainAs(musicColumn) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        height = Dimension.fillToConstraints
                    }
                    .fillMaxWidth(),
                contentPadding = PaddingValues(10.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                itemsIndexed(songs) { index, track ->
                    AlbumMusicItem(
                        position = index + 1,
                        trackTitle = track.title,
                        artistName = track.artist.name
                    )

                }

            }

        }
    }
}

@Composable
fun AlbumMusicItem(position: Int, trackTitle: String, artistName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(20.dp))
        CustomText(
            text = position.toString(),
            style = TextStyle(color = Color.Black, fontSize = 12.sp, textAlign = TextAlign.Center)
        )
        Spacer(modifier = Modifier.width(40.dp))
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.Start
        ) {
            CustomText(text = trackTitle, style = MaterialTheme.typography.body1)
            CustomText(text = artistName, style = MaterialTheme.typography.body2)
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}

