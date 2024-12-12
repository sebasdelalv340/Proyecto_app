package com.example.proyecto_app.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto_app.ui.theme.Orange

@Composable
fun HeaderLogin(){
    Box(modifier = Modifier.fillMaxWidth()
        .height(200.dp)
        .background(color = Orange),
        contentAlignment = Alignment.Center
    ){
        Text(
            text="Griza estudio",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
    }
}