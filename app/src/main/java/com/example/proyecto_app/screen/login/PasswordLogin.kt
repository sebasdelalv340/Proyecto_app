package com.example.proyecto_app.screen.login

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun PasswordLogin(
    textPassword: String,
    isError: Boolean,
    focusRequester: FocusRequester,
    onPasswordChange:(String)-> Unit) {

    var passwordVisibility by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier
            .width(310.dp)
            .focusRequester(focusRequester)
            .testTag("loginPassword"),
        value = textPassword,
        onValueChange = onPasswordChange,
        label = { Text("Contraseña") },
        singleLine = true,
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(
                    imageVector = if (passwordVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    contentDescription = if (passwordVisibility) "Ocultar contraseña" else "Mostrar contraseña"
                )
            }
        }
    )

    if (isError) {
        Text(
            text = "El campo contraseña no puede estar vacío",
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(top = 4.dp).testTag("errorLoginPassword")
        )
    }


}