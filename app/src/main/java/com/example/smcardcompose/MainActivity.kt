package com.example.smcardcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
            SMCardComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
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
            .padding(8.dp),
        shape = RoundedCornerShape(4.dp)

    ) {
        Column() {
            Row(
                modifier = Modifier
                    .background(Color.Yellow)
                    .fillMaxWidth(),
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
                        .background(Color.Magenta)
                        .weight(1f),
                ) {
                    Text(
                        text = "Foxxx",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "23:23",
                        color = Color.Gray
                    )
                }

                Image(
                    modifier = Modifier
                        .size(40.dp)
                        .padding(8.dp),
                    painter = painterResource(id = R.drawable.ic_three_dots_vertical),
                    contentDescription = ""
                )
            }

            Row(
                modifier = Modifier
                    .background(Color.Cyan)
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
            )
            Row(
                modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .padding(8.dp),

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                ViewsCountInfo(views = "233")
                Spacer(modifier = Modifier.width(130.dp))

                ShareCountInfo(shares = "130")
                Spacer(modifier = Modifier.width(10.dp))

                CommentsCountInfo(comments = "30")
                Spacer(modifier = Modifier.width(10.dp))

                LikesCountInfo(likes = "200")



            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun SMCardPreview() {
    SMCardComposeTheme {
        SMCard()
    }
}


@Composable
private fun UserInfo(nickName: String, time: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = nickName,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,

            )

        Text(
            text = time,
            fontStyle = FontStyle.Normal,
            color = Color.Gray,
            fontSize = 14.sp,

            )
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

        Image(
            painter = painterResource(id = R.drawable.ic_like),
            contentDescription = ""
        )

    }
}