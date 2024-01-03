package com.example.canvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.canvas.ui.theme.CanvasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanvasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CanvasEx()
                }
            }
        }
    }
}

@Composable
fun CanvasEx() {
    Canvas(modifier = Modifier.size(20.dp)){
        //drawLine(Color.Red, Offset(30f, 50f), Offset(10f, 10f))
        //drawCircle(Color.Yellow, 10f, Offset(15f, 40f))
        //drawRect(Color.Magenta, Offset(30f,30f), Size(10f,10f))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CanvasTheme {
        CanvasEx()
    }
}