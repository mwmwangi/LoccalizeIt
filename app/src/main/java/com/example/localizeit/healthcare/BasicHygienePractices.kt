package com.example.localizeit.healthcare



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

@Composable
fun BasicHygieneProjectsScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFFa8edea), Color(0xFFfed6e3))
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
            text = "🧼 Basic Hygiene Projects",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Clean environments promote good health. Learn low-cost hygiene solutions for homes, schools, and communities.",
            fontSize = 16.sp,
            color = Color.White.copy(alpha = 0.95f),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "🎬 Watch: Hygiene Practices",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(8.dp))
        HygieneVideoPlayer(videoUrl = "https://www.example.com/hygiene_intro.mp4")

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "🧽 Community Hygiene Project Ideas",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        val projects = listOf(
            "🚰 Build a tippy tap for handwashing",
            "🧹 Organize a community clean-up day",
            "♻️ Set up a simple waste separation system",
            "🧴 Teach how to make soap using local materials",
            "🚽 Promote latrine construction with hygiene tips"
        )

        Spacer(modifier = Modifier.height(12.dp))

        projects.forEach { project ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.95f)),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Text(
                    text = project,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "📋 Project Activity",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Text(
            text = "Choose one project above. Write a list of materials needed, assign roles to community members, and set a target date to launch it. Document the process with photos or short videos.",
            fontSize = 16.sp,
            color = Color.White.copy(alpha = 0.95f),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun HygieneVideoPlayer(videoUrl: String) {
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
