package com.santiagorey.netflix.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp)
    ) {

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        Text(
            text = "Mi Netflix",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        // PERFIL
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(75.dp)
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .background(
                        Color.Red
                    ),

                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "S",
                    color = Color.White,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.width(18.dp)
            )

            Column {

                Text(
                    text = "Santiago",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = "Administrar perfiles",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
        }

        Spacer(
            modifier = Modifier.height(35.dp)
        )

        // MI LISTA
        ProfileOption(
            icon = "✓",
            title = "Mi lista"
        )

        Divider(
            color = Color.DarkGray
        )

        // DESCARGAS
        ProfileOption(
            icon = "↓",
            title = "Descargas"
        )

        Divider(
            color = Color.DarkGray
        )

        // NOTIFICACIONES
        ProfileOption(
            icon = "●",
            title = "Notificaciones"
        )

        Divider(
            color = Color.DarkGray
        )

        // CONFIGURACIÓN
        ProfileOption(
            icon = "⚙",
            title = "Configuración de la aplicación"
        )

        Divider(
            color = Color.DarkGray
        )

        // CUENTA
        ProfileOption(
            icon = "☰",
            title = "Cuenta"
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Text(
            text = "Cerrar sesión",
            color = Color.Gray,
            fontSize = 15.sp
        )
    }
}

@Composable
fun ProfileOption(
    icon: String,
    title: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 18.dp
            ),

        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = icon,
            color = Color.White,
            fontSize = 24.sp
        )

        Spacer(
            modifier = Modifier.width(18.dp)
        )

        Text(
            text = title,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = ">",
            color = Color.Gray,
            fontSize = 22.sp
        )
    }
}