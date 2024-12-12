package com.example.proyecto_app.screen.login

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DialogLogin(onDismiss: () -> Unit){
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text ="Login Fallido")
        },
        text = {
            Text(text ="Usuario o contraseña incorrectos.")
        },
        confirmButton = {
            Button(
                onClick = onDismiss
            ) {
                Text(text = "Cerrar")
            }
        }
    )
}