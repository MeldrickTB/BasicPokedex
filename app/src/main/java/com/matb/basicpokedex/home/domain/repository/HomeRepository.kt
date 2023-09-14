package com.matb.basicpokedex.home.domain.repository

import com.matb.basicpokedex.home.domain.model.PokemonPreview

/**
 * Created by meldricktb$ on 13/09/23$.
 */
interface HomeRepository {
    suspend fun getPokemons(): Result<List<PokemonPreview>>
}