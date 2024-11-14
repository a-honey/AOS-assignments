package com.example.a4weeks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a4weeks.ui.theme._4WeeksTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _4WeeksTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Box를 사용하여 MainCard를 화면의 중앙에 배치
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        MainCard() // MainCard가 화면 중앙에 위치함
                    }
                }
            }
        }
    }
}

@Composable
fun MainCard(modifier: Modifier = Modifier) {
    var clicks by remember { mutableStateOf(true) }
    val rotationAngle by animateFloatAsState(targetValue = if (clicks) 0f else 180f)

    Box(
        modifier = modifier
            .graphicsLayer {
                rotationY = rotationAngle // 회전 애니메이션
                cameraDistance = 12f * density // 깊이감 설정
            }
            .background(
                color = Color.LightGray,
                shape = RoundedCornerShape(20.dp)
            )
            .shadow(
                elevation = 0.5.dp,
                shape = RoundedCornerShape(20.dp),
                ambientColor = Color.Gray.copy(alpha = 0.3f),
                spotColor = Color.Black.copy(alpha = 0.3f)
            )
            .fillMaxHeight(0.95f)
            .fillMaxWidth(0.9f),
        contentAlignment = Alignment.Center
    ) {
        if (rotationAngle <= 90f) {
            Box(
                modifier
                    .clickable { clicks = !clicks }
                    .fillMaxSize()) {
                Text(
                    text = "클릭하여 자세히 보기.",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        } else {
            BackOfCard()
        }
    }
}

@Composable
fun BackOfCard(modifier: Modifier = Modifier) {

    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var school by remember { mutableStateOf("") }
    var alias by remember { mutableStateOf("") }
    var mbti by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.cat),
            contentDescription = "Cat Image",
            modifier = modifier
                .fillMaxWidth()
                .weight(4f)
                .clip(RoundedCornerShape(20.dp))
                .padding(10.dp),
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = modifier
                .weight(5f)
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            InputFormatFiled(
                modifier = modifier.weight(1.2F),
                value = name,
                filed_name = "name",
                onChangeFiled = { new_text -> name = new_text })
            InputFormatFiled(
                modifier = modifier.weight(1.2F),
                filed_name = "age",
                value = age,
                onChangeFiled = { new_text -> age = new_text })
            InputFormatFiled(
                modifier = modifier.weight(1.2F),
                value = school,
                filed_name = "school",
                onChangeFiled = { new_text -> school = new_text })
            InputFormatFiled(
                modifier = modifier.weight(1.2F),
                value = alias,
                filed_name = "alias",
                onChangeFiled = { new_text -> alias = new_text })
            InputFormatFiled(
                modifier = modifier.weight(1.2F),
                filed_name = "mbti",
                value = mbti,
                onChangeFiled = { new_text -> mbti = new_text })
        }
        BackOfCardButton(modifier = modifier.weight(1f).wrapContentSize())
    }
}


@OptIn(ExperimentalMaterial3Api::class) // 실험적 API 사용
@Composable
fun InputFormatFiled(
    value: String,
    filed_name: String,
    onChangeFiled: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onChangeFiled,
        label = { Text("${filed_name}를 입력하세요") },
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp)
    )
}

@Composable
fun BackOfCardButton(modifier: Modifier = Modifier) {
    Box (
        contentAlignment = Alignment.Center,
        modifier = modifier
    ){
        Button(
            shape = RoundedCornerShape(50.dp),
            modifier = modifier
                .wrapContentSize()
                .padding(10.dp),
            onClick = {

            }
        ) {
            Text(text = "저장")
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _4WeeksTheme {
        MainCard()
    }
}