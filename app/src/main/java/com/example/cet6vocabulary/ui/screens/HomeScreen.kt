package com.example.cet6vocabulary.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cet6vocabulary.navigation.Screen

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "CET6 Vocabulary",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 32.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Button(
                onClick = {
                    navController.navigate(Screen.Learning.route)
                },
                modifier = Modifier.size(200.dp, 60.dp)
            ) {
                Text(text = "Start Learning", fontSize = 18.sp)
            }

            Button(
                onClick = {
                    navController.navigate(Screen.Review.route)
                },
                modifier = Modifier.size(200.dp, 60.dp)
            ) {
                Text(text = "Review Words", fontSize = 18.sp)
            }

            Button(
                onClick = {
                    navController.navigate(Screen.VocabularyList.route)
                },
                modifier = Modifier.size(200.dp, 60.dp)
            ) {
                Text(text = "Vocabulary List", fontSize = 18.sp)
            }

            Button(
                onClick = {
                    navController.navigate(Screen.Settings.route)
                },
                modifier = Modifier.size(200.dp, 60.dp)
            ) {
                Text(text = "Settings", fontSize = 18.sp)
            }

            Button(
                onClick = {
                    navController.navigate(Screen.Statistics.route)
                },
                modifier = Modifier.size(200.dp, 60.dp)
            ) {
                Text(text = "Statistics", fontSize = 18.sp)
            }
        }
    }
}
