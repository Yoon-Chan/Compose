package com.example.modifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.modifier.ui.theme.ModifierTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModifierTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // Modifier.fillMaxSize()
//    Button(onClick = {  },
//        modifier = modifier.then(Modifier.fillMaxSize())
//        ) {
//        Text(text = "버튼")
//    }

    //height와 width 설정
    Button(
        onClick = { },
        modifier = modifier.then(
            Modifier.size(100.dp, 50.dp))
    ) {
        Text(text = "버튼")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ModifierTheme {
        Greeting("Android")
    }
}