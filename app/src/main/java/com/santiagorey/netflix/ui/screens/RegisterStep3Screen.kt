package com.santiagorey.netflix.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegisterStep3Screen(
    onClickBack: () -> Unit,
    onClickFinish: () -> Unit
) {

    var selectedMethod by remember {
        mutableStateOf<String?>(null)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 20.dp)
    ) {

        item {

            Spacer(
                modifier = Modifier.height(40.dp)
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
                modifier = Modifier.height(30.dp)
            )

            Text(
                text = "PASO 3 DE 3",
                color = Color.Gray,
                fontSize = 13.sp
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Configura tu método de pago",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "Elige cómo quieres pagar tu membresía.",
                color = Color.LightGray,
                fontSize = 15.sp
            )

            Spacer(
                modifier = Modifier.height(25.dp)
            )
        }


        // -------------------------
        // TARJETA
        // -------------------------

        item {

            PaymentOption(
                name = "Tarjeta de crédito o débito",
                description = "Visa • Mastercard • American Express",
                icon = "💳",
                selected = selectedMethod == "CARD",

                onClick = {
                    selectedMethod = "CARD"
                }
            )

            Spacer(
                modifier = Modifier.height(15.dp)
            )
        }


        // -------------------------
        // PSE
        // -------------------------

        item {

            PaymentOption(
                name = "PSE",
                description = "Paga desde tu cuenta bancaria",
                icon = "🏦",
                selected = selectedMethod == "PSE",

                onClick = {
                    selectedMethod = "PSE"
                }
            )

            Spacer(
                modifier = Modifier.height(15.dp)
            )
        }


        // -------------------------
        // NEQUI
        // -------------------------

        item {

            PaymentOption(
                name = "Nequi",
                description = "Paga con tu cuenta Nequi",
                icon = "📱",
                selected = selectedMethod == "NEQUI",

                onClick = {
                    selectedMethod = "NEQUI"
                }
            )

            Spacer(
                modifier = Modifier.height(15.dp)
            )
        }


        // -------------------------
        // EFECTY
        // -------------------------

        item {

            PaymentOption(
                name = "Efecty",
                description = "Realiza el pago en un punto Efecty",
                icon = "💵",
                selected = selectedMethod == "EFECTY",

                onClick = {
                    selectedMethod = "EFECTY"
                }
            )

            Spacer(
                modifier = Modifier.height(30.dp)
            )
        }


        // -------------------------
        // BOTÓN FINAL
        // -------------------------

        item {

            Button(
                onClick = {

                    onClickFinish()
                },

                enabled = selectedMethod != null,

                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),

                shape = RoundedCornerShape(5.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    disabledContainerColor = Color.DarkGray
                )
            ) {

                Text(
                    text = "Iniciar membresía",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.height(15.dp)
            )

            Text(
                text = "Esta pantalla simula el proceso de pago para fines académicos.",
                color = Color.Gray,
                fontSize = 12.sp
            )

            Spacer(
                modifier = Modifier.height(30.dp)
            )
        }
    }
}


@Composable
fun PaymentOption(
    name: String,
    description: String,
    icon: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = if (selected) 3.dp else 1.dp,
                color = if (selected) Color.Red else Color.DarkGray,
                shape = RoundedCornerShape(10.dp)
            )
            .background(
                color = Color(0xFF181818),
                shape = RoundedCornerShape(10.dp)
            )
            .clickable {
                onClick()
            }
            .padding(18.dp),

        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = icon,
            fontSize = 28.sp
        )

        Spacer(
            modifier = Modifier.width(15.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = name,
                color = Color.White,
                fontSize = 17.sp,
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


        if (selected) {

            Text(
                text = "✓",
                color = Color.Red,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}