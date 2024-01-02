package com.example.constraint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.constraint.ui.theme.ConstraintTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConstraintLayoutEx()
                }
            }
        }
    }
}

/*
*
*   기본 ConstraintLayout 사용
*
* */
//@Composable
//fun ConstraintLayoutEx() {
//    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
//        //복수 아이디 지정
//        //단일 아이디일 때는 val redBox = createRef() 사용
//        val (redBox, magetaBox, greenBox, yellowBox) = createRefs()
//
//        Box(
//            modifier = Modifier
//                .size(40.dp)
//                .background(Color.Red)
//                .constrainAs(redBox){
//                    //박스의 정보를 이용해 linkTo()를 사용하는 방법
//                    bottom.linkTo(parent.bottom, margin = 8.dp)
//                    end.linkTo(parent.end, margin = 4.dp)
//                }
//        )
//        Box(
//            modifier = Modifier
//                .size(40.dp)
//                .background(Color.Magenta)
//                .constrainAs(magetaBox){
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                    //위 방법은 아래의 코드와 같다. 아래 코드일 때 마진 예제 포함
//                    //linkTo(parent.start, parent.end, startMargin = 4.dp, endMargin = 4.dp)
//                }
//        )
//        Box(
//            modifier = Modifier
//                .size(40.dp)
//                .background(Color.Green)
//                .constrainAs(greenBox){
//                    linkTo(parent.start, parent.end)
//                    linkTo(parent.top, parent.bottom)
//                    //아래 코드는 위 코드와 같다.
////                    centerHorizontallyTo(parent)
////                    centerVerticallyTo(parent)
//                }
//        )
//        Box(
//            modifier = Modifier
//                .size(40.dp)
//                .background(Color.Yellow)
//                .constrainAs(yellowBox){
//                    start.linkTo(magetaBox.end)
//                    top.linkTo(magetaBox.bottom)
//                }
//        )
//    }
//}


/*
*
*
* ConstraintSet 활용
*
* */
//@Composable
//fun ConstraintLayoutEx() {
//    val constraintSet = ConstraintSet {
//        val redBox = createRefFor("redBox")
//        val magentaBox = createRefFor("magentaBox")
//        val greenBox = createRefFor("greenBox")
//        val yellowBox = createRefFor("yellowBox")
//
//        constrain(redBox) {
//            bottom.linkTo(parent.bottom, margin = 8.dp)
//            end.linkTo(parent.end, margin = 4.dp)
//        }
//        constrain(magentaBox) {
//            start.linkTo(parent.start)
//            end.linkTo(parent.end)
//        }
//        constrain(greenBox) {
//            centerTo(parent)
//        }
//        constrain(yellowBox) {
//            start.linkTo(magentaBox.end)
//            top.linkTo(magentaBox.bottom)
//        }
//    }
//
//    ConstraintLayout(constraintSet, modifier = Modifier.fillMaxSize()) {
//        Box(
//            modifier = Modifier
//                .size(40.dp)
//                .background(Color.Red)
//                .layoutId("redBox")
//        )
//        Box(
//            modifier = Modifier
//                .size(40.dp)
//                .background(Color.Magenta)
//                .layoutId("magentaBox")
//        )
//        Box(
//            modifier = Modifier
//                .size(40.dp)
//                .background(Color.Green)
//                .layoutId("greenBox")
//        )
//        Box(
//            modifier = Modifier
//                .size(40.dp)
//                .background(Color.Yellow)
//                .layoutId("yellowBox")
//        )
//    }
//}

@Composable
fun ConstraintLayoutEx() {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (redBox, yellowBox, magentaBox, text) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox){

                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {

                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox){

                }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConstraintTheme {
        ConstraintLayoutEx()
    }
}