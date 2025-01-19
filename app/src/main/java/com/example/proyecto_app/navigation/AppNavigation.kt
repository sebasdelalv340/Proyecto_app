package com.example.proyecto_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.proyecto_app.screen.login.LoginScreen
import com.example.proyecto_app.screen.menu.MenuScreen
import com.example.proyecto_app.screen.portada.PortadaScreen
import com.example.proyecto_app.screen.registro.RegistroScreen
import com.example.proyecto_app.viewModel.LoginViewModel

@Composable
fun AppNavigation(loginViewModel: LoginViewModel) {
    val navControlador = rememberNavController()
    NavHost(navController = navControlador, startDestination = "portada"){
        composable("portada"){
            PortadaScreen(navControlador)
        }
        composable("login")
        {
            LoginScreen(navControlador,loginViewModel)
        }
        composable("registro"){
            RegistroScreen(navControlador)
        }
        composable("menu" + "/{text}",
            arguments = listOf(navArgument(name = "text") {
                type = NavType.StringType
            })
        ){
            MenuScreen(navControlador, it.arguments?.getString("text").toString())
        }
    }
}