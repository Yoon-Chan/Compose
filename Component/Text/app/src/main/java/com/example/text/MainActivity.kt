package com.example.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.text.ui.theme.TextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextTheme {
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
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )

    //색상을 지정하기 위해 color 파라미터에 Red 색깔로 변경
//    Text(
//        color = Color(0xffff0000),
//        text = "Hello $name!",
//        modifier = modifier
//    )

    //fontSize : Text 크기를 변경하기
//    Text(
//        color = Color(0xffff0000),
//        text = "Hello $name!",
//        modifier = modifier,
//        fontSize = 30.sp
//    )

    //fontWeight와 fontFamily를 지정하기
//    Text(
//        color = Color(0xffff0000),
//        text = "Hello $name!",
//        modifier = modifier,
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive
//    )

    //letterSpacing
//    Text(
//        color = Color(0xffff0000),
//        text = "Hello $name!",
//        modifier = modifier,
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive,
//        letterSpacing = 50.sp
//    )

    //maxLines
//    Text(
//        color = Color(0xffff0000),
//        text = "Hello $name!\nHello $name!\nHello $name!",
//        modifier = modifier,
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive,
//        letterSpacing = 2.sp,
//        maxLines = 2
//    )

    //textDecoration
    Text(
        color = Color(0xffff0000),
        text = "Hello $name!",
        modifier = modifier,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        letterSpacing = 2.sp,
        maxLines = 2,
        textDecoration = TextDecoration.LineThrough,
        textAlign = TextAlign.End
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextTheme {
        Greeting("Android")
    }
}