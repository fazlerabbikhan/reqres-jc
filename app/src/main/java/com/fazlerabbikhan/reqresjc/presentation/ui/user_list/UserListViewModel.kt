package com.fazlerabbikhan.reqresjc.presentation.ui.user_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fazlerabbikhan.reqresjc.common.Resource
import com.fazlerabbikhan.reqresjc.domain.use_case.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    val getUsersUseCase: GetUsersUseCase
): ViewModel() {

    private val _state = mutableStateOf(UserListState())
    val state: State<UserListState> = _state

    init {
        getUsers()
    }

    private fun getUsers() {
        getUsersUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = UserListState(users = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = UserListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = UserListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}