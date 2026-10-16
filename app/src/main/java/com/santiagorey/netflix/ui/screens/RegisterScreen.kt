package com.santiagorey.netflix.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegisterScreen(
    onClickBack: () -> Unit,
    onClickContinue: () -> Unit
) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 25.dp)
    ) {

        Spacer(
            modifier = Modifier.height(45.dp)
        )

        // PARTE SUPERIOR
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "‹",
                color = Color.White,
                fontSize = 40.sp,
                modifier = Modifier.clickable {
                    onClickBack()
                }
            )

            Spacer(
                modifier = Modifier.width(15.dp)
            )

            Text(
                text = "NETFLIX",
                color = Color.Red,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(
            modifier = Modifier.height(50.dp)
        )

        // PASO
        Text(
            text = "PASO 1 DE 3",
            color = Color.Gray,
            fontSize = 13.sp
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        // TÍTULO
        Text(
            text = "Crea una contraseña para comenzar tu membresía",
            color = Color.White,
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = "Solo faltan unos pasos. Netflix tampoco es fan de los trámites.",
            color = Color.LightGray,
            fontSize = 16.sp
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        // CORREO
        OutlinedTextField(
            value = email,

            onValueChange = {
                email = it
            },

            modifier = Modifier.fillMaxWidth(),

            label = {
                Text("Email")
            },

            singleLine = true,

            shape = RoundedCornerShape(5.dp),

            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.Gray,
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color.White,
                focusedContainerColor = Color(0xFF222222),
                unfocusedContainerColor = Color(0xFF222222)
            )
        )

        Spacer(
            modifier = Modifier.height(18.dp)
        )

        // CONTRASEÑA
        OutlinedTextField(
            value = password,

            onValueChange = {
                password = it
            },

            modifier = Modifier.fillMaxWidth(),

            label = {
                Text("Contraseña")
            },

            visualTransformation = PasswordVisualTransformation(),

            singleLine = true,

            shape = RoundedCornerShape(5.dp),

            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.Gray,
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color.White,
                focusedContainerColor = Color(0xFF222222),
                unfocusedContainerColor = Color(0xFF222222)
            )
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        // BOTÓN CONTINUAR
        Button(
            onClick = {
                onClickContinue()
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),

            shape = RoundedCornerShape(5.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            )
        ) {

            Text(
                text = "Siguiente",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}