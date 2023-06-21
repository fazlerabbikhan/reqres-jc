package com.fazlerabbikhan.reqres.presentation.ui.user_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.fazlerabbikhan.reqres.domain.model.User

@Composable
fun UserListItem(
    user: User,
    onItemClick: (User) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(user) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.spacedBy(40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = // Apply transformations if needed
            rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data(data = user.avatar)
                    .apply<ImageRequest.Builder>(block = fun ImageRequest.Builder.() {
                        transformations(CircleCropTransformation()) // Apply transformations if needed
                    }).build()
            ),
            contentDescription = "Image Description",
            modifier = Modifier.size(50.dp)
        )
        Text(
            textAlign = TextAlign.Center,
            text = "${user.first_name} ${user.last_name}",
            style = MaterialTheme.typography.bodyLarge,
            overflow = TextOverflow.Ellipsis
        )
    }
    Divider()
}