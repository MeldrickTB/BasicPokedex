package com.matb.basicpokedex.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.matb.basicpokedex.home.domain.model.PokemonPreview
import com.matb.basicpokedex.ui.theme.Fire

/**
 * Created by meldricktb$ on 13/09/23$.
 */
@Composable
fun PokemonCard(
    pokemon: PokemonPreview,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(200.dp)
            .background(MaterialTheme.colorScheme.background, shape = CutCornerShape(8.dp))
            .clickable {
                onClick()
            }
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(pokemon.image)
                .crossfade(true)
                .build(),
            contentDescription = pokemon.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(75.dp)
        )
        Text(modifier = Modifier.padding(top = 16.dp),
            textAlign = TextAlign.Center,
            text = "#${pokemon.id}\n${pokemon.name}",
            color = MaterialTheme.colorScheme.onBackground)
    }
}

@Preview
@Composable
fun PokemonCardPreview() {
    PokemonCard(
        PokemonPreview(
            4,
            "Charmander",
            ""
        ),
        {}
    )
}