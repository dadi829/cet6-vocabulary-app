package com.example.cet6vocabulary.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cet6vocabulary.ui.screens.SplashScreen
import com.example.cet6vocabulary.ui.screens.HomeScreen
import com.example.cet6vocabulary.ui.screens.LearningScreen
import com.example.cet6vocabulary.ui.screens.ReviewScreen
import com.example.cet6vocabulary.ui.screens.VocabularyListScreen
import com.example.cet6vocabulary.ui.screens.SettingsScreen
import com.example.cet6vocabulary.ui.screens.StatisticsScreen
import com.example.cet6vocabulary.viewmodel.AppViewModelProvider
import com.example.cet6vocabulary.viewmodel.WordViewModel
import com.example.cet6vocabulary.viewmodel.LearningRecordViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.Learning.route) {
            val context = LocalContext.current
            val viewModelProvider = AppViewModelProvider(context)
            val wordViewModel = ViewModelProvider(it, viewModelProvider).get(WordViewModel::class.java)
            LearningScreen(navController = navController, viewModel = wordViewModel)
        }
        composable(Screen.Review.route) {
            val context = LocalContext.current
            val viewModelProvider = AppViewModelProvider(context)
            val wordViewModel = ViewModelProvider(it, viewModelProvider).get(WordViewModel::class.java)
            ReviewScreen(navController = navController, viewModel = wordViewModel)
        }
        composable(Screen.VocabularyList.route) {
            val context = LocalContext.current
            val viewModelProvider = AppViewModelProvider(context)
            val wordViewModel = ViewModelProvider(it, viewModelProvider).get(WordViewModel::class.java)
            VocabularyListScreen(navController = navController, viewModel = wordViewModel)
        }
        composable(Screen.Settings.route) {
            SettingsScreen(navController = navController)
        }
        composable(Screen.Statistics.route) {
            val context = LocalContext.current
            val viewModelProvider = AppViewModelProvider(context)
            val learningRecordViewModel = ViewModelProvider(it, viewModelProvider).get(LearningRecordViewModel::class.java)
            StatisticsScreen(navController = navController, viewModel = learningRecordViewModel)
        }
    }
}

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object Learning : Screen("learning")
    object Review : Screen("review")
    object VocabularyList : Screen("vocabulary_list")
    object Settings : Screen("settings")
    object Statistics : Screen("statistics")
}
