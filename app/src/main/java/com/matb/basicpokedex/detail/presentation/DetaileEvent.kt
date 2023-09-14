package com.matb.basicpokedex.detail.presentation

/**
 * Created by meldricktb$ on 13/09/23$.
 */
sealed class DetailEvent {
    object onBackPress : DetailEvent()
}