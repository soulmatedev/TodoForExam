package com.example.todoforexam.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.todoforexam.NoteViewModel

@Composable
fun NoteListScreen(viewModel: NoteViewModel, navController: NavController) {
    Column {
        Button(onClick = { navController.navigate("/add-note") }) {
            Text("Добавить")
        }

        LazyColumn {
            items(viewModel.notes) { note ->
                Text(text = note.title)
                Text(text = note.text)
                Button(onClick = { viewModel.removeNote(note) }) {
                    Text("Удалить")
                }
            }
        }
    }
}