package com.example.localizeit.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.localizeit.data.Course
//import com.example.localizeit.models.Course
import com.example.localizeit.models.CourseViewModel

@Composable
fun ViewCourseScreen(
    navController: NavController,
    viewModel: CourseViewModel = viewModel(),
   // onBack: () -> Unit
) {


    val courses by viewModel.courses.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()
    var courseToDelete by remember { mutableStateOf<Course?>(null) }


    LaunchedEffect(Unit) {
        viewModel.loadCourses()
    }
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text("Available Courses") },
//                navigationIcon = {
//                    IconButton(onClick = onBack) {
//                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
//                    }
//                }
//            )
//        }
//    ) { padding ->
        Box(modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()) {

            when {
                isLoading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                error != null -> {
                    Text(
                        text = error ?: "Unknown error",
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                courses.isEmpty() -> {
                    Text(
                        text = "No courses available.",
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                else -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(courses) { course ->
                            CourseItem(
                                course = course,
                                onDelete = { courseToDelete = course } // ✅ This opens the dialog
                            )
                        }

                    }
                }
            }
            courseToDelete?.let { course ->
                AlertDialog(
                    onDismissRequest = { courseToDelete = null },
                    title = { Text("Delete Course") },
                    text = { Text("Are you sure you want to delete \"${course.title}\"?") },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                viewModel.deleteCourse(course)
                                courseToDelete = null
                            }
                        ) {
                            Text("Delete", color = MaterialTheme.colorScheme.error)
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { courseToDelete = null }) {
                            Text("Cancel")
                        }
                    }
                )
            }

        }

    }


@Composable

fun CourseItem(course: Course, onDelete: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = course.title, style = MaterialTheme.typography.titleLarge)
                Text(text = "ID: ${course.id}", style = MaterialTheme.typography.bodyMedium)
            }

            IconButton(onClick = onDelete) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Course",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ViewCourseScreenPreview(){
    ViewCourseScreen(navController = rememberNavController())

}
