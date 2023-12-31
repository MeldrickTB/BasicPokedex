package com.matb.basicpokedex.detail.domain.model

data class PokemonDetail(
    val id: Int,
    val name: String,
    val abilities: List<String>,
    val stats: List<PokemonStat>,
    val types: List<String>,
    val color: PokemonColor
) {
    val image =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/$id.png"
}
