package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

    val rotationState = animateFloatAsState(
        targetValue = if (showCard.value) 360f else 0f,
        animationSpec = tween(durationMillis = 1200),
        label = "Card Rotation"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color.White)
                .graphicsLayer {
                    rotationY = rotationState.value
                    cameraDistance = 12f * density
                },
            shape = RoundedCornerShape(8.dp)
        ) {
            Box(modifier = Modifier.padding(16.dp)) {
                if (rotationState.value <= 90f) {
                    UserInfoForm(
                        userInfo = userInfo.value,
                        onUserInfoChange = { userInfo.value = it },
                        onShowCard = { showCard.value = true }
                    )
                } else {
                    UserInfoCard(userInfo.value)
                }
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