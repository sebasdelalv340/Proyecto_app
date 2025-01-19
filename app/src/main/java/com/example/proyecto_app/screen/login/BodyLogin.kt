package com.example.proyecto_app.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto_app.util.Espacio
import com.example.proyecto_app.viewModel.LoginViewModel

@Composable
fun BodyLogin(
    modifier: Modifier,
    loginViewModel: LoginViewModel,
    navController: NavController,
    textEmail: String,
    textPassword: String,
    isEmailError: Boolean,
    isPasswordError: Boolean,
    emailFocusRequester: FocusRequester,
    passwordFocusRequester: FocusRequester,
    showDialog: Boolean
    ) {

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text= "¡Bienvenido a tu club!",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Espacio(100.dp)
        EmailLogin(textEmail, isEmailError, emailFocusRequester)
        {
            loginViewModel.onValueChange(email = it, textPassword)
        }
        Espacio(20.dp)
        PasswordLogin(textPassword, isPasswordError, passwordFocusRequester)
        {
            loginViewModel.onValueChange(textEmail, password = it)
        }
        Espacio(20.dp)
        ButtonSesion {
            loginViewModel.onErrorChange(textEmail, textPassword)

            // Dar el foco al que está vacío.
            if (isEmailError) {
                emailFocusRequester.requestFocus()
            }
            if (isPasswordError) {
                passwordFocusRequester.requestFocus()
            }
            else {
                if (loginViewModel.comprobarCredenciales(textEmail, textPassword)) {
                    navController.navigate("menu" + "/$textEmail")
                    loginViewModel.onValueChange("", "")
                } else {
                    loginViewModel.changeShowDialog(true)
                }
            }
        }
        Espacio(20.dp)
        ButtonRegistrarse { loginViewModel.onErrorChange(textEmail, textPassword) }

        if (showDialog) {
            DialogLogin()
            {
                // Limpiar los campos y mover el foco al campo de usuario
                loginViewModel.onValueChange("", "")
                emailFocusRequester.requestFocus()
                loginViewModel.changeShowDialog(false)
            }
        }
    }
}