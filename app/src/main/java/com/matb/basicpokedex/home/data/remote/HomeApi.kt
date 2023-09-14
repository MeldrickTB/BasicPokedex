package com.matb.basicpokedex.home.data.remote

import com.matb.basicpokedex.home.data.remote.dto.PokemonPreviewResultDto
import retrofit2.http.GET

/**
 * Created by meldricktb$ on 13/09/23$.
 */
interface HomeApi {
    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }

    @GET("pokemon?limit=151&offset=0")
    suspend fun getPokemons(): PokemonPreviewResultDto
}