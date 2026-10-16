package com.santiagorey.netflix.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun RegisterStep3Screen(
    onClickBack: () -> Unit,
    onClickChangePlan: () -> Unit,
    onClickFinish: () -> Unit
) {

    // Método seleccionado
    var selectedMethod by remember {
        mutableStateOf("CARD")
    }


    // -----------------------------
    // DATOS DE TARJETA
    // -----------------------------

    var cardNumber by remember {
        mutableStateOf("")
    }

    var cardName by remember {
        mutableStateOf("")
    }

    var expiration by remember {
        mutableStateOf("")
    }

    var cvv by remember {
        mutableStateOf("")
    }


    // -----------------------------
    // DATOS PSE
    // -----------------------------

    var bank by remember {
        mutableStateOf("")
    }

    var documentType by remember {
        mutableStateOf("CC")
    }

    var documentNumber by remember {
        mutableStateOf("")
    }

    var personType by remember {
        mutableStateOf("Natural")
    }


    // -----------------------------
    // DATOS NEQUI
    // -----------------------------

    var nequiPhone by remember {
        mutableStateOf("")
    }


    // -----------------------------
    // DATOS EFECTY
    // -----------------------------

    var efectyName by remember {
        mutableStateOf("")
    }

    var efectyDocument by remember {
        mutableStateOf("")
    }


    // -----------------------------
    // VALIDACIÓN
    // -----------------------------

    val canContinue = when (selectedMethod) {

        "CARD" ->
            cardNumber.isNotBlank() &&
                    cardName.isNotBlank() &&
                    expiration.isNotBlank() &&
                    cvv.isNotBlank()

        "PSE" ->
            bank.isNotBlank() &&
                    documentNumber.isNotBlank()

        "NEQUI" ->
            nequiPhone.isNotBlank()

        "EFECTY" ->
            efectyName.isNotBlank() &&
                    efectyDocument.isNotBlank()

        else -> false
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(
                rememberScrollState()
            )
            .imePadding()
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

            verticalAlignment =
                Alignment.CenterVertically
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


        // -----------------------------
        // BARRA DE PROGRESO
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
        }


        Spacer(
            modifier = Modifier.height(30.dp)
        )


        Text(
            text = "PASO 3 DE 3",
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
            text = "Configura el pago",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,

            modifier = Modifier.align(
                Alignment.CenterHorizontally
            )
        )


        Spacer(
            modifier = Modifier.height(8.dp)
        )


        Text(
            text = "Tu membresía comienza en cuanto configures tu método de pago.",
            color = Color.Gray,
            fontSize = 14.sp,

            modifier = Modifier.align(
                Alignment.CenterHorizontally
            )
        )


        Spacer(
            modifier = Modifier.height(25.dp)
        )


        // -----------------------------
        // PLAN SELECCIONADO
        // -----------------------------

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFF181818),
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(15.dp),

            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "Plan seleccionado",
                    color = Color.Gray,
                    fontSize = 12.sp
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = "Premium",
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "COP 31.900/mes",
                    color = Color.Gray,
                    fontSize = 13.sp
                )
            }


            Text(
                text = "Cambiar",
                color = Color(0xFF448AFF),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,

                modifier = Modifier.clickable {

                    onClickChangePlan()
                }
            )
        }


        Spacer(
            modifier = Modifier.height(25.dp)
        )


        Text(
            text = "Elige cómo pagar",
            color = Color.White,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )


        Spacer(
            modifier = Modifier.height(15.dp)
        )


        // -----------------------------
        // MÉTODOS DE PAGO
        // -----------------------------

        Row(
            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.spacedBy(7.dp)
        ) {


            PaymentMethodButton(
                name = "Tarjeta",
                icon = "●",
                selected =
                    selectedMethod == "CARD",

                modifier = Modifier.weight(1f),

                onClick = {

                    selectedMethod = "CARD"
                }
            )


            PaymentMethodButton(
                name = "PSE",
                icon = "●",
                selected =
                    selectedMethod == "PSE",

                modifier = Modifier.weight(1f),

                onClick = {

                    selectedMethod = "PSE"
                }
            )


            PaymentMethodButton(
                name = "Nequi",
                icon = "☎",
                selected =
                    selectedMethod == "NEQUI",

                modifier = Modifier.weight(1f),

                onClick = {

                    selectedMethod = "NEQUI"
                }
            )


            PaymentMethodButton(
                name = "Efecty",
                icon = "🛒",
                selected =
                    selectedMethod == "EFECTY",

                modifier = Modifier.weight(1f),

                onClick = {

                    selectedMethod = "EFECTY"
                }
            )
        }


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        // =================================================
        // TARJETA
        // =================================================

        if (selectedMethod == "CARD") {


            // Tarjeta decorativa
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .background(
                        brush =
                            Brush.horizontalGradient(
                                listOf(
                                    Color(0xFF15256B),
                                    Color(0xFF6A1B9A)
                                )
                            ),

                        shape =
                            RoundedCornerShape(12.dp)
                    )
                    .padding(20.dp)
            ) {

                Column(
                    modifier = Modifier.fillMaxSize(),

                    verticalArrangement =
                        Arrangement.SpaceBetween
                ) {

                    Row(
                        modifier =
                            Modifier.fillMaxWidth(),

                        horizontalArrangement =
                            Arrangement.SpaceBetween
                    ) {

                        Box(
                            modifier = Modifier
                                .size(
                                    width = 32.dp,
                                    height = 24.dp
                                )
                                .background(
                                    Color(0xFFFFD600),
                                    RoundedCornerShape(3.dp)
                                )
                        )


                        Text(
                            text = "VISA",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight =
                                FontWeight.Bold
                        )
                    }


                    Text(
                        text =
                            if (cardNumber.isBlank()) {
                                "••••  ••••  ••••  ••••"
                            } else {
                                cardNumber
                            },

                        color = Color.White,
                        fontSize = 18.sp
                    )


                    Row(
                        modifier =
                            Modifier.fillMaxWidth(),

                        horizontalArrangement =
                            Arrangement.SpaceBetween
                    ) {

                        Column {

                            Text(
                                text = "TITULAR",
                                color =
                                    Color.LightGray,
                                fontSize = 9.sp
                            )

                            Text(
                                text =
                                    if (cardName.isBlank()) {
                                        "NOMBRE COMPLETO"
                                    } else {
                                        cardName.uppercase()
                                    },

                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight =
                                    FontWeight.Bold
                            )
                        }


                        Column {

                            Text(
                                text = "VENCE",
                                color =
                                    Color.LightGray,
                                fontSize = 9.sp
                            )

                            Text(
                                text =
                                    if (expiration.isBlank()) {
                                        "MM/AA"
                                    } else {
                                        expiration
                                    },

                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight =
                                    FontWeight.Bold
                            )
                        }
                    }
                }
            }


            Spacer(
                modifier = Modifier.height(20.dp)
            )


            PaymentTextField(
                value = cardNumber,

                onValueChange = {
                    cardNumber = it
                },

                label = "Número de tarjeta",

                keyboardType =
                    KeyboardType.Number
            )


            Spacer(
                modifier = Modifier.height(12.dp)
            )


            PaymentTextField(
                value = cardName,

                onValueChange = {
                    cardName = it
                },

                label = "Nombre del titular"
            )


            Spacer(
                modifier = Modifier.height(12.dp)
            )


            Row(
                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.spacedBy(10.dp)
            ) {

                PaymentTextField(
                    value = expiration,

                    onValueChange = {
                        expiration = it
                    },

                    label = "MM/AA",

                    modifier =
                        Modifier.weight(1f)
                )


                PaymentTextField(
                    value = cvv,

                    onValueChange = {
                        cvv = it
                    },

                    label = "CVV",

                    keyboardType =
                        KeyboardType.Number,

                    modifier =
                        Modifier.weight(1f)
                )
            }
        }


        // =================================================
        // PSE
        // =================================================

        if (selectedMethod == "PSE") {

            Text(
                text = "Transferencia bancaria PSE",
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )


            Spacer(
                modifier = Modifier.height(15.dp)
            )


            PaymentTextField(
                value = bank,

                onValueChange = {
                    bank = it
                },

                label = "Banco"
            )


            Spacer(
                modifier = Modifier.height(12.dp)
            )


            Row(
                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.spacedBy(10.dp)
            ) {


                PaymentTextField(
                    value = documentType,

                    onValueChange = {
                        documentType = it
                    },

                    label = "Tipo",

                    modifier =
                        Modifier.weight(0.8f)
                )


                PaymentTextField(
                    value = documentNumber,

                    onValueChange = {
                        documentNumber = it
                    },

                    label = "Número de documento",

                    keyboardType =
                        KeyboardType.Number,

                    modifier =
                        Modifier.weight(1.5f)
                )
            }


            Spacer(
                modifier = Modifier.height(15.dp)
            )


            Text(
                text = "Tipo de persona",
                color = Color.Gray,
                fontSize = 12.sp
            )


            Row(
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                RadioButton(
                    selected =
                        personType == "Natural",

                    onClick = {
                        personType = "Natural"
                    },

                    colors =
                        RadioButtonDefaults.colors(
                            selectedColor =
                                Color.White
                        )
                )


                Text(
                    text = "Natural",
                    color = Color.White
                )


                Spacer(
                    modifier = Modifier.width(15.dp)
                )


                RadioButton(
                    selected =
                        personType == "Juridica",

                    onClick = {
                        personType = "Juridica"
                    },

                    colors =
                        RadioButtonDefaults.colors(
                            selectedColor =
                                Color.White
                        )
                )


                Text(
                    text = "Jurídica",
                    color = Color.White
                )
            }


            Spacer(
                modifier = Modifier.height(10.dp)
            )


            InfoBox(
                text = "Serás redirigido al sitio web de tu banco para completar el pago de forma segura."
            )
        }


        // =================================================
        // NEQUI
        // =================================================

        if (selectedMethod == "NEQUI") {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color =
                            Color(0xFF3A0055),

                        shape =
                            RoundedCornerShape(6.dp)
                    )
                    .padding(15.dp),

                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            Color(0xFF7B00FF),
                            RoundedCornerShape(5.dp)
                        ),

                    contentAlignment =
                        Alignment.Center
                ) {

                    Text(
                        text = "N",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight =
                            FontWeight.Bold
                    )
                }


                Spacer(
                    modifier = Modifier.width(12.dp)
                )


                Column {

                    Text(
                        text = "Pagar con Nequi",
                        color = Color.White,
                        fontWeight =
                            FontWeight.Bold
                    )

                    Text(
                        text = "Recibe una notificación en tu app",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }
            }


            Spacer(
                modifier = Modifier.height(20.dp)
            )


            PaymentTextField(
                value = nequiPhone,

                onValueChange = {
                    nequiPhone = it
                },

                label = "Número de celular Nequi",

                keyboardType =
                    KeyboardType.Phone
            )


            Spacer(
                modifier = Modifier.height(12.dp)
            )


            InfoBox(
                text = "Recibirás una notificación push en tu app de Nequi para confirmar el pago."
            )
        }


        // =================================================
        // EFECTY
        // =================================================

        if (selectedMethod == "EFECTY") {

            Text(
                text = "Pago en efectivo",
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )


            Spacer(
                modifier = Modifier.height(8.dp)
            )


            Text(
                text = "Generaremos una referencia para que puedas realizar el pago en un punto Efecty.",
                color = Color.Gray,
                fontSize = 13.sp
            )


            Spacer(
                modifier = Modifier.height(18.dp)
            )


            PaymentTextField(
                value = efectyName,

                onValueChange = {
                    efectyName = it
                },

                label = "Nombre completo"
            )


            Spacer(
                modifier = Modifier.height(12.dp)
            )


            PaymentTextField(
                value = efectyDocument,

                onValueChange = {
                    efectyDocument = it
                },

                label = "Número de documento",

                keyboardType =
                    KeyboardType.Number
            )


            Spacer(
                modifier = Modifier.height(12.dp)
            )


            InfoBox(
                text = "Al continuar recibirás una referencia de pago para completar la transacción en Efecty."
            )
        }


        Spacer(
            modifier = Modifier.height(35.dp)
        )


        // -----------------------------
        // BOTÓN FINAL
        // -----------------------------

        Button(
            onClick = {

                onClickFinish()
            },

            enabled = canContinue,

            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),

            shape =
                RoundedCornerShape(4.dp),

            colors =
                ButtonDefaults.buttonColors(

                    containerColor =
                        Color(0xFFE50914),

                    disabledContainerColor =
                        Color(0xFF5A0A0E),

                    disabledContentColor =
                        Color.Gray
                )
        ) {

            Text(
                text = "Iniciar membresía",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }


        Spacer(
            modifier = Modifier.height(15.dp)
        )


        Text(
            text = "Al hacer clic en \"Iniciar membresía\", aceptas nuestros Términos de uso y confirmas que eres mayor de edad.",
            color = Color.Gray,
            fontSize = 10.sp
        )


        Spacer(
            modifier = Modifier.height(35.dp)
        )
    }
}


