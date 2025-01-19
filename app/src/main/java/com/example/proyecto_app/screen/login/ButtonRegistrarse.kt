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
import com.example.proyecto_app.ui.theme.Orange

@Composable
fun ButtonRegistrarse(onClick:()-> Unit) {
    Button(
        modifier = Modifier.testTag("botonRegistrar"),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Orange
        ),
        contentPadding = PaddingValues(horizontal = 100.dp, vertical = 15.dp)
    ) {
        Text(
            text = "Registrarme",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}