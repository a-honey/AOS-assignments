package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.UserInfo

@Composable
fun UserInfoCard(userInfo: UserInfo) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            ImageBox(modifier = Modifier
                .weight(1f)
                .fillMaxHeight())
            Spacer(modifier = Modifier.height(16.dp))
            Column(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
            ) {
                Text(text = "이름: ${userInfo.name}")
                Text(text = "나이: ${userInfo.age}")
                Text(text = "학교: ${userInfo.school}")
                Text(text = "별명: ${userInfo.nickname}")
                Text(text = "MBTI: ${userInfo.mbti}")
            }
        }
    }
}
