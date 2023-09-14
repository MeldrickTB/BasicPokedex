package com.matb.basicpokedex.detail.domain.model

import androidx.compose.ui.graphics.Color
import com.matb.basicpokedex.ui.theme.Bug
import com.matb.basicpokedex.ui.theme.Fire
import com.matb.basicpokedex.ui.theme.Grass
import com.matb.basicpokedex.ui.theme.Normal
import com.matb.basicpokedex.ui.theme.Water

enum class PokemonColor(val color: Color) {
    FIRE(Fire),
    WATER(Water),
    GRASS(Grass),
    NORMAL(Normal),
    BUG(Bug);

    companion object {
        fun colorFromList(types: List<String>): PokemonColor {
            if (types.any { it.lowercase() == "fire" }) return FIRE
            if (types.any { it.lowercase() == "grass" }) return GRASS
            if (types.any { it.lowercase() == "water" }) return WATER
            if (types.any { it.lowercase() == "bug" }) return BUG
            if (types.any { it.lowercase() == "normal" }) return NORMAL
            return WATER
        }
    }
}
