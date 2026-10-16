package com.santiagorey.netflix.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen() {

    // Películas temporales para probar el diseño.
    val tendencias = listOf(
        "Stranger Things",
        "Wednesday",
        "Squid Game",
        "The Witcher",
        "Dark"
    )

    val nuevos = listOf(
        "Arcane",
        "Black Mirror",
        "Extraction",
        "The OA",
        "Bridgerton"
    )


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        // ---------------------------
        // ENCABEZADO
        // ---------------------------

        item {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "NETFLIX",
                    color = Color.Red,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "☰",
                    color = Color.White,
                    fontSize = 24.sp
                )
            }
        }


        // ---------------------------
        // OPCIONES SUPERIORES
        // ---------------------------

        item {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),

                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Text(
                    text = "Series",
                    color = Color.White
                )

                Text(
                    text = "Películas",
                    color = Color.White
                )

                Text(
                    text = "Categorías",
                    color = Color.White
                )
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )
        }


        // ---------------------------
        // PELÍCULA DESTACADA
        // ---------------------------

        item {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(360.dp)
                    .padding(horizontal = 16.dp)
                    .background(
                        color = Color.DarkGray,
                        shape = RoundedCornerShape(12.dp)
                    ),

                contentAlignment = Alignment.BottomCenter
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "STRANGER THINGS",
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "Misterio • Terror • Ciencia ficción",
                        color = Color.LightGray,
                        fontSize = 14.sp
                    )

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Row {

                        Button(
                            onClick = {

                            },

                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White
                            )
                        ) {

                            Text(
                                text = "▶ Reproducir",
                                color = Color.Black
                            )
                        }


                        Spacer(
                            modifier = Modifier.width(12.dp)
                        )


                        Button(
                            onClick = {

                            },

                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.DarkGray
                            )
                        ) {

                            Text(
                                text = "+ Mi lista",
                                color = Color.White
                            )
                        }
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(25.dp)
            )
        }


        // ---------------------------
        // TENDENCIAS
        // ---------------------------

        item {

            Text(
                text = "Tendencias ahora",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )


            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                items(tendencias) { pelicula ->

                    MovieCard(
                        title = pelicula
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(25.dp)
            )
        }


        // ---------------------------
        // NUEVOS EN NETFLIX
        // ---------------------------

        item {

            Text(
                text = "Nuevos en Netflix",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )


            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                items(nuevos) { pelicula ->

                    MovieCard(
                        title = pelicula
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(30.dp)
            )
        }
    }
}


// Tarjeta reutilizable para mostrar películas.
@Composable
fun MovieCard(
    title: String
) {

    Column(
        modifier = Modifier.width(130.dp)
    ) {

        Box(
            modifier = Modifier
                .width(130.dp)
                .height(180.dp)
                .background(
                    color = Color.DarkGray,
                    shape = RoundedCornerShape(8.dp)
                ),

            contentAlignment = Alignment.Center
        ) {

            Text(
                text = title,
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}