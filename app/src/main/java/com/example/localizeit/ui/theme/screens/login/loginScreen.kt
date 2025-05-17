package com.example.localizeit.ui.theme.screens.login



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.localizeit.R
import com.example.localizeit.models.AuthViewModel
import com.example.localizeit.navigation.ROUTE_DASHBOARD
import com.example.localizeit.navigation.ROUTE_REGISTER


@Composable
fun LoginScreen(navController: NavController) {
    val  authViewModel: AuthViewModel = viewModel()
    var email by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf(value = "") }
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F0F0F))
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxHeight().fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Login Here!!",
                color = androidx.compose.ui.graphics.Color.Magenta,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier.wrapContentHeight()
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(10.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { newEmail -> email = newEmail },
                label = { Text(text = "Enter email") },
                placeholder = { Text(text = "Please enter email") },
                modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(16.dp)
            )
            var passwordVisible by remember { mutableStateOf(false) }
            OutlinedTextField(
                value = password,
                onValueChange = { newPassword -> password = newPassword },
                label = { Text(text = "Enter password") },
                placeholder = { Text(text = "Please enter password") },
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(16.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "lock"
                    )
                },
                trailingIcon = {
                    val image = if (passwordVisible)
                        R.drawable.ic_visibles
                    else
                        R.drawable.ic_invisible

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(id = image),
                            contentDescription = if (passwordVisible) "Hide password" else "Show password"
                        )
                    }
                },

                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
            )
            Button(
                onClick = {navController.navigate(ROUTE_DASHBOARD)/*authViewModel.login(email,password,navController,context)*/},
                modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    Color.Magenta
                )
            ) {
                Text(text = "Log In")
            }


            Text(
                text = buildAnnotatedString { append(" haven't registered yet?, Register here, ") },
                color = Color.White,
                modifier = Modifier.wrapContentWidth().align(
                    Alignment.CenterHorizontally
                ).clickable {
                    navController.navigate(ROUTE_REGISTER)
//            val intent = Intent(context,MainActivity::class.java)
//            context.startActivity(intent)
                })
//        Text(
//            text = "Forgot Password?",
//            color = Color.Blue,
//            modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally).clickable {
//                // Navigate to password reset screen
//                val intent = Intent(context,ForgotPassword::class.java)
//                context.startActivity(intent)
        }


    }

}
@Preview(showBackground = true, showSystemUi = true )
@Composable
fun LoginActivityPreview(){
    LoginScreen(rememberNavController())
}