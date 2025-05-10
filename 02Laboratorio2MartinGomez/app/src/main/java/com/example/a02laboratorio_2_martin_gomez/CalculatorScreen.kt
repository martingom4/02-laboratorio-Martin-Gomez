package com.example.a02laboratorio_2_martin_gomez

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.system.exitProcess

@Composable
fun CalculatorScreen(username: String) {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.width(300.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Calculadora", fontSize = 20.sp, color = Color(0xFF6D7377))
                Spacer(modifier = Modifier.height(4.dp))
                Text("Usuario:  $username", color = Color.Gray)

                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(value = num1, onValueChange = { num1 = it }, placeholder = { Text("#1") })
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(value = num2, onValueChange = { num2 = it }, placeholder = { Text("#2") })

                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            result = ((num1.toDoubleOrNull() ?: 0.0) + (num2.toDoubleOrNull() ?: 0.0)).toString()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6D7B81))
                    ) { Text("SUMAR") }

                    Button(
                        onClick = {
                            result = ((num1.toDoubleOrNull() ?: 0.0) - (num2.toDoubleOrNull() ?: 0.0)).toString()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6D7B81))
                    ) { Text("RESTAR") }
                }

                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            result = ((num1.toDoubleOrNull() ?: 0.0) * (num2.toDoubleOrNull() ?: 0.0)).toString()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6D7B81))
                    ) { Text("MULTIPLICAR") }

                    Button(
                        onClick = {
                            result = if ((num2.toDoubleOrNull() ?: 0.0) != 0.0)
                                ((num1.toDoubleOrNull() ?: 0.0) / (num2.toDoubleOrNull() ?: 1.0)).toString()
                            else "Error"
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6D7B81))
                    ) { Text("DIVIDIR") }
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text("Resultado")
                OutlinedTextField(value = result, onValueChange = {}, readOnly = true)

                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { exitProcess(0) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6D7B81))
                ) { Text("Salir") }
            }
        }
    }
}
