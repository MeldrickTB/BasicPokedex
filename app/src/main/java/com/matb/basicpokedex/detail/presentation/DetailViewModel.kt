package com.matb.basicpokedex.detail.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matb.basicpokedex.detail.domain.repository.DetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by meldricktb$ on 13/09/23$.
 */
@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val detailRepository: DetailRepository
) : ViewModel() {
    var state by mutableStateOf(DetailState())
        private set

    init {
        val pokemonId = savedStateHandle.get<Int>("pokemonId")!!

        viewModelScope.launch {
            state = state.copy(isLoading = true)
            detailRepository.getPokemonDetail(pokemonId).onSuccess {
                state = state.copy(
                    pokemonDetail = it
                )
            }.onFailure {
                println()
            }
            state = state.copy(isLoading = false)
        }
    }

    fun onEvent(event: DetailEvent) {
        when (event) {
            DetailEvent.onBackPress -> {
                state = state.copy(
                    navigateBack = true
                )
            }

            else -> {}
        }
    }
}
