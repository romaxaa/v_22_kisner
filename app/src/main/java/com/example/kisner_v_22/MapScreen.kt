package com.example.kisner_v_22

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kisner_v_22.ui.theme.AppRed

@Composable
fun MapScreen(
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    val address = "Моховая улица, 9с9"
    val latitude = 55.753218
    val longitude = 37.610427

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Map background image
        Image(
            painter = painterResource(id = R.drawable.map_background),
            contentDescription = "Map Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Custom Title overlay at the top (Mockup: Системное приложение - Карта)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .align(Alignment.TopStart)
        ) {
            Text(
                text = "Системное приложение - Карта",
                color = Color.DarkGray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .background(Color.White.copy(alpha = 0.8f), shape = RoundedCornerShape(4.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Back button
            IconButton(
                onClick = onNavigateBack,
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.White, shape = CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = AppRed
                )
            }
        }

        // Location marker pin layout in the center
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-40).dp)
        ) {
            // Pin Icon (We'll use a custom box that looks like a pin with home inside)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(AppRed, shape = RoundedCornerShape(25.dp, 25.dp, 25.dp, 0.dp))
                        .align(Alignment.CenterHorizontally)
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    // Home/building simple icon inside pin
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White, shape = RoundedCornerShape(4.dp))
                    )
                }
            }
        }

        // Overlay address card at the bottom
        Card(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 48.dp)
                .clickable {
                    // Intent to open Google Maps or any other map provider
                    val uri = Uri.parse("geo:$latitude,$longitude?q=$latitude,$longitude($address)")
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    context.startActivity(intent)
                },
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = address,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Нажмите, чтобы открыть в Google / Яндекс Картах",
                    fontSize = 12.sp,
                    color = AppRed,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
