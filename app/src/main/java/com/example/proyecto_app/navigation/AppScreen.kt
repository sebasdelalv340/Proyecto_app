package com.example.proyecto_app.navigation

sealed class AppScreen(val route: String) {
    data object PortadaScreen: AppScreen("Portada")
    data object LoginScreen: AppScreen("Login")
    data object RegistroScreen: AppScreen("Registro")
    data object MenuScreen: AppScreen("Menu")
}