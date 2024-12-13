package com.example.proyecto_app.screen.menu

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto_app.ui.theme.Orange

@Composable
fun FooterMenu(navController: NavController){
    NavigationBar(containerColor = Orange) {
        NavigationBarItem(
            selected = true,
            onClick = {navController.navigate("Login")},
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Orange,
                selectedIconColor = Color.Black,
                selectedTextColor = Color.Black
            ),
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "home",
                    modifier = Modifier.size(30.dp)
                )
            },
            label = {
                Text(
                    text="Home",
                    fontSize = 15.sp
                    )
            }
        )
    }
}