package com.santiagorey.netflix.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
fun RegisterScreen(
    onClickBack: () -> Unit,
    onClickContinue: () -> Unit,
    onClickLogin: () -> Unit
) {

    // -----------------------------
    // DATOS QUE ESCRIBE EL USUARIO
    // -----------------------------

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var confirmPassword by remember {
        mutableStateOf("")
    }

    var receiveEmails by remember {
        mutableStateOf(false)
    }


    // -----------------------------
    // VALIDACIONES
    // -----------------------------

    val validLength =
        password.length in 8..60

    val hasLetter =
        password.any {
            it.isLetter()
        }

    val hasNumberOrSymbol =
        password.any {
            it.isDigit() || !it.isLetterOrDigit()
        }

    val passwordsMatch =
        password.isNotEmpty() &&
                password == confirmPassword


    val canContinue =
        email.isNotBlank() &&
                validLength &&
                hasLetter &&
                hasNumberOrSymbol &&
                passwordsMatch


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(
                rememberScrollState()
            )
            .padding(horizontal = 20.dp)
    ) {

        Spacer(
            modifier = Modifier.height(35.dp)
        )


        // -----------------------------
        // ENCABEZADO
        // -----------------------------

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "←",
                color = Color.White,
                fontSize = 28.sp,

                modifier = Modifier.clickable {
                    onClickBack()
                }
            )


            Text(
                text = "NETFLIX",
                color = Color(0xFFE50914),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,

                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(
                        Alignment.CenterHorizontally
                    )
            )


            Spacer(
                modifier = Modifier.width(28.dp)
            )
        }


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        // -----------------------------
        // PROGRESO
        // -----------------------------

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(3.dp)
                    .background(Color.White)
            )

            Spacer(
                modifier = Modifier.width(2.dp)
            )

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(3.dp)
                    .background(Color.DarkGray)
            )

            Spacer(
                modifier = Modifier.width(2.dp)
            )

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(3.dp)
                    .background(Color.DarkGray)
            )
        }


        Spacer(
            modifier = Modifier.height(30.dp)
        )


        Text(
            text = "PASO 1 DE 3",
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = Modifier.align(
                Alignment.CenterHorizontally
            )
        )


        Spacer(
            modifier = Modifier.height(8.dp)
        )


        Text(
            text = "Crea tu contraseña",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(
                Alignment.CenterHorizontally
            )
        )


        Spacer(
            modifier = Modifier.height(10.dp)
        )


        Text(
            text = "Solo unos pasos más y podrás disfrutar del contenido. No necesitamos tarjeta de crédito.",
            color = Color.Gray,
            fontSize = 14.sp
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
                Text("Correo electrónico")
            },

            modifier = Modifier.fillMaxWidth(),

            singleLine = true,

            shape = RoundedCornerShape(4.dp),

            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,

                focusedLabelColor = Color.LightGray,
                unfocusedLabelColor = Color.Gray,

                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.DarkGray,

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
                Text("Crea una contraseña")
            },

            modifier = Modifier.fillMaxWidth(),

            visualTransformation =
                PasswordVisualTransformation(),

            singleLine = true,

            shape = RoundedCornerShape(4.dp),

            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,

                focusedLabelColor = Color.LightGray,
                unfocusedLabelColor = Color.Gray,

                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.DarkGray,

                cursorColor = Color.White,

                focusedContainerColor = Color(0xFF292929),
                unfocusedContainerColor = Color(0xFF292929)
            )
        )


        Spacer(
            modifier = Modifier.height(15.dp)
        )


        // -----------------------------
        // CONFIRMAR CONTRASEÑA
        // -----------------------------

        OutlinedTextField(
            value = confirmPassword,

            onValueChange = {
                confirmPassword = it
            },

            label = {
                Text("Confirma tu contraseña")
            },

            modifier = Modifier.fillMaxWidth(),

            visualTransformation =
                PasswordVisualTransformation(),

            singleLine = true,

            shape = RoundedCornerShape(4.dp),

            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,

                focusedLabelColor = Color.LightGray,
                unfocusedLabelColor = Color.Gray,

                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.DarkGray,

                cursorColor = Color.White,

                focusedContainerColor = Color(0xFF292929),
                unfocusedContainerColor = Color(0xFF292929)
            )
        )


        Spacer(
            modifier = Modifier.height(15.dp)
        )


        // -----------------------------
        // REGLAS DE CONTRASEÑA
        // -----------------------------

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFF181818),
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(15.dp)
        ) {

            Text(
                text = "La contraseña debe tener:",
                color = Color.Gray,
                fontSize = 13.sp
            )


            Spacer(
                modifier = Modifier.height(10.dp)
            )


            RegisterRule(
                completed = validLength,
                text = "Entre 8 y 60 caracteres"
            )


            Spacer(
                modifier = Modifier.height(7.dp)
            )


            RegisterRule(
                completed = hasLetter,
                text = "Al menos una letra"
            )


            Spacer(
                modifier = Modifier.height(7.dp)
            )


            RegisterRule(
                completed = hasNumberOrSymbol,
                text = "Al menos un número o símbolo"
            )


            if (confirmPassword.isNotEmpty()) {

                Spacer(
                    modifier = Modifier.height(7.dp)
                )


                RegisterRule(
                    completed = passwordsMatch,
                    text = "Las contraseñas coinciden"
                )
            }
        }


        Spacer(
            modifier = Modifier.height(15.dp)
        )


        // -----------------------------
        // CHECKBOX
        // -----------------------------

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {

            Checkbox(
                checked = receiveEmails,

                onCheckedChange = {
                    receiveEmails = it
                }
            )


            Text(
                text = "Me gustaría recibir correos de Netflix con ofertas especiales, novedades y más sobre los productos y servicios de Netflix.",
                color = Color.Gray,
                fontSize = 12.sp,

                modifier = Modifier.padding(
                    top = 12.dp
                )
            )
        }


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        // -----------------------------
        // SIGUIENTE
        // -----------------------------

        Button(
            onClick = {
                onClickContinue()
            },

            enabled = canContinue,

            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),

            shape = RoundedCornerShape(4.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE50914),

                disabledContainerColor =
                    Color(0xFF71070D),

                disabledContentColor =
                    Color.Gray
            )
        ) {

            Text(
                text = "Siguiente",
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }


        Spacer(
            modifier = Modifier.height(25.dp)
        )


        // -----------------------------
        // VOLVER AL LOGIN
        // -----------------------------

        Row(
            modifier = Modifier.align(
                Alignment.CenterHorizontally
            )
        ) {

            Text(
                text = "¿Ya tienes cuenta? ",
                color = Color.Gray,
                fontSize = 13.sp
            )


            Text(
                text = "Inicia sesión.",
                color = Color.White,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,

                modifier = Modifier.clickable {
                    onClickLogin()
                }
            )
        }


        Spacer(
            modifier = Modifier.height(25.dp)
        )


        Text(
            text = "Al hacer clic en \"Siguiente\", aceptas nuestros Términos de uso.",
            color = Color.DarkGray,
            fontSize = 11.sp
        )


        Spacer(
            modifier = Modifier.height(30.dp)
        )
    }
}


@Composable
fun RegisterRule(
    completed: Boolean,
    text: String
) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text =
                if (completed) {
                    "✓"
                } else {
                    "○"
                },

            color =
                if (completed) {
                    Color(0xFF46D369)
                } else {
                    Color.Gray
                }
        )


        Spacer(
            modifier = Modifier.width(10.dp)
        )


        Text(
            text = text,
            color = Color.Gray,
            fontSize = 12.sp
        )
    }
}