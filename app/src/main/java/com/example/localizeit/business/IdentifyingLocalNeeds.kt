package com.example.localizeit.business



import android.net.Uri
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun IdentifyingLocalNeedsScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFFE0C3FC), Color(0xFF8EC5FC))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .verticalScroll(scrollState)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "🔍 Identifying Local Needs",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Understanding your community is the first step to building a successful business. This module will help you learn how to identify real needs in your local area.",
            fontSize = 16.sp,
            color = Color.White.copy(alpha = 0.95f),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "📺 Introduction Video",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(8.dp))
        LocalNeedsVideoPlayer(videoUrl = "https://www.example.com/identify_needs.mp4")

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Key Topics Covered",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(12.dp))
        val topics = listOf(
            "🗣️ Talking to locals",
            "📊 Conducting informal surveys",
            "🏪 Observing market gaps",
            "📈 Understanding buying patterns",
            "🌍 Considering cultural and seasonal needs"
        )

        topics.forEach { topic ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.95f)),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Text(
                    text = topic,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "📝 Activity: Community Mapping",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Text(
            text = "Draw or note a map of your area and mark where people gather, what shops are missing, or what services are lacking. Share this with mentors or peers for feedback.",
            fontSize = 16.sp,
            color = Color.White.copy(alpha = 0.95f),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun LocalNeedsVideoPlayer(videoUrl: String) {
    val context = LocalContext.current
    val exoPlayer = remember(videoUrl) {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(Uri.parse(videoUrl)))
            prepare()
            playWhenReady = false
        }
    }

    AndroidView(
        factory = { ctx ->
            PlayerView(ctx).apply {
                player = exoPlayer
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    600
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    )
}
