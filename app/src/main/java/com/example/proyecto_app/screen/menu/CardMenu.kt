package com.example.proyecto_app.screen.menu

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.proyecto_app.ui.theme.Orange

@Composable
fun CardMenu(icono: ImageVector, descripcion: String, dp: Dp){
    Card(
        modifier = Modifier
            .size(50.dp, 50.dp)
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black,
            contentColor = Orange
        ),
        border = BorderStroke(2.dp, Color.Gray),
        shape = MaterialTheme.shapes.small
        ){
        IconButton(
            onClick = {}
        ) {
            Icon(
                imageVector = icono,
                contentDescription = descripcion,
                Modifier.size(dp)
            )
        }
    }
}