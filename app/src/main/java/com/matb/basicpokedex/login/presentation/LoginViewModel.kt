package com.matb.basicpokedex.login.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.matb.basicpokedex.detail.presentation.DetailState
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

/**
 * Created by meldricktb$ on 13/09/23$.
 */
class LoginViewModel : ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    fun updateEmail(email: String) {
        state = state.copy(
            email = email
        )
    }

    fun updatePassword(password: String) {
        state = state.copy(
            password = password
        )
    }

    fun login(){
        viewModelScope.launch {
            state = try {
                val result = Firebase.auth.signInWithEmailAndPassword(state.email, state.password).await()
                println()
                showToast("Bienvenido a la Pokedex")
                state.copy(
                    accessGranted = true,
                    isToastShowing = true,
                )

            } catch (e: Exception){
                val message = e.message
                println(message)
                showToast("Ups, algo salió mal...")
                state.copy(
                    accessGranted = false,
                    isToastShowing = false
                )

            }
        }
    }

    private fun showToast(message: String?) {
        state = state.copy(
            isToastShowing = true,
            message = message

        )
    }

    fun dismissToast() {
        state = state.copy(
            isToastShowing = false,
            message = null)
    }
}