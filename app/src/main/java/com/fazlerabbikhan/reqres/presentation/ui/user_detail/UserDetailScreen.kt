package com.fazlerabbikhan.reqres.presentation.ui.user_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowRow


@Composable
fun CoinDetailScreen(
    viewModel: UserDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.user?.let { user ->
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "First Name: ${user.first_name}",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(8f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Last Name: ${user.last_name}",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(8f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Last Name: ${user.last_name}",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(8f)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Email: ${user.email}",
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                        text = "Support: ${user.supportUrl}",
                        style = MaterialTheme.typography.bodySmall
                    )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Description: ${user.supportText}",
                style = MaterialTheme.typography.bodySmall
            )
        }
        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}