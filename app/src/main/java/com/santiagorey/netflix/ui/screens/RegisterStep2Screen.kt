package com.santiagorey.netflix.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
fun RegisterStep2Screen(
    onClickBack: () -> Unit,
    onClickContinue: () -> Unit
) {

    var selectedPlan by remember {
        mutableStateOf<Int?>(null)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 20.dp)
    ) {

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
            text = "PASO 2 DE 3",
            color = Color.Gray,
            fontSize = 13.sp
        )


        Spacer(
            modifier = Modifier.height(8.dp)
        )


        Text(
            text = "Elige el plan ideal para ti",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        Text(
            text = "Puedes cambiar de plan o cancelar cuando quieras.",
            color = Color.LightGray,
            fontSize = 15.sp
        )


        Spacer(
            modifier = Modifier.height(25.dp)
        )


        // -------------------------
        // PLAN 1
        // -------------------------

        PlanCard(
            id = 1,
            name = "Estándar con anuncios",
            price = "COP 15.900/mes",
            quality = "Buena",
            resolution = "1080p (Full HD)",
            screens = "2 dispositivos",
            selectedPlan = selectedPlan,

            onClick = {
                selectedPlan = 1
            }
        )


        Spacer(
            modifier = Modifier.height(15.dp)
        )


        // -------------------------
        // PLAN 2
        // -------------------------

        PlanCard(
            id = 2,
            name = "Estándar",
            price = "COP 23.900/mes",
            quality = "Genial",
            resolution = "1080p (Full HD)",
            screens = "2 dispositivos",
            selectedPlan = selectedPlan,

            onClick = {
                selectedPlan = 2
            }
        )


        Spacer(
            modifier = Modifier.height(15.dp)
        )


        // -------------------------
        // PLAN 3
        // -------------------------

        PlanCard(
            id = 3,
            name = "Premium",
            price = "COP 31.900/mes",
            quality = "Mejor",
            resolution = "4K (Ultra HD) + HDR",
            screens = "4 dispositivos",
            selectedPlan = selectedPlan,

            onClick = {
                selectedPlan = 3
            }
        )


        Spacer(
            modifier = Modifier.height(25.dp)
        )


        // BOTÓN SIGUIENTE
        Button(
            onClick = {
                onClickContinue()
            },

            enabled = selectedPlan != null,

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
                text = "Siguiente",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }


        Spacer(
            modifier = Modifier.height(20.dp)
        )
    }
}


@Composable
fun PlanCard(
    id: Int,
    name: String,
    price: String,
    quality: String,
    resolution: String,
    screens: String,
    selectedPlan: Int?,
    onClick: () -> Unit
) {

    val isSelected = selectedPlan == id


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = if (isSelected) 3.dp else 1.dp,
                color = if (isSelected) Color.Red else Color.DarkGray,
                shape = RoundedCornerShape(10.dp)
            )
            .background(
                color = Color(0xFF181818),
                shape = RoundedCornerShape(10.dp)
            )
            .clickable {
                onClick()
            }
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = name,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )


            if (isSelected) {

                Text(
                    text = "✓",
                    color = Color.Red,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }


        Spacer(
            modifier = Modifier.height(8.dp)
        )


        Text(
            text = price,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )


        Spacer(
            modifier = Modifier.height(10.dp)
        )


        Text(
            text = "Calidad: $quality",
            color = Color.Gray,
            fontSize = 14.sp
        )


        Text(
            text = "Resolución: $resolution",
            color = Color.Gray,
            fontSize = 14.sp
        )


        Text(
            text = "Pantallas: $screens",
            color = Color.Gray,
            fontSize = 14.sp
        )
    }
}