// =================================================
// BOTÓN DE MÉTODO DE PAGO
// =================================================

@Composable
fun PaymentMethodButton(
    name: String,
    icon: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Column(
        modifier = modifier
            .height(75.dp)
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
                    RoundedCornerShape(5.dp)
            )
            .background(
                color =
                    if (selected) {
                        Color(0xFF1B1B2F)
                    } else {
                        Color(0xFF181818)
                    },

                shape =
                    RoundedCornerShape(5.dp)
            )
            .clickable {
                onClick()
            },

        horizontalAlignment =
            Alignment.CenterHorizontally,

        verticalArrangement =
            Arrangement.Center
    ) {

        Text(
            text = icon,
            color = Color.Gray,
            fontSize = 20.sp
        )

        Spacer(
            modifier = Modifier.height(6.dp)
        )

        Text(
            text = name,
            color =
                if (selected) {
                    Color.White
                } else {
                    Color.Gray
                },
            fontSize = 11.sp
        )
    }
}


// =================================================
// CAMPO REUTILIZABLE
// =================================================

@Composable
fun PaymentTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType =
        KeyboardType.Text,
    modifier: Modifier = Modifier
) {

    OutlinedTextField(

        value = value,

        onValueChange = onValueChange,

        modifier = modifier
            .fillMaxWidth(),

        label = {

            Text(
                text = label
            )
        },

        keyboardOptions =
            KeyboardOptions(
                keyboardType =
                    keyboardType
            ),

        singleLine = true,

        shape =
            RoundedCornerShape(4.dp),

        colors =
            OutlinedTextFieldDefaults.colors(

                focusedTextColor =
                    Color.White,

                unfocusedTextColor =
                    Color.White,

                focusedLabelColor =
                    Color.LightGray,

                unfocusedLabelColor =
                    Color.Gray,

                focusedBorderColor =
                    Color.White,

                unfocusedBorderColor =
                    Color.DarkGray,

                cursorColor =
                    Color.White,

                focusedContainerColor =
                    Color(0xFF292929),

                unfocusedContainerColor =
                    Color(0xFF292929)
            )
    )
}


// =================================================
// CUADRO DE INFORMACIÓN
// =================================================

@Composable
fun InfoBox(
    text: String
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF181818),
                shape =
                    RoundedCornerShape(5.dp)
            )
            .padding(12.dp)
    ) {

        Text(
            text = "ⓘ  $text",
            color = Color.Gray,
            fontSize = 11.sp
        )
    }
}