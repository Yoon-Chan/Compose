package com.example.statestatehoisting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.statestatehoisting.ui.theme.StateStateHoistingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateStateHoistingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StateStateHoisting()
                }
            }
        }
    }
}

//@Composable
//fun StateStateHoisting() {
//    var pyeong by rememberSaveable {
//        mutableStateOf("23")
//    }
//    var squaremeter by rememberSaveable {
//        mutableStateOf((23 * 3.306).toString())
//    }
//
//    Column(modifier = Modifier.padding(16.dp)) {
//        OutlinedTextField(
//            value = pyeong,
//            onValueChange = {
//                if (it.isBlank()) {
//                    pyeong = ""
//                    squaremeter = ""
//                    return@OutlinedTextField
//                }
//                val numericValue = it.toFloatOrNull() ?: return@OutlinedTextField
//                pyeong = it
//                squaremeter = (numericValue * 3.306).toString()
//            },
//            label = { Text(text = "평") }
//        )
//
//        OutlinedTextField(
//            value = squaremeter,
//            onValueChange = {
//
//            },
//            label = { Text(text = "제곱미터") }
//        )
//    }
//}


@Composable
fun StateStateHoisting() {
    var pyeong by rememberSaveable {
        mutableStateOf("23")
    }
    var squaremeter by rememberSaveable {
        mutableStateOf((23 * 3.306).toString())
    }

    PyeongToSquareMeterStateless(pyeong = pyeong, squareMeter = squaremeter) {
        if (it.isBlank()) {
            pyeong = ""
            squaremeter = ""
            return@PyeongToSquareMeterStateless
        }
        val numericValue = it.toFloatOrNull() ?: return@PyeongToSquareMeterStateless
        pyeong = it
        squaremeter = (numericValue * 3.306).toString()
    }
}


@Composable
fun PyeongToSquareMeterStateless(
    pyeong: String,
    squareMeter: String,
    onPyeongChange: (String) -> Unit
) {

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = pyeong,
            onValueChange = {
                onPyeongChange
            },
            label = { Text(text = "평") }
        )

        OutlinedTextField(
            value = squareMeter,
            onValueChange = {

            },
            label = { Text(text = "제곱미터") }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StateStateHoistingTheme {
        StateStateHoisting()
    }
}