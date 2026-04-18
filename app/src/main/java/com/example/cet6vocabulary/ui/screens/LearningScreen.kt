package com.example.cet6vocabulary.ui.screens
// 解决布局和Modifier相关错误
// 解决Button、Card等组件错误
// 解决对齐和排列错误
// 解决动画和图形错误
// 解决基础Composable错误
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cet6vocabulary.data.entities.Word
import com.example.cet6vocabulary.ui.components.WordCard
import com.example.cet6vocabulary.viewmodel.WordViewModel
import androidx.compose.runtime.collectAsState

@Composable
fun LearningScreen(navController: NavHostController, viewModel: WordViewModel) {
    val reviewWords by viewModel.reviewWords.collectAsState()
    var currentWordIndex by remember { mutableStateOf(0) }
    var offsetX by remember { mutableStateOf(0f) }
    var isCardVisible by remember { mutableStateOf(true) }

    // 从数据库获取当前单词
    val currentWord = if (reviewWords.isNotEmpty()) {
        reviewWords[currentWordIndex % reviewWords.size]
    } else {
        Word(
            word = "No words available",
            phonetic = "",
            partOfSpeech = "",
            definition = "Please wait for vocabulary to load",
            example = ""
        )
    }

    val scale by animateFloatAsState(
        targetValue = if (isCardVisible) 1f else 0.8f,
        animationSpec = tween(durationMillis = 300)
    )

    val rotation by animateFloatAsState(
        targetValue = offsetX * 0.1f,
        animationSpec = tween(durationMillis = 300)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Learn New Words (${reviewWords.size} total)",
            fontSize = 24.sp,
            fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        AnimatedVisibility(visible = isCardVisible) {
            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .scale(scale)
                    .graphicsLayer(rotationZ = rotation),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                WordCard(word = currentWord)
            }
        }

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
                    currentWordIndex++
                    isCardVisible = true
                },
                modifier = Modifier.size(120.dp, 48.dp)
            ) {
                Text(text = "Mastered")
            }
            Button(
                onClick = {
                    viewModel.markWordAsNotMastered(currentWord)
                    currentWordIndex++
                    isCardVisible = true
                },
                modifier = Modifier.size(120.dp, 48.dp)
            ) {
                Text(text = "Not Known")
            }
        }
    }
}
