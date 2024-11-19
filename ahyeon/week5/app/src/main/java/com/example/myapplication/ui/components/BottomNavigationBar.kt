package com.example.myapplication.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BottomNavigationBar(){
    Button(onClick = { /* TODO: Navigate */ }) {
        Icon(
            imageVector = Icons.Filled.Home,
            contentDescription = "Go Home"
        )
        Text(text = "Home")
    }
    Button(onClick = { /* TODO: Navigate */ }) {
        Icon(
            imageVector = Icons.Filled.Edit,
            contentDescription = "Go Todo Screen with Jetpack Compose"
        )
        Text(text = "Jetpack")
    }
    Button(onClick = { /* TODO: Navigate */ }) {
        Icon(
            imageVector = Icons.Filled.Favorite,
            contentDescription = "Go Todo Screen with XML"
        )
        Text(text = "Xml")
    }
}