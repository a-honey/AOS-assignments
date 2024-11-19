package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.components.TodoSubmitForm

data class TodoItemData(
    var isChecked: Boolean,
    val value: String
)

@Composable
fun ComposeTodo() {
    var currentTodoFieldValue by remember {
        mutableStateOf("")
    }
    var currentTodoListValue by remember {
        mutableStateOf(listOf<TodoItemData>())
    }

    Column {
        Text("Todo List with Jetpack Compose")
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(){
            items(currentTodoListValue.size){
                index ->
                TodoItem(
                    isChecked = currentTodoListValue[index].isChecked,
                    onToggleIsChange = {
                        currentTodoListValue = currentTodoListValue.toMutableList().apply{
                            this[index] = this[index].copy(isChecked = !currentTodoListValue[index].isChecked)
                        }},
                    text = currentTodoListValue[index].value,
                    onDelete = {
                        currentTodoListValue = currentTodoListValue.toMutableList().apply{
                            removeAt(index)
                        }
                    }
                )
            }
        }
        TodoSubmitForm(
            value=currentTodoFieldValue,
            onValueChange = {currentTodoFieldValue=it},
            onClickAddTodo = {
                currentTodoListValue = currentTodoListValue + TodoItemData(
                    isChecked = false,
                    value = currentTodoFieldValue
                )
                currentTodoFieldValue = ""
            }
        )
    }
}

@Composable
fun TodoItem(
    isChecked: Boolean,
    onToggleIsChange: () -> Unit,
    text: String,
    onDelete: ()->Unit,
    onEdit:(()->Unit)? = null
){
    Row {
        Button(onClick = onToggleIsChange, modifier = Modifier){
            Text(text =  text,
                style = MaterialTheme.typography.bodyMedium.copy(
                    textDecoration = if (isChecked) TextDecoration.LineThrough else TextDecoration.None
                ))
        }
        onEdit?.let{
            Button(onClick = it) {
                Row {
                    Text(text = "수정")
                }
            }
        }
        Button(onClick = onDelete) {
            Row {
                Text(text = "삭제")
            }
        }
    }
}