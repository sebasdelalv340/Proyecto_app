package com.example.proyecto_app.screen.menu

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.EditCalendar
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyecto_app.model.Opcion
import com.example.proyecto_app.ui.theme.Orange

@Composable
fun CardOpcion(opcion: Opcion){
    Card(
        modifier = Modifier
            .size(150.dp)
            .padding(16.dp)
            .clickable {  }
            .testTag("cardOption"),
        elevation = CardDefaults.cardElevation(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Orange,
            contentColor = Color.Black
        ),
        border = BorderStroke(2.dp, Color.Gray),
        shape = MaterialTheme.shapes.small
        ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = opcion.icono,
                contentDescription = opcion.descripcion,
                modifier = Modifier
                    .size(70.dp)
            )
            Text(
                text= opcion.texto,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun OpcionesGridView(navController: NavController){
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(getOpciones()){ opcion ->
                CardOpcion(opcion)
            }
        }
    )
}


fun getOpciones(): List<Opcion> {
    val listaOpciones = listOf(
        Opcion(Icons.Filled.PersonAdd, "Crear usuario", "Registrar de usuario"),
        Opcion(Icons.Filled.EditCalendar, "Reservar", "Reservar una clase"),
        Opcion(Icons.Filled.CalendarMonth, "Calendario", "Ver calendario"),
        Opcion(Icons.Filled.Coffee, "Blog", "Acceder al blog"),
        Opcion(Icons.Filled.Settings, "Settings", "Acceder a los ajustes"),
        Opcion(Icons.Filled.Info, "Info", "Contactar con nosotros")
    )
    return listaOpciones
}