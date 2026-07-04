package com.example.kisner_v_22

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kisner_v_22.ui.theme.AppRed

/**
 * AuthScreen provides the user authentication interface.
 * It contains input fields for username and password with a custom eye icon visibility toggle,
 * and registration and authorization buttons.
 *
 * @param onNavigateToProfile Callback invoked when the user successfully authenticates.
 */
@Composable
fun AuthScreen(
    onNavigateToProfile: () -> Unit
) {
    var username by remember { mutableStateOf("Жанна") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Top Space / App header name
        Text(
            text = "Auth manager",
            color = Color.LightGray,
            fontSize = 14.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 16.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            // Main Illustration (Circular container)
            Box(
                modifier = Modifier
                    .size(240.dp)
                    .padding(bottom = 32.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.auth_illustration),
                    contentDescription = "Auth Illustration",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }

            // Username field
            TextField(
                value = username,
                onValueChange = { username = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                placeholder = { Text("Логин", color = Color.Gray) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Username",
                        tint = AppRed
                    )
                },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = AppRed,
                    unfocusedIndicatorColor = AppRed,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )

            // Password field
            TextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                placeholder = { Text("Пароль", color = Color.Gray) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password",
                        tint = AppRed
                    )
                },
                trailingIcon = {
                    Box(
                        modifier = Modifier
                            .clickable { isPasswordVisible = !isPasswordVisible }
                            .padding(8.dp)
                    ) {
                        Canvas(modifier = Modifier.size(24.dp)) {
                            // Draw outer eye path
                            val path = Path().apply {
                                moveTo(2.dp.toPx(), 12.dp.toPx())
                                quadraticTo(12.dp.toPx(), 4.dp.toPx(), 22.dp.toPx(), 12.dp.toPx())
                                quadraticTo(12.dp.toPx(), 20.dp.toPx(), 2.dp.toPx(), 12.dp.toPx())
                            }
                            drawPath(path = path, color = AppRed, style = Stroke(width = 2.dp.toPx()))
                            // Draw inner pupil
                            drawCircle(color = AppRed, radius = 4.dp.toPx(), center = center)
                        }
                    }
                },
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = AppRed,
                    unfocusedIndicatorColor = AppRed,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )

            // Register flat button
            TextButton(
                onClick = { /* Handle Registration */ },
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text(
                    text = "Зарегистрироваться",
                    color = AppRed,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }

        // Authorize button (Pill shaped at bottom)
        Button(
            onClick = onNavigateToProfile,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = AppRed),
            shape = RoundedCornerShape(28.dp)
        ) {
            Text(
                text = "Авторизоваться",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
