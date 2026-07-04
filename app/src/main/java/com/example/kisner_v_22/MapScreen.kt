package com.example.kisner_v_22

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kisner_v_22.ui.theme.AppRed


@Composable
fun MapScreen(
    onNavigateBack: () -> Unit
) {
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

        // Back button
        IconButton(
            onClick = onNavigateBack,
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.TopStart)
                .size(48.dp)
                .background(Color.White, shape = CircleShape)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = AppRed
            )
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
    }
}

