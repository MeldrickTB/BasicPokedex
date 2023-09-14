package com.matb.basicpokedex.util

import java.util.Locale

/**
 * Created by meldricktb$ on 13/09/23$.
 */
fun String.capitalize(): String {
    return this.replaceFirstChar { letter ->
        if (letter.isLowerCase()) letter.titlecase(Locale.getDefault()) else letter.toString()
    }
}
