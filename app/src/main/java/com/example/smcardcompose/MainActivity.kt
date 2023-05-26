package com.example.smcardcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smcardcompose.ui.theme.SMCardComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SMCardComposeTheme(dynamicColor = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SMCard()
                }
            }
        }
    }
}

@Composable
fun SMCard() {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        shape = RoundedCornerShape(4.dp)

    ) {
        Column(modifier = Modifier
            .background( MaterialTheme.colorScheme.background)) {
            Row(
                modifier = Modifier
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Image(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(8.dp),

                    painter = painterResource(id = R.drawable.ic_fox),
                    contentDescription = ""
                )

                Spacer(modifier = Modifier.width(8.dp))

                Column(
                    modifier = Modifier
                        .weight(1f),
                ) {
                    Text(
                        text = "Foxxx",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "23:23",
                        color = MaterialTheme.colorScheme.onSecondary,
                        fontWeight = FontWeight.Bold
                    )
                }

                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .padding(8.dp),
                    painter = painterResource(id = R.drawable.ic_three_dots_vertical),
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start

            ) {
                Text(text = "Horizon forbidden west - игрокино")
            }

            Image(
                modifier = Modifier
                    .border(2.dp, Color.Black),
                painter = painterResource(id = R.drawable.pic_horizon),
                contentDescription = "poster",
                alignment = Alignment.BottomEnd,


                )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                ViewsCountInfo(views = "233")
                Spacer(modifier = Modifier.width(150.dp))

                ShareCountInfo(shares = "130")
                Spacer(modifier = Modifier.width(10.dp))

                CommentsCountInfo(comments = "30")
                Spacer(modifier = Modifier.width(10.dp))

                LikesCountInfo(likes = "200")

            }

            BoxColors()
        }
    }

}
@Composable
private fun ViewsCountInfo(views: String) {
    Row(

    ) {
        Text(
            text = views,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )
        Spacer(modifier = Modifier.width(4.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_views_count),
            contentDescription = ""
        )

    }
}

@Composable
private fun ShareCountInfo(shares: String) {
    Row(

    ) {
        Text(
            text = shares,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )

        Spacer(modifier = Modifier.width(4.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_share),
            contentDescription = ""
        )
    }
}

@Composable
private fun CommentsCountInfo(comments: String) {
    Row(

    ) {
        Text(
            text = comments,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )

        Spacer(modifier = Modifier.width(4.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_comment),
            contentDescription = ""
        )
    }
}

@Composable
private fun LikesCountInfo(likes: String) {
    Row(

    ) {
        Text(
            text = likes,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )

        Spacer(modifier = Modifier.width(4.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_like),
            contentDescription = ""
        )

    }
}

@Preview
@Composable
fun PreviewLightTheme() {
    SMCardComposeTheme(
        darkTheme = false,
        dynamicColor = false
    ) {
        SMCard()

    }
}

@Preview
@Composable
fun PreviewDarkTheme() {
    SMCardComposeTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        SMCard()

    }
}

@Composable
fun BoxColors() {
    Row(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Text(text = "Primary")
        }
        Spacer(
            modifier = Modifier
                .width(4.dp)
        )

        Box(
            modifier = Modifier
                .size(70.dp)
                .background(MaterialTheme.colorScheme.onPrimary)
        ) {
            Text(text = "onPrimary")
        }
        Spacer(
            modifier = Modifier
                .width(4.dp)
        )

        Box(
            modifier = Modifier
                .size(70.dp)
                .background(MaterialTheme.colorScheme.secondary)
        ) {
            Text(text = "Secondary")
        }
        Spacer(
            modifier = Modifier
                .width(4.dp)
        )

        Box(
            modifier = Modifier
                .size(70.dp)
                .background(MaterialTheme.colorScheme.onSecondary)
        ) {
            Text(text = "onSecondary")
        }
        Spacer(
            modifier = Modifier
                .width(4.dp)
        )

        Box(
            modifier = Modifier
                .size(70.dp)
                .background(MaterialTheme.colorScheme.tertiary)
        ) {
            Text(text = "tertiary")
        }
    }
}