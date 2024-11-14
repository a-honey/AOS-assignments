package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.UserInfo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInfoForm(
    userInfo: UserInfo,
    onUserInfoChange: (UserInfo) -> Unit,
    onShowCard: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        ImageBox(modifier = Modifier
            .weight(1f)
            .fillMaxHeight())
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = userInfo.name,
            onValueChange = { onUserInfoChange(userInfo.copy(name = it)) },
            label = { Text("이름을 입력해주세요") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = userInfo.age,
            onValueChange = { onUserInfoChange(userInfo.copy(age = it)) },
            label = { Text("나이를 입력해주세요") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = userInfo.school,
            onValueChange = { onUserInfoChange(userInfo.copy(school = it)) },
            label = { Text("학교를 입력해주세요") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = userInfo.nickname,
            onValueChange = { onUserInfoChange(userInfo.copy(nickname = it)) },
            label = { Text("별명을 입력해주세요") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = userInfo.mbti,
            onValueChange = { onUserInfoChange(userInfo.copy(mbti = it)) },
            label = { Text("MBTI를 입력해주세요") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = { onShowCard() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("정보 보기")
        }
    }
}