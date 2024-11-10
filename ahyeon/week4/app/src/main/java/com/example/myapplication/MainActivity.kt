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
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.components.ImageBox
import com.example.myapplication.ui.components.UserInfoCard
import com.example.myapplication.ui.components.UserInfoForm
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

data class UserInfo(
    var name: String = "",
    var age: String = "",
    var school: String = "",
    var nickname: String = "",
    var mbti: String = ""
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FullScreenContent() {
    val userInfo = remember { mutableStateOf(UserInfo()) }
    val showCard = remember { mutableStateOf(false) }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)){
        Column(modifier = Modifier.fillMaxSize()) {
            ImageBox(modifier = Modifier
                .weight(1f)
                .fillMaxHeight())
            Spacer(modifier = Modifier.height(16.dp))
                if (showCard.value) {
                    UserInfoCard(userInfo.value)
                } else {
                    UserInfoForm(
                        userInfo = userInfo.value,
                        onUserInfoChange = { userInfo.value = it },
                        onShowCard = { showCard.value = true }
                    )
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