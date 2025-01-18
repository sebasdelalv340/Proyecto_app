package com.example.proyecto_app.screen.login

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonSesion(onClick:()-> Unit) {
    Button(
        modifier = Modifier.testTag("buttonSesion"),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black
        ),
        contentPadding = PaddingValues(horizontal = 100.dp, vertical = 15.dp)
    ) {
        Text(
            text = "Iniciar sesión",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}