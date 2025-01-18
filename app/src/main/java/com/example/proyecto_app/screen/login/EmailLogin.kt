package com.example.proyecto_app.screen.login

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

@Composable
fun EmailLogin(
    textUser: String,
    isError: Boolean,
    focusRequester: FocusRequester,
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier
            .width(310.dp)
            .focusRequester(focusRequester)
            .testTag("loginEmail"),
        value = textUser,
        onValueChange = onValueChanged,
        label = { Text("Email") },
        singleLine = true
    )
    if (isError) {
        Text(
            text = "El campo email no puede estar vacío",
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(top = 4.dp).testTag("errorLoginEmail")
        )
    }
}