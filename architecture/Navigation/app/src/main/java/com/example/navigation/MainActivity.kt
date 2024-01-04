package com.example.navigation

import android.os.Bundle
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation.ui.theme.NavigationTheme
import kotlinx.parcelize.Parcelize

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationEx()
                }
            }
        }
    }
}

@Composable
fun NavigationEx(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = "Home", modifier = modifier) {
        composable("Home") {
            Column {
                Text(text = "Home")
                Button(onClick = {
                    navController.navigate("Office"){
                        popUpTo("Home"){
                            //home도 같이 제거한다는 ㅊ
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }) {
                    Text(text = "Office로 이동")
                }
                Button(onClick = {
                    navController.navigate("PlayGround"){
                        popUpTo("Home"){
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }) {
                    Text(text = "PlayGround로 이동")
                }
                Button(onClick = {
                    navController.navigate("Argument/argument"){
                        popUpTo("Home"){
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }) {
                    Text(text = "argument 이동")
                }
            }
        }
        composable("Office") {
            Column {
                Text(text = "Office")
                Button(onClick = {
                    navController.navigate("Home"){
                        popUpTo("Home"){
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }) {
                    Text(text = "Home으로 이동")
                }
                Button(onClick = {
                    navController.navigate("PlayGround"){
                        popUpTo("Home"){
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }) {
                    Text(text = "PlayGround으로 이동")
                }
            }
        }
        composable("PlayGround") {
            Column {
                Text(text = "PlayGround")
                Button(onClick = {
                    navController.navigate("Home"){
                        popUpTo("Home"){
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }) {
                    Text(text = "Home으로 이동")
                }
                Button(onClick = {
                    navController.navigate("Office"){
                        popUpTo("Home"){
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }) {
                    Text(text = "Office로 이동")
                }
            }
        }
        composable("Argument/{id}"){
            val argument = it.arguments?.getString("id") ?: ""
            Text(text = argument)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationTheme {
        NavigationEx()
    }
}