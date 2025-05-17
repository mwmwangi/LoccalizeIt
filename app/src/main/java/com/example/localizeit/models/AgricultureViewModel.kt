package com.example.localizeit.models

import androidx.lifecycle.ViewModel
import com.example.localizeit.R
import com.example.localizeit.data.AgricultureCourse
import com.example.localizeit.data.CourseModule
import com.example.localizeit.data.Lesson
import com.example.localizeit.data.LessonContentType

//import com.example.localizeit.ui.theme.screens.AgricultureCourse
//import com.example.localizeit.ui.theme.screens.CourseModule
//import com.example.localizeit.ui.theme.screens.Lesson
//import com.example.localizeit.ui.theme.screens.LessonContentType

// ViewModel
class AgricultureViewModel : ViewModel() {


    // Use placeholder resource IDs - you'll need to add these to your project
    val dummyThumbnailResId = R.drawable.agriculture// Add this resource
    val dummyLessonThumbnailResId = R.drawable.lesson_thumbnail // Add this resource

    // Mock data - In a real app, this would come from your backend/API
    val agricultureCourse = AgricultureCourse(
        id = "agr101",
        title = "Sustainable Farming Techniques",
        description = "Learn sustainable and productive farming methods suitable for your local climate and soil conditions. This comprehensive course covers soil management, crop selection, pest control, water conservation, and more.",
        thumbnailResId = dummyThumbnailResId,
        totalDuration = "15 hours",
        level = "Beginner",
        language = "English",
        modules = listOf(
            CourseModule(
                id = "mod1",
                title = "Understanding Your Soil",
                description = "Learn about soil types, testing, and preparation techniques for optimal crop growth.",
                durationMinutes = 120,
                lessons = listOf(
                    Lesson(
                        id = "les1",
                        title = "Soil Composition and Testing",
                        description = "Understand the basic components of soil and how to test soil quality using simple tools.",
                        videoUrl = "https://example.com/videos/soil-testing.mp4",
                        contentType = LessonContentType.VIDEO,
                        durationMinutes = 25,
                        thumbnailResId = dummyLessonThumbnailResId
                    ),
                    Lesson(
                        id = "les2",
                        title = "Improving Soil Fertility",
                        description = "Natural methods to enhance soil quality including composting and crop rotation.",
                        videoUrl = "https://example.com/videos/soil-fertility.mp4",
                        contentType = LessonContentType.VIDEO,
                        durationMinutes = 30,
                        thumbnailResId = dummyLessonThumbnailResId
                    ),
                    Lesson(
                        id = "les3",
                        title = "pH Balancing for Different Crops",
                        description = "How to measure and adjust soil pH based on what you plan to grow.",
                        videoUrl = "https://example.com/videos/ph-balancing.mp4",
                        contentType = LessonContentType.VIDEO,
                        durationMinutes = 20,
                        thumbnailResId = dummyLessonThumbnailResId
                    )
                )
            ),
            CourseModule(
                id = "mod2",
                title = "Seed Selection & Planting",
                description = "Choose the right seeds for your climate and learn proper planting techniques.",
                durationMinutes = 180,
                lessons = listOf(
                    Lesson(
                        id = "les4",
                        title = "Seed Selection for Local Climate",
                        description = "How to choose seeds that will thrive in your specific climate and growing conditions.",
                        videoUrl = "https://example.com/videos/seed-selection.mp4",
                        contentType = LessonContentType.VIDEO,
                        durationMinutes = 35,
                        thumbnailResId = dummyLessonThumbnailResId
                    ),
                    Lesson(
                        id = "les5",
                        title = "Seed Starting Techniques",
                        description = "Methods for starting seeds indoors and transplanting seedlings.",
                        videoUrl = "https://example.com/videos/seed-starting.mp4",
                        contentType = LessonContentType.TEXT_AND_IMAGES,
                        durationMinutes = 25,
                        thumbnailResId = dummyLessonThumbnailResId
                    ),
                    Lesson(
                        id = "les6",
                        title = "Direct Sowing Methods",
                        description = "When and how to plant seeds directly in your garden or field.",
                        videoUrl = "https://example.com/videos/direct-sowing.mp4",
                        contentType = LessonContentType.VIDEO,
                        durationMinutes = 30,
                        thumbnailResId = dummyLessonThumbnailResId
                    )
                )
            ),
            CourseModule(
                id = "mod3",
                title = "Water Management",
                description = "Efficient irrigation techniques and water conservation strategies.",
                durationMinutes = 150,
                lessons = listOf(
                    Lesson(
                        id = "les7",
                        title = "Irrigation Systems for Small Farms",
                        description = "Simple, cost-effective irrigation systems you can implement.",
                        videoUrl = "https://example.com/videos/irrigation-systems.mp4",
                        contentType = LessonContentType.VIDEO,
                        durationMinutes = 40,
                        thumbnailResId = dummyLessonThumbnailResId
                    ),
                    Lesson(
                        id = "les8",
                        title = "Rainwater Harvesting",
                        description = "Techniques to capture and store rainwater for agricultural use.",
                        videoUrl = "https://example.com/videos/rainwater-harvesting.mp4",
                        contentType = LessonContentType.VIDEO,
                        durationMinutes = 35,
                        thumbnailResId = dummyLessonThumbnailResId
                    )
                )
            ),
            CourseModule(
                id = "mod4",
                title = "Natural Pest Management",
                description = "Control pests and diseases without harmful chemicals.",
                durationMinutes = 190,
                lessons = listOf(
                    Lesson(
                        id = "les9",
                        title = "Identifying Common Pests",
                        description = "Learn to recognize common pests and the damage they cause.",
                        videoUrl = "https://example.com/videos/pest-identification.mp4",
                        contentType = LessonContentType.VIDEO,
                        durationMinutes = 30,
                        thumbnailResId = dummyLessonThumbnailResId
                    ),
                    Lesson(
                        id = "les10",
                        title = "Natural Pesticides",
                        description = "How to make and apply effective natural pesticides.",
                        videoUrl = "https://example.com/videos/natural-pesticides.mp4",
                        contentType = LessonContentType.VIDEO,
                        durationMinutes = 45,
                        thumbnailResId = dummyLessonThumbnailResId
                    ),
                    Lesson(
                        id = "les11",
                        title = "Companion Planting",
                        description = "Strategic plant combinations that naturally deter pests.",
                        videoUrl = "https://example.com/videos/companion-planting.mp4",
                        contentType = LessonContentType.VIDEO,
                        durationMinutes = 35,
                        thumbnailResId = dummyLessonThumbnailResId
                    )
                )
            ),
            CourseModule(
                id = "mod5",
                title = "Harvesting & Post-Harvest Handling",
                description = "Best practices for harvesting, storing, and preserving your crops.",
                durationMinutes = 160,
                lessons = listOf(
                    Lesson(
                        id = "les12",
                        title = "When and How to Harvest",
                        description = "Signs of crop readiness and proper harvesting techniques.",
                        videoUrl = "https://example.com/videos/harvesting.mp4",
                        contentType = LessonContentType.VIDEO,
                        durationMinutes = 40,
                        thumbnailResId = dummyLessonThumbnailResId
                    ),
                    Lesson(
                        id = "les13",
                        title = "Storage Solutions",
                        description = "Low-cost methods for storing harvested crops to extend shelf life.",
                        videoUrl = "https://example.com/videos/storage-solutions.mp4",
                        contentType = LessonContentType.VIDEO,
                        durationMinutes = 35,
                        thumbnailResId = dummyLessonThumbnailResId
                    ),
                    Lesson(
                        id = "les14",
                        title = "Basic Food Preservation",
                        description = "Methods for preserving surplus harvest for later use or sale.",
                        videoUrl = "https://example.com/videos/food-preservation.mp4",
                        contentType = LessonContentType.VIDEO,
                        durationMinutes = 50,
                        thumbnailResId = dummyLessonThumbnailResId
                    )
                )
            )
        )
    )
}
