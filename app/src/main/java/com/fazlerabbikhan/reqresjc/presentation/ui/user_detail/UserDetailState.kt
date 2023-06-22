package com.fazlerabbikhan.reqresjc.presentation.ui.user_detail

import com.fazlerabbikhan.reqresjc.domain.model.UserDetail

data class UserDetailState(
    val isLoading: Boolean = false,
    val user: UserDetail? = null,
    val error: String = ""
)
