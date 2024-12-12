package com.example.proyecto_app.screen.portada

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto_app.ui.theme.Orange
import kotlinx.coroutines.delay

@Composable
fun PortadaScreen(navController: NavController) {
    Portada(navController)
}

@Composable
fun Portada(navController: NavController){
    // Navegación después de 1.5 segundos
    LaunchedEffect(Unit) {
        delay(1000)
        navController.navigate("login")
    }
    Box(modifier = Modifier.fillMaxSize()
        .background(color = Orange),
        contentAlignment = Alignment.Center
    ){
        Text(
            text="Griza estudio",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}