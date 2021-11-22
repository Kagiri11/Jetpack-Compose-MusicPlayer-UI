package com.example.lily.ui.screens.album

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.graphics.painter.Painter
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.domain.models.album.AlbumTrack
import com.example.lily.R
import com.example.lily.ui.screens.CustomText
import com.example.lily.ui.theme.fonts
import org.koin.androidx.compose.inject
import timber.log.Timber

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

fun AlbumScreen(navController: NavController) {
    val viewModel: AlbumViewModel by inject()
    val album = viewModel.album.value

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (albumImage, musicCard, albumName) = createRefs()

        AlbumImage(
            modifier = Modifier.constrainAs(albumImage) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },album.cover_xl
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
fun AlbumImage(modifier: Modifier = Modifier,albumImageUrl:String) {
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
        contentScale = ContentScale.Fit
    )
}

@Composable
fun AlbumMusicCard(modifier: Modifier = Modifier,songs:List<AlbumTrack>) {

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
            val (musicColumn,mybox) = createRefs()

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
                    .fillMaxWidth()
                ,
                contentPadding = PaddingValues(10.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                items(songs){ number->
                    AlbumMusicItem(1,number)
                }

            }

        }
    }
}

@Composable
fun AlbumMusicItem(position:Int ,track:AlbumTrack) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
        ,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(20.dp))
        CustomText(text = position.toString(), style = TextStyle(color = Color.Black,fontSize = 12.sp))
        Spacer(modifier = Modifier.width(40.dp))
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.Start
        ) {
            CustomText(text = track.title_short, style = MaterialTheme.typography.body1)
            CustomText(text = track.artist.name, style = MaterialTheme.typography.body2)
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}
