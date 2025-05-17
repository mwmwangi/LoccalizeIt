package com.example.coursesapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.localizeit.navigation.ROUTE_ADD_COURSE
import com.example.localizeit.navigation.ROUTE_AGRICULTURE
import com.example.localizeit.navigation.ROUTE_BUSINESS
import com.example.localizeit.navigation.ROUTE_HEALTHCARE
import com.example.localizeit.navigation.ROUTE_LANGUAGE
import com.example.localizeit.navigation.ROUTE_LOCAL_SERVICES
import com.example.localizeit.navigation.ROUTE_PROFILE
import com.example.localizeit.navigation.ROUTE_SETTINGS
import com.example.localizeit.navigation.ROUTE_TECHNOLOGY
import com.example.localizeit.navigation.ROUTE_VIEW_COURSE

@Composable
fun DashboardScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1C1B1F))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            TopBar(navController)

            Spacer(modifier = Modifier.height(24.dp))

            TopCoursesSection(navController)

            Spacer(modifier = Modifier.height(24.dp))

            ActiveCoursesSection(navController)
        }
    }
}

@Composable
fun TopBar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "LocalizeIT",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 8.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color(0xFF7E57C2))
                .clickable { navController.navigate(ROUTE_ADD_COURSE)},
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add",
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color(0xFF7E57C2))
                .clickable { navController.navigate(ROUTE_VIEW_COURSE) },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.List,
                contentDescription = "Email",
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color(0xFF7E57C2))
                .clickable {navController.navigate(ROUTE_SETTINGS)},
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Settings",
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color(0xFF6B7280))
                .clickable { navController.navigate(ROUTE_PROFILE) },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "MW",
                color = Color.White,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun TopCoursesSection(navController: NavController) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Top Courses",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFB388FF))
                    .clickable { /* Handle All click */ }
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "All",
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CourseCard(
                title = "Agriculture",
                icon = Icons.Default.Info,
                iconBackground = Color(0xFF4CAF50),
                percentage = "13.62%",
                growth = "+2.55%",
                cardBackground = Color(0xFF2E5C41),
                modifier = Modifier.weight(1f),
                onClick = { navController.navigate(ROUTE_AGRICULTURE) }
            )

            Spacer(modifier = Modifier.width(16.dp))

            CourseCard(
                title = "Business",
                icon = Icons.Default.ShoppingCart,
                iconBackground = Color(0xFFFF9800),
                percentage = "12.72%",
                growth = "+5.87%",
                cardBackground = Color(0xFF5D4037),
                modifier = Modifier.weight(1f),
                onClick = { navController.navigate(ROUTE_BUSINESS) }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CourseCard(
                title = "Healthcare",
                icon = Icons.Default.Favorite,
                iconBackground = Color(0xFFE91E63),
                percentage = "",
                growth = "",
                cardBackground = Color(0xFF2A2B36),
                modifier = Modifier.weight(1f),
                onClick = { navController.navigate(ROUTE_HEALTHCARE) }
            )

            Spacer(modifier = Modifier.width(16.dp))

            CourseCard(
                title = "Technology",
                icon = Icons.Default.Person,
                iconBackground = Color(0xFF03A9F4),
                percentage = "",
                growth = "",
                cardBackground = Color(0xFF2A2B36),
                modifier = Modifier.weight(1f),
                onClick = { navController.navigate(ROUTE_TECHNOLOGY) }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CourseCard(
                title = "Language",
                icon = Icons.Default.Edit,
                iconBackground = Color(0xFF9C27B0),
                percentage = "",
                growth = "",
                cardBackground = Color(0xFF2A2B36),
                modifier = Modifier.weight(1f),
                onClick = { navController.navigate(ROUTE_LANGUAGE) }
            )

            Spacer(modifier = Modifier.width(16.dp))

            CourseCard(
                title = "Local Services",
                icon = Icons.Default.LocationOn,
                iconBackground = Color(0xFF3F51B5),
                percentage = "8.91%",
                growth = "0.73%",
                cardBackground = Color(0xFF2A2B36),
                modifier = Modifier.weight(1f),
                onClick = { navController.navigate(ROUTE_LOCAL_SERVICES) }
            )
        }
    }
}

@Composable
fun CourseCard(
    title: String,
    icon: ImageVector,
    iconBackground: Color,
    percentage: String,
    growth: String,
    cardBackground: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF2A2B36))
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(iconBackground),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = title,
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = title,
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    modifier = Modifier.weight(1f)
                )

                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More",
                    tint = Color.White
                )
            }

            if (percentage.isNotEmpty()) {
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = percentage,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = "Growth",
                        tint = Color(0xFF4CAF50),
                        modifier = Modifier.size(16.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = growth,
                        color = Color(0xFF4CAF50),
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(cardBackground)
            )
        }
    }
}

@Composable
fun ActiveCoursesSection(navController: NavController) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Your Active Courses",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        ActiveCourseCard(
            title = "Agriculture",
            lastUpdate = "45 minutes ago",
            progress = "31.5%",
            momentum = "-0.82%",
            time = "4.2 hrs",
            completionPercentage = "60.6%",
            rating = "4.5/5",
            onClick = { navController.navigate(ROUTE_AGRICULTURE) }
        )
    }
}

@Composable
fun ActiveCourseCard(
    title: String,
    lastUpdate: String,
    progress: String,
    momentum: String,
    time: String,
    completionPercentage: String,
    rating: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF2A2B36))
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF4CAF50)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = title,
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = title,
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    modifier = Modifier.weight(1f)
                )

                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Share",
                    tint = Color.White
                )

                Spacer(modifier = Modifier.width(16.dp))

                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Last update · $lastUpdate",
                color = Color.Gray,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = progress,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /* Continue Learning click */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB388FF)),
                    shape = RoundedCornerShape(24.dp),
                    contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Continue Learning",
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                OutlinedButton(
                    onClick = { /* Preview click */ },
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White
                    ),
                    border = ButtonDefaults.outlinedButtonBorder.copy(
                        brush = SolidColor(Color.Gray)
                    ),
                    shape = RoundedCornerShape(24.dp),
                    contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Preview",
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                StatsColumn(
                    title = "Momentum",
                    value = momentum,
                    subtitle = "Weekly dynamics",
                    valueColor = Color(0xFFFF5252)
                )

                StatsColumn(
                    title = "Time",
                    value = time,
                    subtitle = "Remaining"
                )

                StatsColumn(
                    title = "Progress",
                    value = completionPercentage,
                    subtitle = "To completion"
                )

                StatsColumn(
                    title = "Rating",
                    value = rating,
                    subtitle = "User reviews"
                )
            }
        }
    }
}

@Composable
fun StatsColumn(
    title: String,
    value: String,
    subtitle: String,
    valueColor: Color = Color.White
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = title,
            color = Color.Gray,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = value,
            color = valueColor,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = subtitle,
            color = Color.Gray,
            fontSize = 10.sp
        )
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardScreenPreview (){
    DashboardScreen(navController = rememberNavController())

}