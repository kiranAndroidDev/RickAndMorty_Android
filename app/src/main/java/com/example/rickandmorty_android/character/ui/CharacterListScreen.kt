package com.example.rickandmorty_android.character.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rickandmorty_android.character.UIState
import com.example.rickandmorty_android.character.CharacterViewModel
import com.example.rickandmorty_android.data.CharacterModel

@Composable
fun CharacterListScreen() {
    val viewModel: CharacterViewModel =  viewModel()
    val state by viewModel.getState().collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getCharacters()
    }
    Scaffold(
        content = {
            when (val currentState = state) {
                is UIState.Error -> {
                    Snackbar()
                    { Text(text = currentState.msg) }
                }
                is UIState.Loaded -> showLoadedList(listOfCharacters = currentState.listOfCharacters)

                UIState.Loading -> showLoading()
            }
        }
    )
}

@Composable
fun showLoading() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
            .padding(4.dp)
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun showLoadedList(listOfCharacters: List<CharacterModel>) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
            .padding(8.dp, 20.dp)
    ) {
        LazyColumn {
            items(listOfCharacters) {
                CharacterItem(item = it)
            }
        }
    }
}
