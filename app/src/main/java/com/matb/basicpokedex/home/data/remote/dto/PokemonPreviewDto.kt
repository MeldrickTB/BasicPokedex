package com.matb.basicpokedex.home.data.remote.dto

import com.squareup.moshi.Json

/**
 * Created by meldricktb$ on 13/09/23$.
 */
data class PokemonPreviewDto(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "url")
    val url: String
)