package com.santiagorey.netflix.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
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

    // Plan seleccionado
    var selectedPlan by remember {
        mutableStateOf(1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp)
    ) {

        Spacer(
            modifier = Modifier.height(35.dp)
        )

        // --------------------------------
        // ENCABEZADO
        // --------------------------------

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
                color = Color.Red,
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


        // --------------------------------
        // BARRA DE PROGRESO
        // PASO 2 DE 3
        // --------------------------------

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
        }


        Spacer(
            modifier = Modifier.height(30.dp)
        )


        Text(
            text = "PASO 2 DE 3",
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
            text = "Elige tu plan",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(
                Alignment.CenterHorizontally
            )
        )


        Spacer(
            modifier = Modifier.height(25.dp)
        )


        // --------------------------------
        // BENEFICIOS
        // --------------------------------

        BenefitRow(
            text = "Sin compromisos, cancela cuando quieras."
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        BenefitRow(
            text = "Todo Netflix. Planes a partir de COP 15.900/mes."
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        BenefitRow(
            text = "Sin anuncios en los planes Estándar y Premium."
        )


        Spacer(
            modifier = Modifier.height(25.dp)
        )


        // --------------------------------
        // PLAN CON ANUNCIOS
        // --------------------------------

        PlanSelectionCard(
            id = 1,
            selectedPlan = selectedPlan,
            name = "Estándar con anuncios",
            quality = "Buena",
            price = "COP 15.900/mes",
            popular = false,

            onClick = {
                selectedPlan = 1
            }
        )


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // --------------------------------
        // PLAN ESTÁNDAR
        // --------------------------------

        PlanSelectionCard(
            id = 2,
            selectedPlan = selectedPlan,
            name = "Estándar",
            quality = "Genial",
            price = "COP 23.900/mes",
            popular = false,

            onClick = {
                selectedPlan = 2
            }
        )


        Spacer(
            modifier = Modifier.height(12.dp)
        )


        // --------------------------------
        // PREMIUM
        // --------------------------------

        PlanSelectionCard(
            id = 3,
            selectedPlan = selectedPlan,
            name = "Premium",
            quality = "Mejor",
            price = "COP 31.900/mes",
            popular = true,

            onClick = {
                selectedPlan = 3
            }
        )


        Spacer(
            modifier = Modifier.height(35.dp)
        )


        // --------------------------------
        // SIGUIENTE
        // --------------------------------

        Button(
            onClick = {
                onClickContinue()
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),

            shape = RoundedCornerShape(4.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE50914)
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
            modifier = Modifier.height(18.dp)
        )


        Text(
            text = "Los precios incluyen todos los impuestos aplicables.",
            color = Color.Gray,
            fontSize = 11.sp,
            modifier = Modifier.align(
                Alignment.CenterHorizontally
            )
        )


        Spacer(
            modifier = Modifier.height(8.dp)
        )


        Text(
            text = "Al unirte, aceptas los Términos de uso de Netflix.",
            color = Color.Gray,
            fontSize = 11.sp,
            modifier = Modifier.align(
                Alignment.CenterHorizontally
            )
        )


        Spacer(
            modifier = Modifier.height(25.dp)
        )


        // Idioma decorativo como en la referencia
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .border(
                    width = 1.dp,
                    color = Color.DarkGray,
                    shape = RoundedCornerShape(2.dp)
                )
                .padding(
                    horizontal = 15.dp,
                    vertical = 8.dp
                )
        ) {

            Text(
                text = "🌐 Español ▾",
                color = Color.Gray,
                fontSize = 12.sp
            )
        }


        Spacer(
            modifier = Modifier.height(35.dp)
        )
    }
}


// --------------------------------
// BENEFICIO
// --------------------------------

@Composable
fun BenefitRow(
    text: String
) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(18.dp)
                .background(
                    color = Color(0xFF46D369),
                    shape = RoundedCornerShape(50)
                ),

            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "✓",
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }


        Spacer(
            modifier = Modifier.width(10.dp)
        )


        Text(
            text = text,
            color = Color.White,
            fontSize = 14.sp
        )
    }
}


// --------------------------------
// TARJETA DEL PLAN
// --------------------------------

@Composable
fun PlanSelectionCard(
    id: Int,
    selectedPlan: Int,
    name: String,
    quality: String,
    price: String,
    popular: Boolean,
    onClick: () -> Unit
) {

    val selected =
        selectedPlan == id


    Box(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column {

            // Etiqueta MÁS POPULAR
            if (popular) {

                Box(
                    modifier = Modifier
                        .padding(start = 100.dp)
                        .background(
                            color = Color(0xFFE50914),
                            shape = RoundedCornerShape(
                                topStart = 4.dp,
                                topEnd = 4.dp
                            )
                        )
                        .padding(
                            horizontal = 10.dp,
                            vertical = 4.dp
                        )
                ) {

                    Text(
                        text = "MÁS POPULAR",
                        color = Color.White,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width =
                            if (selected) {
                                2.dp
                            } else {
                                1.dp
                            },

                        color =
                            if (selected) {
                                Color.White
                            } else {
                                Color.DarkGray
                            },

                        shape =
                            RoundedCornerShape(6.dp)
                    )
                    .background(
                        color =
                            if (selected) {
                                Color(0xFF1B1B2F)
                            } else {
                                Color(0xFF181818)
                            },

                        shape =
                            RoundedCornerShape(6.dp)
                    )
                    .clickable {
                        onClick()
                    }
                    .padding(
                        horizontal = 8.dp,
                        vertical = 10.dp
                    ),

                verticalAlignment =
                    Alignment.CenterVertically
            ) {


                RadioButton(
                    selected = selected,

                    onClick = {
                        onClick()
                    },

                    colors =
                        RadioButtonDefaults.colors(

                            selectedColor =
                                Color.White,

                            unselectedColor =
                                Color.Gray
                        )
                )


                Spacer(
                    modifier = Modifier.width(4.dp)
                )


                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = name,
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(3.dp)
                    )

                    Text(
                        text = quality,
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }


                Text(
                    text = price,
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}