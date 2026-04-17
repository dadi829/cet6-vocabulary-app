package com.example.cet6vocabulary.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import com.example.cet6vocabulary.data.entities.Word
import com.example.cet6vocabulary.viewmodel.WordViewModel
import androidx.compose.runtime.collectAsState

@Composable
fun VocabularyListScreen(navController: NavHostController, viewModel: WordViewModel) {
    val vocabularyList by viewModel.vocabularyList.collectAsState()
    val searchResults by viewModel.searchResults.collectAsState()
    var searchQuery by remember { mutableStateOf("") }
    var showSearchResults by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Vocabulary List",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        TextField(
            value = searchQuery,
            onValueChange = {
                searchQuery = it
                if (it.isNotEmpty()) {
                    viewModel.searchWords(it)
                    showSearchResults = true
                } else {
                    showSearchResults = false
                }
            },
            placeholder = { Text(text = "Search words...") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        if (showSearchResults && searchResults.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(searchResults) {
                    WordItem(word = it, viewModel = viewModel)
                }
            }
        } else if (vocabularyList.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(vocabularyList) {
                    WordItem(word = it, viewModel = viewModel)
                }
            }
        } else {
            Text(
                text = "Your vocabulary list is empty!",
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 32.dp)
            )
        }
    }
}

@Composable
fun WordItem(word: Word, viewModel: WordViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = word.word,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${word.phonetic} - ${word.partOfSpeech}",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = word.definition,
                fontSize = 16.sp
            )
            Button(
                onClick = {
                    viewModel.removeFromVocabularyList(word)
                },
                modifier = Modifier.size(120.dp, 40.dp)
            ) {
                Text(text = "Remove")
            }
        }
    }
}
