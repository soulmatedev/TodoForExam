package com.example.todoforexam.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.todoforexam.NoteViewModel

@Composable
fun AddNoteScreen(viewModel: NoteViewModel, navController: NavController) {
    var title by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }

    Column {
        TextField(value = title, onValueChange = { title = it })
        TextField(value = text, onValueChange = { text = it })

        Button(onClick = {
            viewModel.addNote(title, text)
            navController.navigateUp()
        }) {
            Text("Добавить")
        }
    }
}