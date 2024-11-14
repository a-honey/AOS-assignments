package com.example.week5_assignment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TabLayout()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabLayout() {
    val tabs = listOf(Icons.Filled.Home, Icons.AutoMirrored.Filled.List, Icons.Filled.AccountCircle)
    val pagerState = rememberPagerState(0, 0f) { tabs.size }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        bottomBar = {
            TabRow(
                selectedTabIndex = pagerState.currentPage,
                containerColor = Color(230, 220, 255, 255),
            ) {
                tabs.forEachIndexed { index, icon ->
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                        icon = { Icon(imageVector = icon, contentDescription = "") }
                    )
                }
            }
        }
    ) {
        HorizontalPager(pagerState) { page ->
            when (page) {
                0 -> StartLayout()
                1 -> TodoLayout()
                2 -> UserProfile()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TabLayout()
}