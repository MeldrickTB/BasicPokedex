package com.matb.basicpokedex.detail.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matb.basicpokedex.R

@Composable
fun DetailAbilityItem(
    position: Int,
    ability: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "${stringResource(R.string.ability)} $position: ", color = Color.DarkGray,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Normal)
        Spacer(modifier = Modifier.width(16.dp))
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = ability, color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Medium)
    }
}

@Preview
@Composable
fun DetailAbilityItemPreview() {
    DetailAbilityItem(1, "Growl")
}
