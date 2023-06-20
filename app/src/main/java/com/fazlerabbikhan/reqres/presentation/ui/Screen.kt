package com.fazlerabbikhan.reqres.presentation.ui

sealed class Screen(val route: String){
    object UserListScreen: Screen("user_list_screen")
    object UserDetailScreen: Screen("user_detail_screen")
}