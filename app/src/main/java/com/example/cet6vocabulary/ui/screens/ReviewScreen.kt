package com.example.cet6vocabulary.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cet6vocabulary.ui.components.WordCard
import com.example.cet6vocabulary.viewmodel.WordViewModel

@Composable
fun ReviewScreen(navController: NavHostController, viewModel: WordViewModel) {
    val reviewWords by viewModel.reviewWords.collectAsState()
    var currentIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Review Words",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        if (reviewWords.isNotEmpty() && currentIndex < reviewWords.size) {
            val currentWord = reviewWords[currentIndex]
            WordCard(word = currentWord)

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = {
                        viewModel.markWordAsMastered(currentWord)
                        currentIndex++
                    },
                    modifier = Modifier.size(120.dp, 48.dp)
                ) {
                    Text(text = "Mastered")
                }
                Button(
                    onClick = {
                        viewModel.markWordAsNotMastered(currentWord)
                        currentIndex++
                    },
                    modifier = Modifier.size(120.dp, 48.dp)
                ) {
                    Text(text = "Not Known")
                }
            }
        } else {
            Text(
                text = "No words to review today!",
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 32.dp)
            )
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
}
