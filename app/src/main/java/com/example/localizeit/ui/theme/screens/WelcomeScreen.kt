import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.example.localizeit.R
import com.example.localizeit.navigation.ROUTE_DASHBOARD
import com.example.localizeit.navigation.ROUTE_REGISTER

@Composable
fun WelcomeScreen(navController: NavController) {
// Navigate after delay
    LaunchedEffect(Unit) {
        Handler(Looper.getMainLooper()).postDelayed({
            navController.navigate(ROUTE_REGISTER) {
                popUpTo("welcome") { inclusive = true }
            }
        }, 2000) // 2 second delay
    }


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212)),
        color = Color.Black
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "App Logo",
                    modifier = Modifier.size(100.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "LocalizeIt",
                    style = MaterialTheme.typography.h4.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Empowering Communities...",
                    style = MaterialTheme.typography.body1.copy(
                        color = Color.LightGray
                    )
                )
            }
        }
    }
}

//In your NavHost setup:
//
//NavHost(navController = navController, startDestination = "splash") {
//    composable("splash") { SplashScreen(navController) }
//    composable("register") { RegisterScreen(navController) }
//// other composables...
//}