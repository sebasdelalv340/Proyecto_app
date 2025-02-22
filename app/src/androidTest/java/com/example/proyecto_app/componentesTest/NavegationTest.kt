package com.example.proyecto_app.componentesTest

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.NavType
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.testing.TestNavHostController
import com.example.proyecto_app.screen.login.LoginScreen
import com.example.proyecto_app.screen.menu.MenuScreen
import com.example.proyecto_app.screen.portada.PortadaScreen
import com.example.proyecto_app.viewModel.LoginViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    private lateinit var navController: TestNavHostController

    @Before
    fun setupNavHost() {
        val fakeViewModel = LoginViewModel()
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(
                ComposeNavigator()
            )
            NavHost(
                navController = navController,
                startDestination = "portada"
            ) {
                composable("portada") {
                    PortadaScreen(navController)
                }
                composable("login") {
                    LoginScreen(navController, fakeViewModel)
                }
                composable(
                    "menu" + "/{text}",
                    arguments = listOf(navArgument(name = "text") {
                        type = NavType.StringType
                    })
                ) {
                    MenuScreen(navController, it.arguments?.getString("text").toString())
                }
            }
        }
    }

    @Test
    fun whenStart_portadaScreenIsDisplayed() {
        // Verifica que estamos en la pantalla "Portada"
        composeTestRule.onNodeWithTag("portada").assertExists()
        composeTestRule.onNodeWithTag("portada").assertIsDisplayed()
    }

    // Para comprobar este test debemos poner "login" como pantalla de inicio en el NavHost
    @Test
    fun whenClicked_IconNavigateBack_iconBackTest() {

        // Verificar que estamos en la pantalla "Login"
        composeTestRule.onNodeWithTag("login").assertExists()
        composeTestRule.onNodeWithTag("login").assertIsDisplayed()

        // Simula ingresar el nombre de usuario y la contraseña correctos
        composeTestRule.onNodeWithTag("loginEmail").performTextInput("sebas")
        composeTestRule.onNodeWithTag("loginPassword").performTextInput("1234")

        // Simula clic en el botón de "Iniciar sesión"
        composeTestRule.onNodeWithTag("buttonSesion").performClick()

        composeTestRule.waitForIdle()

        // Verifica que estamos en la pantalla "Menu" después de la verificación exitosa
        composeTestRule.onNodeWithTag("menu").assertExists()
        composeTestRule.onNodeWithTag("menu").assertIsDisplayed()

        composeTestRule.onNodeWithTag("iconoBack").assertExists()
        composeTestRule.onNodeWithTag("iconoBack").assertIsDisplayed()
        composeTestRule.onNodeWithTag("iconoBack").performClick()

        composeTestRule.waitForIdle()

        composeTestRule.runOnIdle {
            assert(navController.currentBackStackEntry?.destination?.route == "login")
        }
    }
}