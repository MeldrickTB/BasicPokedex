package com.matb.basicpokedex.login.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.matb.basicpokedex.home.presentation.HomeViewModel

/**
 * Created by meldricktb$ on 13/09/23$.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)

    ) {

        if (state.accessGranted) {
            onLoginClick()
        }

        if (state.isToastShowing) {
            Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
            navController.popBackStack()
            viewModel.dismissToast()
        }

        Text(text = "Firebase Login", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = state.email,
            onValueChange = { viewModel.updateEmail(it)},
            placeholder = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth())

        OutlinedTextField(
            value = state.password,
            onValueChange = { viewModel.updatePassword(it)},
            placeholder = { Text(text = "Password")},
            modifier = Modifier.fillMaxWidth())
        
        Button(onClick = { viewModel.login() }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Login", modifier = Modifier.padding(vertical = 10.dp))
            
        }
    }

}