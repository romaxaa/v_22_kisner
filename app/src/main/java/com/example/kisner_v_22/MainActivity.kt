package com.example.kisner_v_22

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.kisner_v_22.ui.theme.Kisner_v_22Theme

enum class AppScreen {
    Auth, Profile, Settings, Map
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kisner_v_22Theme {
                var currentScreen by remember { mutableStateOf(AppScreen.Auth) }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        when (currentScreen) {
                            AppScreen.Auth -> AuthScreen(
                                onNavigateToProfile = { currentScreen = AppScreen.Profile }
                            )
                            AppScreen.Profile -> ProfileScreen(
                                onNavigateToSettings = { currentScreen = AppScreen.Settings },
                                onNavigateToMap = { currentScreen = AppScreen.Map },
                                onLogout = { currentScreen = AppScreen.Auth }
                            )
                            AppScreen.Settings -> SettingsScreen(
                                onNavigateBack = { currentScreen = AppScreen.Profile },
                                onLogout = { currentScreen = AppScreen.Auth }
                            )
                            AppScreen.Map -> MapScreen(
                                onNavigateBack = { currentScreen = AppScreen.Profile }
                            )
                        }
                    }
                }
            }
        }
    }
}