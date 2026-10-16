package com.santiagorey.netflix.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
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
fun LoginScreen(
    onClickLogin: () -> Unit,
    onClickRegister: () -> Unit
) {

    // Variables para guardar lo que escribe el usuario
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var rememberMe by remember {
        mutableStateOf(false)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 28.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.height(55.dp)
        )


        // LOGO
        Text(
            text = "NETFLIX",
            color = Color(0xFFE50914),
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )


        Spacer(
            modifier = Modifier.height(50.dp)
        )


        // TÍTULO
        Text(
            text = "Iniciar sesión",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )


        Spacer(
            modifier = Modifier.height(25.dp)
        )


        // -----------------------------
        // CORREO
        // -----------------------------

        OutlinedTextField(
            value = email,

            onValueChange = {
                email = it
            },

            label = {
                Text("Email o número de teléfono")
            },

            modifier = Modifier.fillMaxWidth(),

            singleLine = true,

            shape = RoundedCornerShape(5.dp),

            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,

                focusedLabelColor = Color.LightGray,
                unfocusedLabelColor = Color.Gray,

                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.Gray,

                cursorColor = Color.White,

                focusedContainerColor = Color(0xFF292929),
                unfocusedContainerColor = Color(0xFF292929)
            )
        )


        Spacer(
            modifier = Modifier.height(15.dp)
        )


        // -----------------------------
        // CONTRASEÑA
        // -----------------------------

        OutlinedTextField(
            value = password,

            onValueChange = {
                password = it
            },

            label = {
                Text("Contraseña")
            },

            modifier = Modifier.fillMaxWidth(),

            visualTransformation =
                PasswordVisualTransformation(),

            singleLine = true,

            shape = RoundedCornerShape(5.dp),

            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,

                focusedLabelColor = Color.LightGray,
                unfocusedLabelColor = Color.Gray,

                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.Gray,

                cursorColor = Color.White,

                focusedContainerColor = Color(0xFF292929),
                unfocusedContainerColor = Color(0xFF292929)
            )
        )


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        // -----------------------------
        // INICIAR SESIÓN
        // -----------------------------

        Button(
            onClick = {
                onClickLogin()
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),

            shape = RoundedCornerShape(5.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE50914)
            )
        ) {

            Text(
                text = "Iniciar sesión",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }


        Spacer(
            modifier = Modifier.height(15.dp)
        )


        Text(
            text = "O",
            color = Color.Gray
        )


        Spacer(
            modifier = Modifier.height(15.dp)
        )


        Button(
            onClick = {

            },

            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),

            shape = RoundedCornerShape(5.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF333333)
            )
        ) {

            Text(
                text = "Usar un código de acceso",
                color = Color.White
            )
        }


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        Text(
            text = "¿Olvidaste la contraseña?",
            color = Color.White,
            fontSize = 14.sp
        )


        Spacer(
            modifier = Modifier.height(15.dp)
        )


        // RECUÉRDAME
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = rememberMe,

                onCheckedChange = {
                    rememberMe = it
                }
            )


            Text(
                text = "Recuérdame",
                color = Color.White,
                fontSize = 14.sp
            )
        }


        Spacer(
            modifier = Modifier.height(25.dp)
        )


        // REGISTRO
        Row {

            Text(
                text = "¿Primera vez en Netflix? ",
                color = Color.Gray
            )


            Text(
                text = "Suscríbete ahora",
                color = Color.White,
                fontWeight = FontWeight.Bold,

                modifier = Modifier.clickable {
                    onClickRegister()
                }
            )
        }
    }
}