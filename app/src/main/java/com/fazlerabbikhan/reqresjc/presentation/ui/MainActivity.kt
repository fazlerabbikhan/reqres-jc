package com.fazlerabbikhan.reqresjc.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fazlerabbikhan.reqresjc.presentation.ui.theme.ReqresTheme
import com.fazlerabbikhan.reqresjc.presentation.ui.user_detail.UserDetailScreen
import com.fazlerabbikhan.reqresjc.presentation.ui.user_list.UserListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
                            UserDetailScreen()
                        }
                    }
                }
            }
        }
    }
}