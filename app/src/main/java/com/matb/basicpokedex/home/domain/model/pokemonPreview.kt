package com.matb.basicpokedex.home.domain.model

/**
 * Created by meldricktb$ on 13/09/23$.
 */
data class PokemonPreview(
    val id: Int,
    val name: String,
    val url: String
) {
    val image =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/$id.png"
}