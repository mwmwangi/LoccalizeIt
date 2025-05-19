package com.example.localizeit.ui.theme.screens

import android.net.Uri
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.localizeit.R
import com.example.localizeit.navigation.ROUTE_FINANCIAL_PLANNING
import com.example.localizeit.navigation.ROUTE_IDENTIFY_NEEDS
import com.example.localizeit.navigation.ROUTE_START_BUSINESS

@Composable
fun BusinessScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFFB2FEFA), Color(0xFF0ED2F7))
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
            text = "💼 Entrepreneurship & Business",
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.business_banner),
            contentDescription = "Business Banner",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Course Highlights",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
        Text(
            text = "Learn how to start and grow your business, understand local markets, manage finances, and promote your brand — all tailored to your region.",
            fontSize = 16.sp,
            color = Color.White.copy(alpha = 0.9f),
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "🎥 Featured Video Lessons",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        BusinessVideoPlayer(videoUrl = "https://www.example.com/business1.mp4")
        Spacer(modifier = Modifier.height(16.dp))
        BusinessVideoPlayer(videoUrl = "https://www.example.com/business2.mp4")

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "📚 Business Modules",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Each module is now paired with a route name
        val modules = listOf(
            "Starting a Business" to ROUTE_START_BUSINESS,
            "Identifying Local Needs" to ROUTE_IDENTIFY_NEEDS,
            "Financial Planning" to ROUTE_FINANCIAL_PLANNING,
            "Digital Marketing Basics" to "digital_marketing_screen",
            "Sourcing and Supply Chain" to "supply_chain_screen",
            "Customer Engagement" to "customer_engagement_screen",
            "Legal and Licensing Tips" to "legal_tips_screen"
        )

        modules.forEach { (title, route) ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { navController.navigate(route) },
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.9f)),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(16.dp),
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
fun BusinessVideoPlayer(videoUrl: String) {
    val context = LocalContext.current
    val exoPlayer = remember(videoUrl) {
        ExoPlayer.Builder(context).build().apply {
            val mediaItem = MediaItem.fromUri(Uri.parse(videoUrl))
            setMediaItem(mediaItem)
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

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun BusinessScreenPreview() {
    BusinessScreen(navController = rememberNavController())
}
