package com.example.localizeit.data

/**
 * Model class representing a course in the LocalizeIt app
 */
data class Course(
    val id: String = "", // Firebase document ID
    val title: String = "",
    val description: String = "",
    val category: String = "",
    val language: String = "", // Local language of the course
    val duration: Int = 0, // Duration in minutes
    val difficultyLevel: String = "", // Beginner, Intermediate, Advanced
    val imageUrl: String = "",
    val isOfflineAvailable: Boolean = true,
    val instructorName: String = "",
    val timestamp: Long = System.currentTimeMillis(),

) {
    // Empty constructor required for Firebase
    constructor() : this("", "", "", "", "", 0, "", "", true, "", 0L)

    // Function to convert Course to HashMap for Firebase
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "title" to title,
            "description" to description,
            "category" to category,
            "language" to language,
            "duration" to duration,
            "difficultyLevel" to difficultyLevel,
            "imageUrl" to imageUrl,
            "isOfflineAvailable" to isOfflineAvailable,
            "instructorName" to instructorName,
            "timestamp" to timestamp,

        )
    }
}