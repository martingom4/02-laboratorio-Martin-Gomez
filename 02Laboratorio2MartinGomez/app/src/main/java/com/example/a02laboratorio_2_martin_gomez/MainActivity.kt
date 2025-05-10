package com.example.a02laboratorio_2_martin_gomez

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.a02laboratorio_2_martin_gomez.ui.theme._02Laboratorio2MartinGomezTheme

// Asegúrate de importar tus pantallas:
import com.example.a02laboratorio_2_martin_gomez.LoginScreen
import com.example.a02laboratorio_2_martin_gomez.CalculatorScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _02Laboratorio2MartinGomezTheme {
                var isLoggedIn by remember { mutableStateOf(false) }
                var username by remember { mutableStateOf("") }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        if (!isLoggedIn) {
                            LoginScreen(
                                onLoginSuccess = { user ->
                                    username = user
                                    isLoggedIn = true
                                }
                            )
                        } else {
                            CalculatorScreen(username = username)
                        }
                    }
                }
            }
        }
    }
}