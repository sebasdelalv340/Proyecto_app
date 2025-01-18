package com.example.proyecto_app.componentesTest

import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.proyecto_app.screen.login.ButtonSesion
import com.example.proyecto_app.screen.login.EmailLogin
import com.example.proyecto_app.screen.login.PasswordLogin
import org.junit.Rule
import org.junit.Test

class ComponentesTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenTextIsAdded_loginEmailTest() {
        var valorCapturado = ""
        composeTestRule.setContent {
            EmailLogin(
                textUser = "",
                isError = false,
                focusRequester = FocusRequester(),
                onValueChanged = { newValue -> valorCapturado = newValue }
            )
        }
        composeTestRule.onNodeWithTag("loginEmail").assertExists()
        composeTestRule.onNodeWithTag("loginEmail").performTextInput("sebas@gmail.com")
        assert(valorCapturado == "sebas@gmail.com")
    }

    @Test
    fun whenTextIsAdded_loginPasswordTest() {
        var valorCapturado = ""
        composeTestRule.setContent {
            PasswordLogin(
                textPassword = "",
                isError = false,
                focusRequester = FocusRequester(),
                onPasswordChange = { newValue -> valorCapturado = newValue }
            )
        }
        composeTestRule.onNodeWithTag("loginPassword").assertExists()
        composeTestRule.onNodeWithTag("loginPassword").performTextInput("265489")
        assert(valorCapturado == "265489")
    }

    @Test
    fun whenIsError_emailTextError_loginEmailTest() {
        composeTestRule.setContent {
            EmailLogin(
                textUser = "",
                isError = true,
                focusRequester = FocusRequester(),
                onValueChanged = { }
            )
        }
        composeTestRule.onNodeWithTag("errorLoginEmail").assertExists()
        composeTestRule.onNodeWithTag("errorLoginEmail").assertIsDisplayed()

    }

    @Test
    fun whenIsError_passwordTextError_loginPasswordTest() {
        composeTestRule.setContent {
            PasswordLogin(
                textPassword = "",
                isError = true,
                focusRequester = FocusRequester(),
                onPasswordChange = { }
            )
        }
        composeTestRule.onNodeWithTag("errorLoginPassword").assertExists()
        composeTestRule.onNodeWithTag("errorLoginPassword").assertIsDisplayed()
    }

    @Test
    fun whenClicked_buttonSesionTest() {
        var isClicked = false
        composeTestRule.setContent {
            ButtonSesion(
                onClick = { isClicked = true }
            )
        }

        composeTestRule.onNodeWithTag("buttonSesion").assert(hasText("Iniciar sesión"))
        composeTestRule.onNodeWithTag("buttonSesion").performClick()
        assert(isClicked)
    }


    @Test
    fun buttonSesionComplexTest() {
        // Variables simuladas para el test
        var isEmailError = false
        var isPasswordError = false
        var emailFocused = false
        var passwordFocused = false
        var showErrorDialog = false
        var navigationTriggered = false
        var email = "test@example.com"
        var password = "password123"

        // ViewModel simulado
        class FakeViewModel {
            fun onErrorChange(email: String, password: String) {
                isEmailError = email.isEmpty()
                isPasswordError = password.isEmpty()
            }

            fun comprobarCredenciales(email: String, password: String): Boolean {
                return email == "correct@example.com" && password == "correctPassword"
            }

            fun changeShowDialog(show: Boolean) {
                showErrorDialog = show
            }

            fun onValueChange(newEmail: String, newPassword: String) {
                email = newEmail
                password = newPassword
            }
        }

        // Navegador simulado
        class FakeNavController {
            fun navigate(ruta : String) {
                navigationTriggered = true
            }
        }

        // Instanciamos nuestros simuladores
        val fakeLoginViewModel = FakeViewModel()
        val fakeNavController = FakeNavController()

        composeTestRule.setContent {
            ButtonSesion {
                fakeLoginViewModel.onErrorChange(email, password)

                if (isEmailError) {
                    emailFocused = true
                }
                if (isPasswordError) {
                    passwordFocused = true
                } else {
                    if (fakeLoginViewModel.comprobarCredenciales(email, password)) {
                        fakeNavController.navigate("Menu/$email")
                        fakeLoginViewModel.onValueChange("", "")
                    } else {
                        fakeLoginViewModel.changeShowDialog(true)
                    }
                }
            }
        }

        // Validación 1: Botón está visible y existe
        composeTestRule.onNodeWithTag("buttonSesion").assertExists()
        composeTestRule.onNodeWithTag("buttonSesion").assertIsDisplayed()

        // Validación 2: Probar flujo con errores en email
        email = ""
        password = "password123"
        composeTestRule.onNodeWithTag("buttonSesion").performClick()
        assert(isEmailError)
        assert(emailFocused)

        // Validación 3: Probar flujo con errores en password
        email = "test@example.com"
        password = ""
        composeTestRule.onNodeWithTag("buttonSesion").performClick()
        assert(isPasswordError)
        assert(passwordFocused)

        // Validación 4: Probar credenciales correctas
        email = "correct@example.com"
        password = "correctPassword"
        composeTestRule.onNodeWithTag("buttonSesion").performClick()
        assert(!isEmailError)
        assert(!isPasswordError)
        assert(navigationTriggered)
        assert(email.isEmpty() && password.isEmpty())

        // Validación 5: Probar credenciales incorrectas
        email = "wrong@example.com"
        password = "wrongPassword"
        composeTestRule.onNodeWithTag("buttonSesion").performClick()
        assert(showErrorDialog)
    }
}


