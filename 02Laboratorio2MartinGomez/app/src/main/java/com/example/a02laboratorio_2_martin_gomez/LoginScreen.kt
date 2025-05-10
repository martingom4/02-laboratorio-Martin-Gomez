package com.example.a02laboratorio_2_martin_gomez

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoginScreen(onLoginSuccess: (String) -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.width(300.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                /*Image(
                    painter = painterResource(id = R.drawable.placeholder),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .padding(bottom = 16.dp)
                )*/

                Text("Login", fontSize = 28.sp, color = Color(0xFF6D7377))

                Spacer(modifier = Modifier.height(16.dp))

                Text("Usuario", color = Color.Gray)
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("mi_usuario") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text("Clave", color = Color.Gray)
                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    label = { Text("**********") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                val isPasswordValid = remember(password) {
                    password.length >= 8 &&
                    password.any { it.isUpperCase() } &&
                    password.any { it.isLowerCase() } &&
                    password.any { it.isDigit() } &&
                    password.contains("-")
                }

                if (!isPasswordValid && password.isNotEmpty()) {
                    Text(
                        text = "La contraseña debe tener al menos 8 caracteres, mayúscula, minúscula, número y un guion (-).",
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (username.isNotBlank() && isPasswordValid) {
                            onLoginSuccess(username)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6D7B81)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Accesar")
                }
            }
        }
    }
}
