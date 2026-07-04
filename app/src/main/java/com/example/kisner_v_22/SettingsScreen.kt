package com.example.kisner_v_22

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kisner_v_22.ui.theme.AppRed

@Composable
fun SettingsScreen(
    onNavigateBack: () -> Unit,
    onLogout: () -> Unit
) {
    var showSessionDuration by remember { mutableStateOf(true) }
    var showActivePromo by remember { mutableStateOf(true) }
    var notifyFreeTime by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            // Mockup title at very top
            Text(
                text = "Settings manager",
                color = Color.LightGray,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Navigation Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = onNavigateBack) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = AppRed,
                        modifier = Modifier.size(28.dp)
                    )
                }

                Text(
                    text = "Настройки",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                IconButton(onClick = onLogout) {
                    Icon(
                        imageVector = Icons.Default.ExitToApp,
                        contentDescription = "Logout",
                        tint = AppRed,
                        modifier = Modifier.size(28.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(48.dp))

            // Options List
            // Option 1
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Показывать срок действия сеанса",
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Checkbox(
                    checked = showSessionDuration,
                    onCheckedChange = { showSessionDuration = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = AppRed,
                        uncheckedColor = Color.LightGray,
                        checkmarkColor = Color.White
                    )
                )
            }

            // Option 2
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Показывать активные акции",
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Checkbox(
                    checked = showActivePromo,
                    onCheckedChange = { showActivePromo = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = AppRed,
                        uncheckedColor = Color.LightGray,
                        checkmarkColor = Color.White
                    )
                )
            }

            // Option 3
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Сообщать о свободном времени",
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Checkbox(
                    checked = notifyFreeTime,
                    onCheckedChange = { notifyFreeTime = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = AppRed,
                        uncheckedColor = Color.LightGray,
                        checkmarkColor = Color.White
                    )
                )
            }
        }

        // Reset Settings button
        Button(
            onClick = {
                showSessionDuration = true
                showActivePromo = true
                notifyFreeTime = false
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = AppRed),
            shape = RoundedCornerShape(28.dp)
        ) {
            Text(
                text = "Сбросить настройки",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
