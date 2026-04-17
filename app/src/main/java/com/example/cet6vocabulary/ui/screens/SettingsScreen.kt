package com.example.cet6vocabulary.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun SettingsScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Settings",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 32.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            SettingItem(
                title = "Dark Mode",
                description = "Enable dark mode for the app"
            )

            SettingItem(
                title = "Auto Play Audio",
                description = "Automatically play word pronunciation"
            )

            SettingItem(
                title = "Daily Reminder",
                description = "Receive daily reminders to study"
            )

            Button(
                onClick = {
                    // Export vocabulary list
                },
                modifier = Modifier.size(200.dp, 48.dp)
            ) {
                Text(text = "Export Vocabulary")
            }

            Button(
                onClick = {
                    // Clear all data
                },
                modifier = Modifier.size(200.dp, 48.dp)
            ) {
                Text(text = "Clear All Data")
            }

            Button(
                onClick = {
                    navController.navigateUp()
                },
                modifier = Modifier.size(200.dp, 48.dp)
            ) {
                Text(text = "Back to Home")
            }
        }
    }
}

@Composable
fun SettingItem(title: String, description: String) {
    var isEnabled by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.secondary
        )
        Switch(
            checked = isEnabled,
            onCheckedChange = { isEnabled = it }
        )
    }
}
