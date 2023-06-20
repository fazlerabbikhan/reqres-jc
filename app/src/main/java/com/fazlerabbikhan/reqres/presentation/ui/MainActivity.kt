package com.fazlerabbikhan.reqres.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fazlerabbikhan.reqres.presentation.ui.theme.ReqresTheme
import com.fazlerabbikhan.reqres.presentation.ui.user_detail.CoinDetailScreen
import com.fazlerabbikhan.reqres.presentation.ui.user_list.UserListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReqresTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.UserListScreen.route
                    ) {
                        composable(
                            route = Screen.UserListScreen.route
                        ) {
                            UserListScreen(navController)
                        }
                        composable(
                            route = Screen.UserDetailScreen.route + "/{userId}"
                        ) {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ReqresTheme {
//        Greeting("Android")
//    }
//}