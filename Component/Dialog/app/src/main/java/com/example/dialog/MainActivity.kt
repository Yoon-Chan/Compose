package com.example.dialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dialog.ui.theme.DialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DialogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DialogEx()
                }
            }
        }
    }
}

@Composable
fun DialogEx() {
    var openDialog by remember {
        mutableStateOf(false)
    }
    var counter by remember {
        mutableStateOf(0)
    }

    Column {
        Button(onClick = { openDialog = true }) {
            Text(text = "다이얼로그 열기")
        }
        Text(text = "카운터: $counter")
    }

    if (openDialog) {
        AlertDialog(
            onDismissRequest = {
                openDialog = false
            }, confirmButton = {
                Button(onClick = {
                    counter++
                    openDialog = false
                }) {
                    Text(text = "더하기")
                }
            }, dismissButton = {
                Button(onClick = { openDialog = false }) {
                    Text(text = "종료")
                }
            }, title = {
                Text(text = "더하기")
            }, text = {
                Text(text = "더하기 버튼을 누르면 카운터가 추가됩니다.")
            },
            tonalElevation = 100.dp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DialogTheme {
        DialogEx()
    }
}