package com.example.lily.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.lily.R

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
fun Trending() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (appTitle, trendingList, releaseTitle, releaseList) = createRefs()
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
                    }
            )
            CustomText(
                text = "New Releases",
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
                    }
            )
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
fun TrendingSongs(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(all = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(images) { url ->
            TrendingImage(url)
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

@Composable
fun ReleasedItem(modifier: Modifier = Modifier) {
//    Surface(
//        modifier = Modifier.fillMaxWidth().
//    ) {
//
//    }
    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(all=10.dp)

    ) {
        items(images) { url->
            ReleasedItemComposable(url)
        }
    }
}

@Composable
fun ReleasedItemComposable(imageUrl: String) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(color = Color.White)

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
            elevation = 8.dp, backgroundColor = Color.Magenta
        ) {
            val imagePainter = rememberImagePainter(
                data = imageUrl,

            ) as Painter
            Image(
                painter = imagePainter,
                contentDescription = null,
                contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize()
            )
        }
        CustomText(
            text = "Milky Chance",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.constrainAs(artistName) {
                top.linkTo(parent.top, margin = 10.dp)
                start.linkTo(imageCard.end, margin = 15.dp)
            }
        )
        CustomText(
            text = "Sadnecessary",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.constrainAs(albumName){
                start.linkTo(imageCard.end,margin = 15.dp)
                top.linkTo(artistName.bottom)
            }

        )
        CustomText(
            text = "2 mins ago",
            style = MaterialTheme.typography.body2,
            modifier = Modifier.constrainAs(releasedTime){
                start.linkTo(imageCard.end, margin = 15.dp)
                top.linkTo(albumName.bottom,)
            }
        )
    }
}
