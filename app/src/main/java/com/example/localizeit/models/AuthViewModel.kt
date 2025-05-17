package com.example.localizeit.models

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

import com.example.localizeit.navigation.ROUTE_LOGIN
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
//import com.google.firebase.database.core.Context
import kotlinx.coroutines.flow.MutableStateFlow
import  android.content.Context
import com.example.localizeit.data.UserModel

//import com.example.localizeit.navigation.ROUTE_DASHBOARD

//import com.example.localizeit.navigation.ROUTE_DASHBOARD


class AuthViewModel: ViewModel() {
    private val mAuth: FirebaseAuth= FirebaseAuth.getInstance()
    private val  _isloading = MutableStateFlow(false)
    private val  _errorMessage = MutableStateFlow<String?>(null)
    fun SignUp(
        firstname: String,
        lastname: String,
        email: String,
        password: String,
        navController: NavController,
        context: Context
    ) {
        if (firstname.isBlank() || lastname.isBlank() || email.isBlank() || password.isBlank()) {
            Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_LONG).show()
            return
        }

        _isloading.value = true

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                _isloading.value = false
                if (task.isSuccessful) {
                    val userId = mAuth.currentUser?.uid ?: ""
                    val userData = UserModel(
                        firstname = firstname,
                        lastname = lastname,
                        email = email,
                        password = password,
                        userid = userId
                    )
                    saveUserToDatabase(userId, userData, navController, context)
                    
                } else {
                    _errorMessage.value = task.exception?.message
                    Toast.makeText(context, "Registration failed", Toast.LENGTH_LONG).show()
                }
            }
    }

    fun saveUserToDatabase(
        userId: String,
        userData: UserModel,
        navController: NavController,
        context: Context
    ) {
        val regref = FirebaseDatabase.getInstance()
            .getReference("Users/$userId")

        regref.setValue(userData).addOnCompleteListener { regrefTask ->
            if (regrefTask.isSuccessful) {
                Toast.makeText(context, "User successfully registered", Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_LOGIN)
            } else {
                _errorMessage.value = regrefTask.exception?.message
                Toast.makeText(context, "Database error", Toast.LENGTH_LONG).show()
            }
        }
    }
    fun login(email: String,
              password: String,
              navController: NavController,
              context: Context){
        if (email.isBlank()||password.isBlank()){
            Toast.makeText(context,"Email and password required",Toast.LENGTH_LONG).show()
            return
        }
        _isloading.value = true
        mAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener{
                    task ->
                _isloading.value = false
//                if (task.isSuccessful){
//                    Toast.makeText(context,"user successfully logged",Toast.LENGTH_LONG).show()
//                    navController.navigate(ROUTE_DASHBOARD)
//                }
            }

    }


}

