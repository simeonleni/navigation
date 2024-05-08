package com.example.navigation.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(navController: NavController) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = navController.currentBackStackEntry?.destination?.route ?: "Nonexistent",
                    style = TextStyle(fontSize = 14.sp),
                    fontWeight = FontWeight.Medium
                )
            }, Modifier.background(Color.Transparent)
        )
    }) { padding ->
        val numbersList = (1..40).toList()
        val listState = rememberLazyListState()

        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = padding.calculateTopPadding()),
                contentPadding = PaddingValues(20.dp, 0.dp)
            ) {
                items(numbersList) { number ->
                    Text(
                        text = number.toString(), modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun UserScreenPreview(){
//    UserScreen(navController)
//}