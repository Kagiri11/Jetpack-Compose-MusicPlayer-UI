package com.example.lily.ui.screens.trending

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.domain.models.editorial.*
import com.example.lily.ui.screens.components.EnterExitFader
import org.koin.androidx.compose.getViewModel


@ExperimentalMaterialApi
@Composable
fun Trending(modifier: Modifier = Modifier,navController: NavController) {
    val scrollState = rememberLazyListState()
    val trendingViewModel: TrendingViewModel = getViewModel()
    val isFirstItemVisible = remember{
        derivedStateOf { scrollState.firstVisibleItemIndex != 0 }
    }

    val editorial = remember{ trendingViewModel.edt}

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (appTitle, trendingList, releaseTitle, releaseList, enterExitFader) = createRefs()
            CustomText(
                text = "Trending",
                style = MaterialTheme.typography.h1,
                modifier = Modifier.constrainAs(appTitle) {
                    top.linkTo(parent.top, margin = 30.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                }
            )
            TrendingSongs(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(trendingList) {
                        top.linkTo(appTitle.bottom, margin = 10.dp)
                    },
                editorial.value.artists.data
            )
            CustomText(
                text = "Albums",
                style = MaterialTheme.typography.h2,
                modifier = Modifier.constrainAs(releaseTitle) {
                    top.linkTo(trendingList.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                }
            )
            ReleasedItem(
                modifier = Modifier
                    .constrainAs(releaseList) {
                        top.linkTo(releaseTitle.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        height= Dimension.fillToConstraints
                    },
                editorial.value.albums.data,
                navController,
                columnScrollState = scrollState
            )
            if (isFirstItemVisible.value){
                EnterExitFader(modifier = Modifier
                    .constrainAs(enterExitFader) {
                        top.linkTo(releaseList.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })
            }
        }
    }
}

@Composable
fun CustomText(modifier: Modifier = Modifier, text: String, style: TextStyle) {
    Text(
        text = text,
        modifier = modifier,
        style = style
    )
}

@Composable
fun TrendingSongs(modifier: Modifier = Modifier, artists: List<EditorialArtist>) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(all = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(artists) { artist->
            TrendingImage(artist.picture_medium)
        }
    }
}

@Composable
fun TrendingImage(imageUrl: String) {
    val img =
        rememberImagePainter(
            data = imageUrl,
            builder = {
                this.crossfade(1000)
                transformations(
                    CircleCropTransformation()
                )
            }
        ) as Painter
    Image(
        painter = img,
        contentDescription = "",
        modifier = Modifier
            .size(60.dp)
    )
}


@ExperimentalMaterialApi
@Composable
fun ReleasedItem(modifier: Modifier = Modifier,albums: List<Album>,navController: NavController, columnScrollState: LazyListState) {

    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(all=10.dp),
        state = columnScrollState

    ) {
        items(albums) { album->
            with(album){
                ReleasedItemComposable(
                    this,
                    navController
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun ReleasedItemComposable(album: Album,navController: NavController) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(color = Color.White),

    ) {
        val (imageCard, artistName, albumName, releasedTime) = createRefs()
        Card(
            modifier = Modifier
                .size(100.dp)
                .constrainAs(imageCard) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start, margin = 10.dp)
                    bottom.linkTo(parent.bottom)
                }
            ,
            shape = RoundedCornerShape(10),
            elevation = 8.dp, backgroundColor = Color.Magenta,
            onClick = {
                navController.navigate("album_screen/"+album.id)
            }

        ) {
            val imagePainter = rememberImagePainter(
                data = album.cover_xl,
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
            text = album.title,
            style = MaterialTheme.typography.h3,
            modifier = Modifier.constrainAs(artistName) {
                top.linkTo(parent.top, margin = 10.dp)
                start.linkTo(imageCard.end, margin = 15.dp)
            }
        )
        CustomText(
            text = album.artist.name,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.constrainAs(albumName){
                start.linkTo(imageCard.end,margin = 15.dp)
                top.linkTo(artistName.bottom)
            }

        )
        CustomText(
            text = album.record_type,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.constrainAs(releasedTime){
                start.linkTo(imageCard.end, margin = 15.dp)
                top.linkTo(albumName.bottom,)
            }
        )
    }
}
