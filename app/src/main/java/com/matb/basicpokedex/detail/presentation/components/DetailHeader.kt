package com.matb.basicpokedex.detail.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.matb.basicpokedex.detail.domain.model.PokemonColor
import com.matb.basicpokedex.detail.domain.model.PokemonDetail

@Composable
fun DetailHeader(pokemon: PokemonDetail, modifier: Modifier = Modifier) {
    Row(modifier = modifier
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
        ) {
        val context = LocalContext.current

        Column(modifier = modifier
            .fillMaxWidth().weight(2f),
            verticalArrangement = Arrangement.Center,

            )
        {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "#${pokemon.id}\n${pokemon.name}",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(16.dp))
            DetailPokemonType(pokemon.types, backgroundColor = pokemon.color.color)
        }

        Column(modifier = modifier
            .fillMaxWidth().weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(pokemon.image)
                    .crossfade(true)
                    .build(),
                contentDescription = pokemon.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp)
            )
        }
    }
}

@Preview
@Composable
fun DetailHeaderPreview() {
    DetailHeader(
        pokemon = PokemonDetail(
            id = 4,
            name = "Charmander",
            abilities = listOf("Fire"),
            stats = listOf(),
            types = listOf("Fire", "Grass"),
            color = PokemonColor.FIRE
        )
    )
}
