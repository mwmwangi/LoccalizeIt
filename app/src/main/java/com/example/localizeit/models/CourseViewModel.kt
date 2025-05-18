package com.example.localizeit.models
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.localizeit.data.Course
import com.google.firebase.database.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for handling Course related operations
 */
class CourseViewModel : ViewModel() {

    private val database = FirebaseDatabase.getInstance()
    private val coursesRef: DatabaseReference = database.getReference("courses")

    private val _courses = MutableStateFlow<List<Course>>(emptyList())
    val courses = _courses.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    // Load all courses from Firebase Realtime Database
    fun loadCourses() {
        _isLoading.value = true

        coursesRef.orderByChild("timestamp")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val courseList = mutableListOf<Course>()
                    for (child in snapshot.children) {
                        val course = child.getValue(Course::class.java)
                        if (course != null) {
                            courseList.add(course)
                        }
                    }
                    _courses.value = courseList.sortedByDescending { it.timestamp }
                    _isLoading.value = false
                }

                override fun onCancelled(error: DatabaseError) {
                    _error.value = "Failed to load courses: ${error.message}"
                    _isLoading.value = false
                }
            })
    }

    // Add a new course to Firebase
    fun addCourse(course: Course, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        _isLoading.value = true

        val newCourseRef = coursesRef.push()
        val newCourse = course.copy(id = newCourseRef.key ?: "")

        newCourseRef.setValue(newCourse)
            .addOnSuccessListener {
                _isLoading.value = false
                onSuccess()
                loadCourses() // Refresh the list
            }
            .addOnFailureListener { e ->
                _isLoading.value = false
                onFailure("Failed to add course: ${e.message}")
            }
    }


    fun deleteCourse(course: Course) {
        val databaseRef = FirebaseDatabase.getInstance().getReference("courses")
        databaseRef.child(course.id).removeValue()
            .addOnSuccessListener {
                loadCourses() // Refresh course list after deletion
            }
            .addOnFailureListener { e ->
                _error.value = e.message
            }
    }
    fun updateCourse(course: Course) {


        val courseId = course.id
        val updates = mapOf(
            "title" to course.title,
            "description" to course.description
        )

        FirebaseDatabase.getInstance()
            .getReference("courses")
            .child(courseId)
            .updateChildren(updates)
            .addOnSuccessListener {
                loadCourses() // reload updated data

            }
            .addOnFailureListener { exception ->

            }
    }


}