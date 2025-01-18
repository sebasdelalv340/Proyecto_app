package com.example.proyecto_app.screen.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto_app.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderMenu(navController: NavController, texto: String) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = texto,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
            }
        },
        navigationIcon = {
            IconoBack(navController)
        },
        actions = {
            IconoBurguer(navController)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Orange,
            titleContentColor = Color.Black,
            navigationIconContentColor = Color.Black,
            actionIconContentColor = Color.Black
        )
    )
}

@Composable
fun IconoBack(navController: NavController) {
    IconButton(
        onClick = { navController.popBackStack() },
        modifier = Modifier.padding(16.dp)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "atrás",
            Modifier.size(30.dp)
        )
    }
}


@Composable
fun IconoBurguer(navController: NavController) {
    IconButton(
        onClick = {},
        modifier = Modifier.padding(16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Menú",
            Modifier.size(30.dp)
        )
    }
}