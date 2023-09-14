package com.matb.basicpokedex.home.presentation

import com.matb.basicpokedex.home.domain.model.PokemonPreview

/**
 * Created by meldricktb$ on 13/09/23$.
 */
data class HomeState(
    val isLoading: Boolean = false,
    val pokemons: List<PokemonPreview> = emptyList()
)