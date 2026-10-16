package com.santiagorey.netflix.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchScreen() {

    // Películas y series disponibles para buscar
    val peliculas = listOf(
        "Stranger Things" to "Serie • Ciencia ficción",
        "Wednesday" to "Serie • Comedia oscura",
        "Squid Game" to "Serie • Thriller",
        "The Witcher" to "Serie • Fantasía",
        "Dark" to "Serie • Ciencia ficción",
        "Arcane" to "Serie • Animación",
        "Black Mirror" to "Serie • Ciencia ficción",
        "Extraction" to "Película • Acción",
        "Bridgerton" to "Serie • Romance",
        "The OA" to "Serie • Misterio"
    )

    // Guarda lo que el usuario escribe
    var searchText by remember {
        mutableStateOf("")
    }

    // Filtra las películas dependiendo de lo escrito
    val resultados = if (searchText.isBlank()) {

        peliculas

    } else {

        peliculas.filter { pelicula ->

            pelicula.first.contains(
                searchText,
                ignoreCase = true
            )
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 16.dp)
    ) {

        // TÍTULO
        item {

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "Buscar",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )
        }

        // BARRA DE BÚSQUEDA
        item {

            OutlinedTextField(
                value = searchText,

                onValueChange = { nuevoTexto ->
                    searchText = nuevoTexto
                },

                modifier = Modifier.fillMaxWidth(),

                placeholder = {
                    Text(
                        text = "Buscar series y películas",
                        color = Color.Gray
                    )
                },

                leadingIcon = {
                    Text(
                        text = "🔍"
                    )
                },

                singleLine = true,

                shape = RoundedCornerShape(8.dp),

                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.DarkGray,
                    cursorColor = Color.Red,
                    focusedContainerColor = Color(0xFF222222),
                    unfocusedContainerColor = Color(0xFF222222)
                )
            )

            Spacer(
                modifier = Modifier.height(25.dp)
            )
        }

        // TÍTULO DE RESULTADOS
        item {

            Text(
                text = if (searchText.isBlank()) {
                    "Películas y series populares"
                } else {
                    "Resultados"
                },

                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )
        }

        // RESULTADOS
        items(resultados) { pelicula ->

            SearchResultCard(
                title = pelicula.first,
                description = pelicula.second
            )
        }

        // Si no encuentra nada
        if (resultados.isEmpty()) {

            item {

                Text(
                    text = "No encontramos resultados para \"$searchText\"",
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 20.dp)
                )
            }
        }

        item {

            Spacer(
                modifier = Modifier.height(30.dp)
            )
        }
    }
}

@Composable
fun SearchResultCard(
    title: String,
    description: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),

        verticalAlignment = Alignment.CenterVertically
    ) {

        // Imagen temporal de la película
        Box(
            modifier = Modifier
                .width(120.dp)
                .height(70.dp)
                .background(
                    color = Color.DarkGray,
                    shape = RoundedCornerShape(6.dp)
                ),

            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "NETFLIX",
                color = Color.Red,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(
            modifier = Modifier.width(15.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = title,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = description,
                color = Color.Gray,
                fontSize = 13.sp
            )
        }

        Text(
            text = "▶",
            color = Color.White,
            fontSize = 22.sp
        )
    }
}