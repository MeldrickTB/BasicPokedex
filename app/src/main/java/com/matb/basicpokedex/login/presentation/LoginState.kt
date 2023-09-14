package com.matb.basicpokedex.login.presentation

/**
 * Created by meldricktb$ on 13/09/23$.
 */
data class LoginState(
    val email: String = "",
    val password: String = "",
    val accessGranted: Boolean = false,
    val isToastShowing: Boolean = false,
    val message: String? = null,
)