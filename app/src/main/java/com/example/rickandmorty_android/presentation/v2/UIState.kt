package com.example.rickandmorty_android.presentation.v2

import com.example.rickandmorty_android.data.network.CharacterModel

sealed class UIState {
    object Loading : UIState()
    data class Loaded(val listOfCharacters: List<CharacterModel>) : UIState()
    data class Error(val msg : String) : UIState()
}
