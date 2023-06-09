package com.example.smcardcompose.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smcardcompose.R
import com.example.smcardcompose.domain.FeedPost
import com.example.smcardcompose.domain.StatisticItem
import com.example.smcardcompose.domain.StatisticType
import com.example.smcardcompose.ui.theme.SMCardComposeTheme

@Composable
fun SMCard(
    modifier: Modifier = Modifier,
    feedPost: FeedPost,
    onViewClickListener: (StatisticItem) -> Unit,
    onShareClickListener: (StatisticItem) -> Unit,
    onCommentClickListener: (StatisticItem) -> Unit,
    onLikeClickListener: (StatisticItem) -> Unit,
//    onStatisticsItemClickListener: (StatisticItem) -> Unit
) {
    Card(
        modifier = modifier
            .verticalScroll(rememberScrollState()),
        shape = RoundedCornerShape(6.dp),

        ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            PostHeader(feedPost)

            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = feedPost.contentText,
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify
            )

            Spacer(modifier = Modifier.height(8.dp))

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .border(2.dp, Color.Black),
                painter = painterResource(id = feedPost.contentImageResId),
                contentDescription = "poster",
                contentScale = ContentScale.Fit,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Statistics(
                statistics = feedPost.statistics,
                onViewClickListener = onViewClickListener,
                onShareClickListener = onShareClickListener,
                onCommentClickListener = onCommentClickListener,
                onLikeClickListener = onLikeClickListener
            )
            //            BoxColors()
        }
    }
}

@Composable
private fun Statistics(
    statistics: List<StatisticItem>,
    onViewClickListener: (StatisticItem) -> Unit,
    onShareClickListener: (StatisticItem) -> Unit,
    onCommentClickListener: (StatisticItem) -> Unit,
    onLikeClickListener: (StatisticItem) -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {

        Row(
            modifier = Modifier
                .weight(1f),
        ) {
            val viewsItem = statistics.getItemByType(StatisticType.VIEWS)
            ViewsCountInfo(views = viewsItem.count.toString(),
                onItemClickListener = {
                    Log.d("Test", "SMCard ViewsCountInfo Clicked")
                    onViewClickListener(viewsItem)
                })
        }

        Row(
            modifier = Modifier
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val sharesItem = statistics.getItemByType(StatisticType.SHARES)
            val commentsItem = statistics.getItemByType(StatisticType.COMMENTS)
            val likesItem = statistics.getItemByType(StatisticType.LIKES)

            SharesCountInfo(shares = sharesItem.count.toString(),
                onItemClickListener = {
                    Log.d("Test", "SMCard ShareCountInfo Clicked")
                    onShareClickListener(sharesItem)
                })
            CommentsCountInfo(comments = commentsItem.count.toString(),
                onItemClickListener = {
                    Log.d("Test", "SMCard CommentsCountInfo Clicked")
                    onCommentClickListener(commentsItem)
                })
            LikesCountInfo(likes = likesItem.count.toString(),
                onItemClickListener = {
                    Log.d("Test", "SMCard LikesCountInfo Clicked")
                    onLikeClickListener(likesItem)
                })
        }
    }
}

private fun List<StatisticItem>.getItemByType(type: StatisticType): StatisticItem {
    return this.find { it.type == type } ?: throw IllegalStateException("Wrong type")
}


@Composable
private fun PostHeader(
    feedPost: FeedPost
) {
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

            painter = painterResource(id = feedPost.avatarResId),
            contentDescription = ""
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier
                .weight(1f),
        ) {
            Text(
                text = feedPost.communityName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = feedPost.publicationDate,
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
}

@Composable
private fun ViewsCountInfo(
    views: String,
    onItemClickListener: () -> Unit
) {
    Row(
        modifier = Modifier.clickable {
            Log.d("Test", "Views modifier clicked")
            onItemClickListener()
        }
    ) {
        Text(
            text = views,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSecondary
        )
        Spacer(modifier = Modifier.width(6.dp))

        Icon(
            painter = painterResource(id = R.drawable.ic_views_count),
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onSecondary
        )

    }
}

@Composable
private fun SharesCountInfo(
    shares: String,
    onItemClickListener: () -> Unit
) {
    Row(
        modifier = Modifier.clickable {
            Log.d("Test", "Shares modifier clicked")
            onItemClickListener()
        }
    ) {
        Text(
            text = shares,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSecondary
        )

        Spacer(modifier = Modifier.width(6.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_share),
            contentDescription = "",

            )
    }
}

@Composable
private fun CommentsCountInfo(
    comments: String,
    onItemClickListener: () -> Unit
) {
    Row(
        modifier = Modifier.clickable {
            Log.d("Test", "Comments modifier clicked")
            onItemClickListener()
        }
    ) {
        Text(
            text = comments,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSecondary
        )

        Spacer(modifier = Modifier.width(6.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_comment),
            contentDescription = ""
        )
    }
}

@Composable
private fun LikesCountInfo(
    likes: String,
    onItemClickListener: () -> Unit
) {
    Row(
        modifier = Modifier.clickable {
            Log.d("Test", "Likes modifier clicked")
            onItemClickListener()
        }
    ) {
        Text(
            text = likes,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSecondary
        )

        Spacer(modifier = Modifier.width(6.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_like),
            contentDescription = ""
        )

    }
}

@Preview
@Composable
fun PreviewSMCLightTheme() {

    SMCardComposeTheme(
        darkTheme = false,
        dynamicColor = false
    ) {
        SMCard(feedPost = FeedPost(),
            onViewClickListener = {},
            onShareClickListener = {},
            onCommentClickListener = {},
            onLikeClickListener = {})

    }
}

@Preview
@Composable
fun PreviewSMCDarkTheme() {
    SMCardComposeTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        SMCard(feedPost = FeedPost(),
            onViewClickListener = {},
            onShareClickListener = {},
            onCommentClickListener = {},
            onLikeClickListener = {})

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