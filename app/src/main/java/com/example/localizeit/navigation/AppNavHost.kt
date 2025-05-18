package com.example.localizeit.navigation





//import LocalizeItDashboard
import WelcomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coursesapp.ui.DashboardScreen
import com.example.localizeit.SettingsScreen
//import com.example.localizeit.ui.screens.ViewCourseActivity
import com.example.localizeit.ui.screens.AddCourseScreen
import com.example.localizeit.ui.screens.ProfileScreen
import com.example.localizeit.ui.screens.ViewCourseScreen
//import com.example.localizeit.ui.screens.ViewCourseActivity
import com.example.localizeit.ui.theme.screens.AgricultureScreen
import com.example.localizeit.ui.theme.screens.BusinessScreen
//import com.example.localizeit.ui.theme.screens.EditCourseScreen
import com.example.localizeit.ui.theme.screens.HealthcareScreen
import com.example.localizeit.ui.theme.screens.LanguageScreen
import com.example.localizeit.ui.theme.screens.LocalServicesScreen
import com.example.localizeit.ui.theme.screens.TechnologyScreen
//import com.example.localizeit.ui.theme.screens.SettingsScreen
//import com.example.localizeit.ui.theme.screens.dashboard.LocalizeItDashboard
import com.example.localizeit.ui.theme.screens.login.LoginScreen
import com.example.localizeit.ui.theme.screens.register.RegisterScreen


@Composable
fun LocalizeItApp() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = "register") {
        composable(ROUTE_WELCOME) { WelcomeScreen (navController )}
        //   composable("onboarding") { OnboardingScreen{(navController) }}
        composable(ROUTE_LOGIN) { LoginScreen(navController) }
        composable(ROUTE_REGISTER) { RegisterScreen(navController) }
        composable(ROUTE_DASHBOARD) { DashboardScreen(navController) }
//        composable("${ROUTE_EDIT_COURSE}/{courseId}") { backStackEntry ->
//
//        val courseId = backStackEntry.arguments?.getString("courseId")
//            EditCourseScreen(courseId = courseId, navController = navController)
//        }

        composable(ROUTE_PROFILE) { ProfileScreen(navController) }
        composable(ROUTE_SETTINGS) { SettingsScreen(navController) }
       composable(ROUTE_LANGUAGE) { LanguageScreen(navController) }
        composable(ROUTE_BUSINESS) { BusinessScreen(navController) }
        composable(ROUTE_TECHNOLOGY) { TechnologyScreen(navController) }
        composable(ROUTE_LOCAL_SERVICES) { LocalServicesScreen(navController) }
        composable(ROUTE_HEALTHCARE) { HealthcareScreen(navController) }




         composable(ROUTE_AGRICULTURE) { AgricultureScreen(navController) }
          composable(ROUTE_ADD_COURSE) { AddCourseScreen(navController) }

//        composable(ROUTE_SERVICE_DIRECTORY) { ServicesDirectoryScreen(navController) }
       composable(ROUTE_VIEW_COURSE) { ViewCourseScreen (navController) }
    }
}
