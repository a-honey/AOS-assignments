package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.components.ImageBox
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FullScreenContent()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FullScreenContent() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)){
        Column(modifier = Modifier.fillMaxSize()) {
            ImageBox(modifier = Modifier
                .weight(1f)
                .fillMaxHeight())
            Spacer(modifier = Modifier.height(16.dp))
            Column(modifier = Modifier.fillMaxWidth()){
                TextField(
                    value = "",
                    onValueChange = {},
                    label={Text("이름을 입력해주세요")},
                    modifier = Modifier.fillMaxWidth())
                TextField(
                    value = "",
                    onValueChange = {},
                    label={Text("나이를 입력해주세요")},
                    modifier = Modifier.fillMaxWidth())
                TextField(
                    value = "",
                    onValueChange = {},
                    label={Text("학교를 입력해주세요")},
                    modifier = Modifier.fillMaxWidth())
                TextField(
                    value = "",
                    onValueChange = {},
                    label={Text("별명을 입력해주세요")},
                    modifier = Modifier.fillMaxWidth())
                TextField(
                    value = "",
                    onValueChange = {},
                    label={Text("MBTI를 입력해주세요")},
                    modifier = Modifier.fillMaxWidth())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        FullScreenContent()
    }
}