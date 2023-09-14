package com.matb.basicpokedex.detail.presentation

import com.matb.basicpokedex.detail.domain.model.PokemonDetail

/**
 * Created by meldricktb$ on 13/09/23$.
 */
data class DetailState(
    val isLoading: Boolean = false,
    val pokemonDetail: PokemonDetail? = null,
    val navigateBack: Boolean = false
)