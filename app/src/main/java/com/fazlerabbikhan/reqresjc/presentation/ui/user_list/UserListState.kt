package com.fazlerabbikhan.reqresjc.presentation.ui.user_list

import com.fazlerabbikhan.reqresjc.domain.model.User

data class UserListState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String = ""
)
