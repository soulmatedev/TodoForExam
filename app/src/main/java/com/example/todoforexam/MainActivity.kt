package com.example.todoforexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoforexam.ui.screens.AddNoteScreen
import com.example.todoforexam.ui.screens.NoteListScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<NoteViewModel>()
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "/notes") {
                composable("/notes") { NoteListScreen(viewModel, navController) }
                composable("/add-note") { AddNoteScreen(viewModel, navController) }
            }
        }
    }
}
