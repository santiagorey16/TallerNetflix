package com.santiagorey.netflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.santiagorey.netflix.ui.screens.HomeScreen
import com.santiagorey.netflix.ui.screens.LoginScreen
import com.santiagorey.netflix.ui.screens.ProfileScreen
import com.santiagorey.netflix.ui.screens.SearchScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            val navController = rememberNavController()

            val navBackStackEntry by
            navController.currentBackStackEntryAsState()

            val currentRoute =
                navBackStackEntry?.destination?.route


            Scaffold(

                containerColor = Color.Black,

                bottomBar = {

                    // Solo mostramos la barra si estamos dentro de la app
                    if (
                        currentRoute == "home" ||
                        currentRoute == "search" ||
                        currentRoute == "profile"
                    ) {

                        NavigationBar(
                            containerColor = Color(0xFF0F0F0F)
                        ) {

                            // INICIO
                            NavigationBarItem(

                                selected = currentRoute == "home",

                                onClick = {
                                    navController.navigate("home") {
                                        launchSingleTop = true
                                    }
                                },

                                icon = {
                                    Text("⌂")
                                },

                                label = {
                                    Text("Inicio")
                                },

                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = Color.Red,
                                    selectedTextColor = Color.White,
                                    unselectedIconColor = Color.Gray,
                                    unselectedTextColor = Color.Gray,
                                    indicatorColor = Color.Transparent
                                )
                            )


                            // BUSCAR
                            NavigationBarItem(

                                selected = currentRoute == "search",

                                onClick = {
                                    navController.navigate("search") {
                                        launchSingleTop = true
                                    }
                                },

                                icon = {
                                    Text("⌕")
                                },

                                label = {
                                    Text("Buscar")
                                },

                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = Color.Red,
                                    selectedTextColor = Color.White,
                                    unselectedIconColor = Color.Gray,
                                    unselectedTextColor = Color.Gray,
                                    indicatorColor = Color.Transparent
                                )
                            )


                            // MI NETFLIX
                            NavigationBarItem(

                                selected = currentRoute == "profile",

                                onClick = {
                                    navController.navigate("profile") {
                                        launchSingleTop = true
                                    }
                                },

                                icon = {
                                    Text("●")
                                },

                                label = {
                                    Text("Mi Netflix")
                                },

                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = Color.Red,
                                    selectedTextColor = Color.White,
                                    unselectedIconColor = Color.Gray,
                                    unselectedTextColor = Color.Gray,
                                    indicatorColor = Color.Transparent
                                )
                            )
                        }
                    }
                }

            ) { paddingValues ->

                NavHost(
                    navController = navController,

                    // AHORA LA APP COMIENZA EN LOGIN
                    startDestination = "login",

                    modifier = Modifier.padding(paddingValues)
                ) {

                    // -------------------------
                    // LOGIN
                    // -------------------------

                    composable("login") {

                        LoginScreen(

                            onClickLogin = {

                                navController.navigate("home") {

                                    // Evita volver al Login con el botón atrás
                                    popUpTo("login") {
                                        inclusive = true
                                    }
                                }
                            },

                            onClickRegister = {

                                navController.navigate("register")
                            }
                        )
                    }


                    // -------------------------
                    // REGISTRO
                    // Temporal por ahora
                    // -------------------------

                    composable("register") {

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Black),

                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                text = "Registro",
                                color = Color.White
                            )
                        }
                    }


                    // -------------------------
                    // HOME
                    // -------------------------

                    composable("home") {

                        HomeScreen()
                    }


                    // -------------------------
                    // BUSCAR
                    // -------------------------

                    composable("search") {

                        SearchScreen()
                    }


                    // -------------------------
                    // MI NETFLIX
                    // -------------------------

                    composable("profile") {

                        ProfileScreen()
                    }
                }
            }
        }
    }
}