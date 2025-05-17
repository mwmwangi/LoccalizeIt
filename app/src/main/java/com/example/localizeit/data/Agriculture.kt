package com.example.localizeit.data

// Data classes
data class AgricultureCourse(
    val id: String,
    val title: String,
    val description: String,
    val thumbnailResId: Int,
    val modules: List<CourseModule>,
    val totalDuration: String,
    val level: String,
    val language: String
)

data class CourseModule(
    val id: String,
    val title: String,
    val description: String,
    val lessons: List<Lesson>,
    val durationMinutes: Int
)

data class Lesson(
    val id: String,
    val title: String,
    val description: String,
    val videoUrl: String?, // Null if no video
    val contentType: LessonContentType,
    val durationMinutes: Int,
    val thumbnailResId: Int
)

enum class LessonContentType {
    VIDEO, TEXT_AND_IMAGES, INTERACTIVE, QUIZ}


