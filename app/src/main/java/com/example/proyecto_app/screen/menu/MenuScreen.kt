package com.example.proyecto_app.screen.menu

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.navigation.NavController

@Composable
fun MenuScreen(navController: NavController, texto: String) {
    Menu(navController, texto)
}

@Composable
fun Menu(navController: NavController, texto: String){

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .testTag("menu"))
        {
            HeaderMenu(navController, texto)
            Box(modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
                contentAlignment = Alignment.Center) {
                OpcionesGridView(navController)
            }
            Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.BottomCenter){
                FooterMenu(navController)
            }
        }
    }
}