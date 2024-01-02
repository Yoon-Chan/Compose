package com.example.button

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorLong
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.button.ui.theme.ButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android", onClick = {
                        Toast.makeText(this, "Send clicked", Toast.LENGTH_SHORT).show()
                    })
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, onClick : () -> Unit) {

    //버튼 예제
    //클릭 시 토스트 출력
//    Button(
//        onClick = { onClick },
//        shape = ButtonDefaults.outlinedShape,
//        colors = ButtonDefaults.buttonColors(Color.Red),
//        modifier = Modifier
//            .wrapContentSize()
//            .wrapContentHeight(),
//        elevation = ButtonDefaults.elevatedButtonElevation(1.dp),
//        border = BorderStroke(3.dp, color = Color.Black),
//    ){
//        Text(text = name)
//    }

    //아이콘 추가
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(Color.Red),
        modifier = Modifier
            .wrapContentSize()
            .wrapContentHeight(),
        elevation = ButtonDefaults.elevatedButtonElevation(1.dp),
        border = BorderStroke(3.dp, color = Color.Black),
    ){
        Icon(painter = painterResource(id = R.drawable.baseline_send_24 ), contentDescription = "보내기 버튼" )
        Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
        Text(text = name)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ButtonTheme {
        Greeting("Android", onClick = {

        })
    }
}