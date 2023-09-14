package com.matb.basicpokedex.detail.domain.repository

import com.matb.basicpokedex.detail.domain.model.PokemonDetail

/**
 * Created by meldricktb$ on 13/09/23$.
 */
interface DetailRepository {
    suspend fun getPokemonDetail(id: Int): Result<PokemonDetail>
}