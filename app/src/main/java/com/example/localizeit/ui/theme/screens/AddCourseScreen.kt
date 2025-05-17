package com.example.localizeit.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.localizeit.data.Course
import com.example.localizeit.models.CourseViewModel
import com.example.localizeit.navigation.ROUTE_DASHBOARD
//import com.localizeit.app.model.Course
//import com.localizeit.app.viewmodel.CourseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Screen for adding a new course to the LocalizeIt app
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCourseScreen(
    navController: NavController,
    viewModel: CourseViewModel = viewModel(),
    //onNavigateBack: (NavController) -> Unit
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current
   // val isLoading by viewModel.isLoading.observeAsState(false)

    // State variables for form fields
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var language by remember { mutableStateOf("") }
    var duration by remember { mutableStateOf("") }
    var difficultyLevel by remember { mutableStateOf("Beginner") }
    var instructorName by remember { mutableStateOf("") }
    var isOfflineAvailable by remember { mutableStateOf(true) }

    // State for form validation and messages
    var showSuccessMessage by remember { mutableStateOf(false) }
    var showValidationError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    val formGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF0D47A1),
            Color(0xFF1976D2),
            Color(0xFF42A5F5)
        )
    )

    Box(modifier = Modifier.fillMaxSize()) {
        // Background gradient
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFE3F2FD),
                            Color(0xFFBBDEFB),
                            Color(0xFF90CAF9)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Top App Bar
            TopAppBar(
                title = {
                    Text(
                        "Add New Course",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {navController.navigate(ROUTE_DASHBOARD)}) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Go back"
                        )
                    }
                }
