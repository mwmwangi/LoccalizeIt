// LocalizeIt Profile Screen using Jetpack Compose
// File: ProfileScreen.kt
package com.example.localizeit.ui.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.localizeit.navigation.ROUTE_LOGIN

@Composable
fun ProfileScreen(
    navController: NavController,
   // onBackClick: () -> Unit,
   // onLogout: () -> Unit,
) {
    var showEditProfileDialog by remember { mutableStateOf(false) }
    var showLogoutConfirmation by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121218))
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Top App Bar
            //TopAppBar(
               // onBackClick = onBackClick,
               // onSettingsClick = { /* Handle settings click */ }
          //  )

            // Profile Header Section
            ProfileHeader(
                onEditProfileClick = { showEditProfileDialog = true }
            )

            // Stats Section
            StatsSection()

            // Courses Section
            CoursesSection()

            // Logout Button
            LogoutButton(onClick = { showLogoutConfirmation = true })
        }
    }

    // Edit Profile Dialog
    if (showEditProfileDialog) {
        EditProfileDialog(
            onDismiss = { showEditProfileDialog = false },
            onSave = { name, bio ->
                // Handle save profile info
                showEditProfileDialog = false
            }
        )
    }

    // Logout Confirmation Dialog
    if (showLogoutConfirmation) {
        AlertDialog(
            onDismissRequest = { showLogoutConfirmation = false },
            title = { Text("Logout Confirmation") },
            text = { Text("Are you sure you want to logout from LocalizeIt?") },
            confirmButton = {
                Button(
                    onClick = {
                        showLogoutConfirmation = false
                      // onLogout(ROUTE_LOGIN)
                        navController.navigate(ROUTE_LOGIN)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9370DB))
                ) {
                    Text("Logout")
                }
            },
            dismissButton = {
                Button(
                    onClick = { showLogoutConfirmation = false },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
fun TopAppBar(
    onBackClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            modifier = Modifier
                .size(24.dp)
                .clickable { onBackClick() },
            tint = Color.White
        )

        Text(
            text = "Profile",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Icon(
            imageVector = Icons.Default.Settings,
            contentDescription = "Settings",
            modifier = Modifier
                .size(24.dp)
                .clickable { onSettingsClick() },
            tint = Color.White
        )
    }
}

@Composable
fun ProfileHeader(
    onEditProfileClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            // Profile picture
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF9370DB))
                    .border(2.dp, Color.White, CircleShape)
            ) {
                Text(
                    text = "MW",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            // Edit profile picture button
            FloatingActionButton(
                onClick = onEditProfileClick,
                modifier = Modifier
                    .size(36.dp)
                    .align(Alignment.BottomEnd),
                containerColor = Color(0xFF9370DB)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Edit Profile Picture",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
        }

        Text(
            text = "Mercy Mwangi",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(top = 8.dp)
        )

        Text(
            text = "michael.wilson@example.com",
            fontSize = 14.sp,
            color = Color.LightGray,
            modifier = Modifier.padding(top = 4.dp)
        )

        Text(
            text = "Learning local languages and exploring new cultures",
            fontSize = 14.sp,
            color = Color.LightGray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
        )

        Button(
            onClick = onEditProfileClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9370DB)),
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(0.8f)
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit",
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Edit Profile")
        }
    }
}

@Composable
fun StatsSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        StatItem(title = "3", subtitle = "Active Courses")
        StatItem(title = "5", subtitle = "Completed")
        StatItem(title = "127", subtitle = "Followers")
        StatItem(title = "89", subtitle = "Following")
    }

    Divider(
        color = Color(0xFF2A2A36),
        thickness = 1.dp,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}

@Composable
fun StatItem(title: String, subtitle: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = subtitle,
            fontSize = 12.sp,
            color = Color.LightGray
        )
    }
}

@Composable
fun CoursesSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Your Active Courses",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        CourseItem(
            iconTint = Color(0xFF4CAF50),
            iconBackgroundColor = Color(0xFF283428),
            title = "Agriculture",
            progress = 13.62f,
            growth = "+2.55%"
        )

        Spacer(modifier = Modifier.height(12.dp))

        CourseItem(
            iconTint = Color(0xFFFF9800),
            iconBackgroundColor = Color(0xFF3D3426),
            title = "Business",
            progress = 12.72f,
            growth = "+5.87%"
        )

        Spacer(modifier = Modifier.height(12.dp))

        CourseItem(
            iconTint = Color(0xFF4169E1),
            iconBackgroundColor = Color(0xFF262E3D),
            title = "Local Services",
            progress = 8.91f,
            growth = "+0.73%"
        )
    }
}

@Composable
fun CourseItem(
    iconTint: Color,
    iconBackgroundColor: Color,
    title: String,
    progress: Float,
    growth: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF2A2A36))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Course icon
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(iconBackgroundColor),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = when (title) {
                    "Agriculture" -> Icons.Default.Info
                    "Business" -> Icons.Default.ShoppingCart
                    else -> Icons.Default.LocationOn
                },
                contentDescription = title,
                tint = iconTint,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = progress.toString() + "%",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "Growth",
                    tint = Color(0xFF4CAF50),
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = growth,
                    fontSize = 14.sp,
                    color = Color(0xFF4CAF50)
                )
            }
        }

        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Favorite",
            tint = Color.White,
            modifier = Modifier
                .size(24.dp)
                .clickable { /* Handle favorite click */ }
        )
    }
}

@Composable
fun LogoutButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Red.copy(alpha = 0.7f)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ExitToApp,
            contentDescription = "Logout",
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text("Logout")
    }
}

@Composable
fun EditProfileDialog(
    onDismiss: () -> Unit,
    onSave: (name: String, bio: String) -> Unit
) {
    var name by remember { mutableStateOf("Michael Wilson") }
    var bio by remember { mutableStateOf("Learning local languages and exploring new cultures") }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFF2A2A36)
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Edit Profile",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                TextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Name") },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color(0xFF3A3A46),
                        focusedContainerColor = Color(0xFF3A3A46),
                        unfocusedLabelColor = Color.Gray,
                        focusedLabelColor = Color(0xFF9370DB),
                        cursorColor = Color(0xFF9370DB),
                        unfocusedTextColor = Color.White,
                        focusedTextColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                TextField(
                    value = bio,
                    onValueChange = { bio = it },
                    label = { Text("Bio") },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color(0xFF3A3A46),
                        focusedContainerColor = Color(0xFF3A3A46),
                        unfocusedLabelColor = Color.Gray,
                        focusedLabelColor = Color(0xFF9370DB),
                        cursorColor = Color(0xFF9370DB),
                        unfocusedTextColor = Color.White,
                        focusedTextColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        onClick = onDismiss
                    ) {
                        Text(
                            text = "Cancel",
                            color = Color.Gray
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = { onSave(name, bio) },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9370DB))
                    ) {
                        Text("Save")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    ProfileScreen(
       // onBackClick = {},
      // onLogout = {},
        navController  = rememberNavController()
    )
}