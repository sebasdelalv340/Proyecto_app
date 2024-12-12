package com.example.proyecto_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.proyecto_app.navigation.AppNavigation
import com.example.proyecto_app.ui.theme.Proyecto_appTheme
import com.example.proyecto_app.viewModel.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val loginViewModel = LoginViewModel()
            Proyecto_appTheme {
                AppNavigation(loginViewModel)
            }
        }
    }
}


