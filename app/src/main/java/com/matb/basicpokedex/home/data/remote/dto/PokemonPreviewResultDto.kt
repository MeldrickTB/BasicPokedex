package com.matb.basicpokedex.home.data.remote.dto

import com.squareup.moshi.Json

/**
 * Created by meldricktb$ on 13/09/23$.
 */

data class PokemonPreviewResultDto(
    @field:Json(name = "count")
    val count: Int,
    @field:Json(name = "next")
    val next: String,
    @field:Json(name = "previous")
    val previous: Any,
    @field:Json(name = "results")
    val results: List<PokemonPreviewDto>
)