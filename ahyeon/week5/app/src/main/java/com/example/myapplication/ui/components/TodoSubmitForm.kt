package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Row

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoSubmitForm(
    value: String,
    onValueChange: (String)->Unit,
    onClickAddTodo: ()->Unit
) {
    Row {
       TextField(value = value, onValueChange = onValueChange)
        Button(onClick =  onClickAddTodo) {
            Text(text = "추가")
        }
    }
}