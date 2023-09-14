package com.matb.basicpokedex.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matb.basicpokedex.home.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by meldricktb$ on 13/09/23$.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    init {
        state = state.copy(isLoading = true)
        viewModelScope.launch {
            repository.getPokemons().onSuccess {
                state = state.copy(
                    pokemons = it
                )
            }.onFailure {
                val msg = it.localizedMessage
                println(msg)
            }
            state = state.copy(
                isLoading = false
            )
        }
    }
}