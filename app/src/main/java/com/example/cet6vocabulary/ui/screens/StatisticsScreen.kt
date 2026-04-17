package com.example.cet6vocabulary.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
import com.example.cet6vocabulary.viewmodel.LearningRecordViewModel
import androidx.compose.runtime.collectAsState

@Composable
fun StatisticsScreen(navController: NavHostController, viewModel: LearningRecordViewModel) {
    val totalWordsLearned by viewModel.totalWordsLearned.collectAsState()
    val averageMasteryRate by viewModel.averageMasteryRate.collectAsState()
    val learningRecords by viewModel.learningRecords.collectAsState()

    var timeRange by remember { mutableStateOf(TimeRange.DAILY) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Learning Statistics",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 32.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = {
                    timeRange = TimeRange.DAILY
                    viewModel.calculateTodayStats()
                },
                modifier = Modifier.size(100.dp, 40.dp)
            ) {
                Text(text = "Daily")
            }
            Button(
                onClick = {
                    timeRange = TimeRange.WEEKLY
                    viewModel.calculateWeeklyStats()
                },
                modifier = Modifier.size(100.dp, 40.dp)
            ) {
                Text(text = "Weekly")
            }
            Button(
                onClick = {
                    timeRange = TimeRange.MONTHLY
                    viewModel.calculateMonthlyStats()
                },
                modifier = Modifier.size(100.dp, 40.dp)
            ) {
                Text(text = "Monthly")
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "${timeRange.name} Statistics",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Words Learned: $totalWordsLearned",
                    fontSize = 16.sp
                )
                Text(
                    text = "Mastery Rate: ${String.format("%.2f", averageMasteryRate * 100)}%",
                    fontSize = 16.sp
                )
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .size(300.dp)
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Learning Progress Chart",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "(Chart implementation would go here)",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }

        Button(
            onClick = {
                navController.navigateUp()
            },
            modifier = Modifier.size(150.dp, 48.dp)
        ) {
            Text(text = "Back to Home")
        }
    }
}

enum class TimeRange {
    DAILY,
    WEEKLY,
    MONTHLY
}
