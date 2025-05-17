package com.example.localizeit.ui.theme.screens
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.PlayArrow
//import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.localizeit.data.AgricultureCourse
import com.example.localizeit.data.CourseModule
import com.example.localizeit.data.Lesson
import com.example.localizeit.data.LessonContentType
import com.example.localizeit.models.AgricultureViewModel
//import androidx.media3.common.MediaItem
//import androidx.media3.exoplayer.ExoPlayer
//import androidx.media3.ui.PlayerView
import kotlinx.coroutines.launch


@Composable
fun AgricultureScreen(navController: NavController) {
    val viewModel: AgricultureViewModel = viewModel()
    val course = viewModel.agricultureCourse

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1B5E20),  // Dark green
                        Color(0xFF2E7D32)   // Medium green
                    )
                )
            )
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            // Header
            item {
                CourseHeader(course)
            }

            // Course Info
            item {
                CourseInfoCard(course)
            }

//            // Modules
//            items(course.modules) { module ->
//                ModuleCard(module)
//            }
        }
    }
}

@Composable
fun CourseHeader(course: AgricultureCourse) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
    ) {
        // Course thumbnail/banner
        Image(
            painter = painterResource(id = course.thumbnailResId),
            contentDescription = "Course banner image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Gradient overlay
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0x801B5E20),  // Semi-transparent dark green
                            Color(0xCC1B5E20)   // More opaque dark green
                        )
                    )
                )
        )

        // Course title
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Text(
                text = course.title,
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Badge(
                    containerColor = Color(0xFFAED581),  // Light green
                    contentColor = Color(0xFF33691E)     // Dark green
                ) {
                    Text(
                        text = course.level,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelMedium
                    )
                }

                Badge(
                    containerColor = Color(0xFFAED581),  // Light green
                    contentColor = Color(0xFF33691E)     // Dark green
                ) {
                    Text(
                        text = course.totalDuration,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelMedium
                    )
                }

                Badge(
                    containerColor = Color(0xFFAED581),  // Light green
                    contentColor = Color(0xFF33691E)     // Dark green
                ) {
                    Text(
                        text = course.language,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

@Composable
fun CourseInfoCard(course: AgricultureCourse) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "About This Course",
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFF1B5E20)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = course.description,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {  },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF388E3C)  // Green
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Start Course")
                }

                Button(
                    onClick = { /* Download course */ },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color(0xFF388E3C)
                    ),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Color(0xFF388E3C))
                ) {
                    Text("Download Offline")
                }
            }
        }
    }
}

@Composable
fun ModuleCard(module: CourseModule) {
    var expanded by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF1F8E9)  // Very light green
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            // Module header (always visible)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        coroutineScope.launch {
                            expanded = !expanded
                        }
                    }
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = module.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color(0xFF1B5E20),
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "${module.lessons.size} lessons · ${module.durationMinutes} min",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.DarkGray
                    )
                }

                Icon(
                    imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.ArrowDropDown,
                    contentDescription = if (expanded) "Collapse" else "Expand",
                    tint = Color(0xFF1B5E20)
                )
            }

            // Module content (visible when expanded)
            if (expanded) {
                Divider(
                    color = Color(0xFFDCEDC8),
                    thickness = 1.dp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Text(
                    text = module.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
                )

                // Lessons list
                module.lessons.forEachIndexed { index, lesson ->
                    LessonItem(lesson, index + 1)

                    // Add divider except after the last item
                    if (index < module.lessons.size - 1) {
                        Divider(
                            color = Color(0xFFDCEDC8),
                            thickness = 1.dp,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }
                }

                Button(
                    onClick = { /* Start module */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF388E3C)  // Green
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Start Module")
                }
            }
        }
    }
}

@Composable
fun LessonItem(lesson: Lesson, lessonNumber: Int) {
    var showVideoPlayer by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Top
        ) {
            // Lesson number badge
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFF388E3C)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = lessonNumber.toString(),
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = lesson.title,
                    style = MaterialTheme.typography.titleSmall,
                    color = Color(0xFF33691E),
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = lesson.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.DarkGray,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Lesson type icon
                    Icon(
                        imageVector = when (lesson.contentType) {
                            LessonContentType.VIDEO -> Icons.Filled.PlayArrow
                            else -> Icons.Filled.PlayArrow // Use appropriate icons for other types
                        },
                        contentDescription = null,
                        tint = Color(0xFF689F38),
                        modifier = Modifier.size(16.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = "${lesson.durationMinutes} min",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )

                    if (lesson.videoUrl != null) {
                        Spacer(modifier = Modifier.width(12.dp))

                        TextButton(
                            onClick = { showVideoPlayer = !showVideoPlayer },
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp)
                        ) {
                            Text(
                                text = if (showVideoPlayer) "Hide Video" else "Watch Video",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(0xFF689F38)
                            )
                        }
                    }
                }
            }
        }

        // Video player (shown when clicked)
//        if (showVideoPlayer && lesson.videoUrl != null) {
//            Spacer(modifier = Modifier.height(12.dp))
//
//            VideoPlayer(
//                videoUrl = lesson.videoUrl,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//                    .clip(RoundedCornerShape(8.dp))

        }
    }


//@Composable
//fun VideoPlayer(videoUrl: String, modifier: Modifier = Modifier) {
//    val context = LocalContext.current
//
//    // Create ExoPlayer instance
//    val exoPlayer = remember {
//        ExoPlayer.Builder(context).build().apply {
//            setMediaItem(MediaItem.fromUri(videoUrl))
//            prepare()
//        }
//    }
//
//    // Release player when leaving the composition
//    DisposableEffect(key1 = Unit) {
//        onDispose {
//            exoPlayer.release()
//        }
//    }
//
//    Box(modifier = modifier) {
//        AndroidView(
//            factory = { ctx ->
//                PlayerView(ctx).apply {
//                    player = exoPlayer
//                    useController = true
//                }
//            },
//            modifier = Modifier.fillMaxSize()
//        )
//    }
//}
//
// This is just a preview composable - in a real app, you would call this from your NavHost
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun AgricultureScreenPreview() {
    MaterialTheme {
        AgricultureScreen(navController = rememberNavController())
    }
}