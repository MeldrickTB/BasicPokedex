package com.matb.basicpokedex.detail.data.remote.dto
import com.squareup.moshi.Json

data class TypeDto(
    @field:Json(name = "slot")
    val slot: Int,
    @field:Json(name = "type")
    val type: TypeX
)