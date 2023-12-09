package com.example.todoforexam.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todoforexam.NoteViewModel

@Composable
fun NoteListScreen(viewModel: NoteViewModel, navController: NavController) {

    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                text = "Заметки",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            viewModel.notes.forEach { note ->
                Box(
                    modifier = Modifier
                        .size(400.dp, 160.dp)
                        .padding(20.dp)
                        .border(1.dp, Color.LightGray, shape = RoundedCornerShape(6.dp))
                )
                {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                    )
                    {
                        Text(
                            text = note.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = note.text,
                            fontSize = 14.sp
                        )
                        Button(
                            modifier = Modifier
                                .size(110.dp, 60.dp)
                                .padding(start = 0.dp, top = 20.dp, end = 0.dp, bottom = 0.dp),
                            onClick = { viewModel.removeNote(note) }
                        ) {
                            Text("Удалить")
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f)) // Заполняем оставшуюся часть экрана
            Button(
                onClick = { navController.navigate("/add-note") },
            ) {
                Text("Добавить заметку")
            }
        }
    }
}
    

