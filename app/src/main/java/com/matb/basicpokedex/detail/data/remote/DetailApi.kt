package com.matb.basicpokedex.detail.data.remote.dto

import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by meldricktb$ on 13/09/23$.
 */
interface DetailApi {
    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }

    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(@Path("id") id: Int): PokemonDetailResponse
}