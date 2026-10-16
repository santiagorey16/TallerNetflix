package com.santiagorey.netflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.santiagorey.netflix.ui.screens.HomeScreen
import com.santiagorey.netflix.ui.screens.LoginScreen
import com.santiagorey.netflix.ui.screens.ProfileScreen
import com.santiagorey.netflix.ui.screens.RegisterScreen
import com.santiagorey.netflix.ui.screens.RegisterStep2Screen
import com.santiagorey.netflix.ui.screens.RegisterStep3Screen
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

                    // La barra inferior solamente aparece
                    // dentro de la aplicación principal
                    if (
                        currentRoute == "home" ||
                        currentRoute == "search" ||
                        currentRoute == "profile"
                    ) {

                        NavigationBar(
                            containerColor = Color(0xFF0F0F0F)
                        ) {

                            // -------------------------
                            // INICIO
                            // -------------------------

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


                            // -------------------------
                            // BUSCAR
                            // -------------------------

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


                            // -------------------------
                            // MI NETFLIX
                            // -------------------------

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
                    // PASO 1 DE 3
                    // -------------------------

                    composable("register") {

                        RegisterScreen(

                            onClickBack = {

                                navController.popBackStack()
                            },

                            onClickContinue = {

                                navController.navigate("register2")
                            }
                        )
                    }


                    // -------------------------
                    // REGISTRO
                    // PASO 2 DE 3
                    // -------------------------

                    composable("register2") {

                        RegisterStep2Screen(

                            onClickBack = {

                                navController.popBackStack()
                            },

                            onClickContinue = {

                                navController.navigate("register3")
                            }
                        )
                    }


                    // -------------------------
                    // REGISTRO
                    // PASO 3 DE 3
                    // -------------------------

                    composable("register3") {

                        RegisterStep3Screen(

                            onClickBack = {

                                navController.popBackStack()
                            },

                            onClickFinish = {

                                navController.navigate("home") {

                                    // Eliminamos todo el proceso
                                    // de registro del historial
                                    popUpTo("login") {
                                        inclusive = true
                                    }
                                }
                            }
                        )
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