//                colors =  Color(0xFF0D47A1) // Blue background
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Form Content
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.85f)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    // Title Field
                    OutlinedTextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text("Course Title") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Edit,
                                contentDescription = "Course Title",
                                tint = Color(0xFF1976D2)
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF1976D2),
                            unfocusedBorderColor = Color(0xFF90CAF9),
                            focusedLabelColor = Color(0xFF1976D2),
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Description Field
                    OutlinedTextField(
                        value = description,
                        onValueChange = { description = it },
                        label = { Text("Description") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.MoreVert,
                                contentDescription = "Description",
                                tint = Color(0xFF1976D2)
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        minLines = 3,
                        maxLines = 5,
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF1976D2),
                            unfocusedBorderColor = Color(0xFF90CAF9),
                            focusedLabelColor = Color(0xFF1976D2),
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Category Field
                    OutlinedTextField(
                        value = category,
                        onValueChange = { category = it },
                        label = { Text("Category") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Info,
                                contentDescription = "Category",
                                tint = Color(0xFF1976D2)
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF1976D2),
                            unfocusedBorderColor = Color(0xFF90CAF9),
                            focusedLabelColor = Color(0xFF1976D2),
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Language Field
                    OutlinedTextField(
                        value = language,
                        onValueChange = { language = it },
                        label = { Text("Local Language") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Email,
                                contentDescription = "Language",
                                tint = Color(0xFF1976D2)
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF1976D2),
                            unfocusedBorderColor = Color(0xFF90CAF9),
                            focusedLabelColor = Color(0xFF1976D2),
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Duration Field
                    OutlinedTextField(
                        value = duration,
                        onValueChange = {
                            // Only allow numbers
                            if (it.isEmpty() || it.all { char -> char.isDigit() }) {
                                duration = it
                            }
                        },
                        label = { Text("Duration (minutes)") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Notifications,
                                contentDescription = "Duration",
                                tint = Color(0xFF1976D2)
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF1976D2),
                            unfocusedBorderColor = Color(0xFF90CAF9),
                            focusedLabelColor = Color(0xFF1976D2),
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Difficulty Level Selector
                    Text(
                        "Difficulty Level",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF1976D2)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        difficultyChip(
                            text = "Beginner",
                            isSelected = difficultyLevel == "Beginner",
                            onSelected = { difficultyLevel = "Beginner" },
                            modifier = Modifier.weight(1f)
                        )

                        difficultyChip(
                            text = "Intermediate",
                            isSelected = difficultyLevel == "Intermediate",
                            onSelected = { difficultyLevel = "Intermediate" },
                            modifier = Modifier.weight(1f)
                        )

                        difficultyChip(
                            text = "Advanced",
                            isSelected = difficultyLevel == "Advanced",
                            onSelected = { difficultyLevel = "Advanced" },
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Instructor Name Field
                    OutlinedTextField(
                        value = instructorName,
                        onValueChange = { instructorName = it },
                        label = { Text("Instructor Name") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Person,
                                contentDescription = "Instructor",
                                tint = Color(0xFF1976D2)
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = { focusManager.clearFocus() }
                        ),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF1976D2),
                            unfocusedBorderColor = Color(0xFF90CAF9),
                            focusedLabelColor = Color(0xFF1976D2),
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Offline Availability Switch
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.AccountCircle,
                            contentDescription = "Offline Available",
                            tint = Color(0xFF1976D2),
                            modifier = Modifier.size(24.dp)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            "Available Offline",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.weight(1f)
                        )

                        Switch(
                            checked = isOfflineAvailable,
                            onCheckedChange = { isOfflineAvailable = it },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                checkedTrackColor = Color(0xFF1976D2),
                                uncheckedThumbColor = Color.White,
                                uncheckedTrackColor = Color.Gray.copy(alpha = 0.5f)
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Save Button
                    Button(
                        onClick = {
                            // Form validation
                            if (title.isBlank() || description.isBlank() || category.isBlank() ||
                                language.isBlank() || duration.isBlank() || instructorName.isBlank()) {
                                showValidationError = true
                                errorMessage = "All fields are required"
                                return@Button
                            }

                            val durationInt = duration.toIntOrNull() ?: 0
                            if (durationInt <= 0) {
                                showValidationError = true
                                errorMessage = "Duration must be a positive number"
                                return@Button
                            }

                            // Create a new course object
                            val newCourse = Course(
                                title = title,
                                description = description,
                                category = category,
                                language = language,
                                duration = durationInt,
                                difficultyLevel = difficultyLevel,
                                instructorName = instructorName,
                                isOfflineAvailable = isOfflineAvailable,
                                timestamp = System.currentTimeMillis()
                            )

                            // Add course to Firebase
                            viewModel.addCourse(
                                newCourse,
                                onSuccess = {
                                    // Show success message and reset form
                                    showSuccessMessage = true
                                    title = ""
                                    description = ""
                                    category = ""
                                    language = ""
                                    duration = ""
                                    difficultyLevel = "Beginner"
                                    instructorName = ""
                                    isOfflineAvailable = true

                                    // Hide success message after delay
                                    scope.launch {
                                        delay(2000)
                                        showSuccessMessage = false
                                    }
                                },
                                onFailure = { error ->
                                    showValidationError = true
                                    errorMessage = error
                                }
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(28.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF1976D2)
                        )
                    ) {

                        if (isOfflineAvailable) {
                            CircularProgressIndicator(
                                color = Color.White,
                                modifier = Modifier.size(24.dp),
                                strokeWidth = 2.dp
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Save",
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Save Course")
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Show validation error message if validation fails
                    AnimatedVisibility(
                        visible = showValidationError,
                        enter = fadeIn(animationSpec = tween(300)),
                        exit = fadeOut(animationSpec = tween(300))
                    ) {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(8.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFFFF3F3)
                            )
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.Warning,
                                    contentDescription = "Error",
                                    tint = Color(0xFFD32F2F),
                                    modifier = Modifier.size(24.dp)
                                )

                                Spacer(modifier = Modifier.width(16.dp))

                                Text(
                                    text = errorMessage,
                                    color = Color(0xFFD32F2F),
                                    style = MaterialTheme.typography.bodyMedium
                                )

                                Spacer(modifier = Modifier.weight(1f))

                                IconButton(
                                    onClick = { showValidationError = false },
                                    modifier = Modifier.size(24.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Outlined.Close,
                                        contentDescription = "Dismiss",
                                        tint = Color(0xFFD32F2F)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        // Success Message Overlay
        AnimatedVisibility(
            visible = showSuccessMessage,
            enter = fadeIn(animationSpec = tween(300)),
            exit = fadeOut(animationSpec = tween(300)),
            modifier = Modifier.align(Alignment.Center)
        ) {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF4CAF50)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                Row(
                    modifier = Modifier.padding(24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color.White, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Success",
                            tint = Color(0xFF4CAF50),
                            modifier = Modifier.size(32.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        "Course Added Successfully!",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun difficultyChip(
    text: String,
    isSelected: Boolean,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .clip(RoundedCornerShape(50.dp))
            .border(
                width = 1.dp,
                color = if (isSelected) Color(0xFF1976D2) else Color(0xFFBBDEFB),
                shape = RoundedCornerShape(50.dp)
            ),
        color = if (isSelected) Color(0xFFE3F2FD) else Color.White,
        onClick = onSelected
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = if (isSelected) Color(0xFF1976D2) else Color.Gray,
                fontSize = 14.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
            )
        }
    }
}