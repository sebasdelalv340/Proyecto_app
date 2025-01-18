package com.example.proyecto_app.screen.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import com.example.proyecto_app.viewModel.LoginViewModel

@Composable
fun LoginScreen(navController: NavController, loginViewModel: LoginViewModel) {
    Login(navController, loginViewModel)
}

@Composable
fun Login(navController: NavController, loginViewModel: LoginViewModel) {
    val textEmail by loginViewModel.email.observeAsState("")
    val textPassword by loginViewModel.password.observeAsState("")

    val isEmailError by loginViewModel.isEmailError.observeAsState(false)
    val isPasswordError by loginViewModel.isPasswordError.observeAsState(false)

    // Para gestionar la AlertDialog
    val showDialog by loginViewModel.showDialog.observeAsState(false)

    val emailFocusRequester = remember { FocusRequester() }
    val passwordFocusRequester = remember { FocusRequester() }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding))
        {
            HeaderLogin()
            BodyLogin(Modifier.weight(1f),
                loginViewModel,
                navController,
                textEmail,
                textPassword,
                isEmailError,
                isPasswordError,
                emailFocusRequester,
                passwordFocusRequester,
                showDialog)
        }
    }
}

