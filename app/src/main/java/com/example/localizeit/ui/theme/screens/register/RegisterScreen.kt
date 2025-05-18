package com.example.localizeit.ui.theme.screens.register



//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Visibility
//import androidx.compose.material.icons.filled.VisibilityOff

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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.text.TextStyle
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
//import androidx.lint.kotlin.metadata.Visibility
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.localizeit.models.AuthViewModel
import com.example.localizeit.R
//import com.example.localizeit.models.AuthViewModel
import com.example.localizeit.navigation.ROUTE_LOGIN

@Composable
fun RegisterScreen( navController: NavController){
    var  authViewmModel : AuthViewModel = viewModel()
    var firstname by remember { mutableStateOf(value = "") }
    var lastname by remember { mutableStateOf(value = "") }
    var email by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf(value = "") }
    var passwordVisible by remember { mutableStateOf(false) }
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
                text = "Register Here!!",
                fontSize = 40.sp,
                color = androidx.compose.ui.graphics.Color.Magenta,

                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center,
                modifier = Modifier
//
                    .padding(10.dp)
                    .fillMaxWidth()


            )
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier.wrapContentHeight()
                    .fillMaxWidth()
                    .height(120.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            OutlinedTextField(
                value = firstname,
                onValueChange = { newFirstName -> firstname = newFirstName },
                label = { Text(text = "Enter first name") },
                placeholder = { Text(text = "Please enter firstname") },
                textStyle = TextStyle(color = Color.White),
                modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(16.dp),
                leadingIcon = {Icon(imageVector = Icons.Default.Person, contentDescription = "person")}

            )
            OutlinedTextField(
                value = lastname,
                onValueChange = { newlastName -> lastname = newlastName },
                label = { Text(text = "Enter last name") },
                placeholder = { Text(text = "Please enter lastname") },
                textStyle = TextStyle(color = Color.White),

                modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(16.dp),
                leadingIcon = {Icon(imageVector = Icons.Default.Person, contentDescription = "person")}
            )
            OutlinedTextField(
                value = email,
                onValueChange = { newEmail -> email = newEmail },
                label = { Text(text = "Enter email") },
                placeholder = { Text(text = "Please enter email") },
                textStyle = TextStyle(color = Color.White),

                modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(16.dp),
                leadingIcon ={ Icon(imageVector = Icons.Default.Email, contentDescription = "email")}
            )
            var passwordVisible by remember { mutableStateOf(false) }

            OutlinedTextField(
                value = password,
                onValueChange = { newPassword -> password = newPassword },
                label = { Text(text = "Enter password") },
                placeholder = { Text(text = "Please enter password") },
                textStyle = TextStyle(color = Color.White),

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
                onClick = {authViewmModel.SignUp(firstname,lastname,email,password, navController,context )},
                modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally).fillMaxWidth().padding(10.dp),
                colors = ButtonDefaults.buttonColors(
                    Color.Magenta
                )
            ) {
                Text(text = "Register")

            }


            Text(
                text = buildAnnotatedString { append("If already registered, Login here ") },
                color =   Color.White,
                modifier = Modifier.wrapContentWidth().align(
                    Alignment.CenterHorizontally
                ).clickable {
                    navController.navigate(ROUTE_LOGIN)
//            val intent = Intent(context,AddProductActivity::class.java)
//            context.startActivity(intent)
                })


        }
    }
}
@Preview(showBackground = true, showSystemUi = true )
@Composable
fun RegisterScreenPreview(){
    RegisterScreen(rememberNavController())
}
