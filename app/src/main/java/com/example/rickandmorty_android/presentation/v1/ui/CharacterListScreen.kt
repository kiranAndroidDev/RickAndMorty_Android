package com.example.rickandmorty_android.presentation.v1.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.Text
import androidx.compose.material.Snackbar
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import  com.example.rickandmorty_android.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rickandmorty_android.presentation.v2.UIState
import com.example.rickandmorty_android.presentation.viewmodel.CharacterViewModel
import com.example.rickandmorty_android.data.network.CharacterModel
import com.example.rickandmorty_android.presentation.v1.ui.theme.Cyan500

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CharacterListScreen(viewModel: CharacterViewModel = viewModel()) {
    val state by viewModel.getState().collectAsState()
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(Unit) {
        viewModel.getCharacters()
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(title = {
                Text(stringResource(id = R.string.toolbar_title),
                    color = Color.White)
            }, backgroundColor = Cyan500)
        },
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
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun showLoadedList(listOfCharacters: List<CharacterModel>) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp, 20.dp)
    ) {
        LazyColumn {
            items(listOfCharacters) {
                CharacterItem(item = it)
            }
        }
    }
}
