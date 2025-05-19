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

@Composable
fun FinancialPlanningScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFFFFD194), Color(0xFF70E1F5))
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
            text = "💰 Financial Planning",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Proper financial planning helps your business stay sustainable. Learn how to manage income, expenses, and prepare for growth.",
            fontSize = 16.sp,
            color = Color.White.copy(alpha = 0.95f),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "📺 Introductory Video",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(8.dp))
        FinancialVideoPlayer(videoUrl = "https://www.example.com/financial_planning_intro.mp4")

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "📘 Key Concepts",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(12.dp))

        val topics = listOf(
            "📈 Budgeting: Track what comes in and what goes out",
            "🧾 Record-keeping: Maintain daily, weekly, and monthly records",
            "📉 Managing debt and credit responsibly",
            "💳 Savings and reinvestment strategies",
            "🏦 Accessing microloans or community funds"
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
            text = "📝 Activity: Create a Simple Budget",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Text(
            text = "List your expected income and expenses for one month. Separate them into fixed and variable costs. Use this to identify areas to save or invest.",
            fontSize = 16.sp,
            color = Color.White.copy(alpha = 0.95f),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun FinancialVideoPlayer(videoUrl: String) {
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
