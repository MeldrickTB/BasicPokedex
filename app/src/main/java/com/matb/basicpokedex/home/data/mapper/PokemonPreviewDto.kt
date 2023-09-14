package com.matb.basicpokedex.home.data.mapper

import com.matb.basicpokedex.home.data.remote.dto.PokemonPreviewDto
import com.matb.basicpokedex.home.domain.model.PokemonPreview

/**
 * Created by meldricktb$ on 13/09/23$.
 */
fun PokemonPreviewDto.toDomain(): PokemonPreview {
    val regex = "pokemon/(.*)/".toRegex()
    val image = regex.find(this.url)
    val pokemonId = image?.groups?.get(1)?.value ?: 1
    return PokemonPreview(
        id = Integer.valueOf(pokemonId.toString()),
        name = this.name.capitalize(),
        url = this.url
    )
}