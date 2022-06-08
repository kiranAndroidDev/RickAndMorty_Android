package com.example.rickandmorty_android.character

import com.example.rickandmorty_android.data.CharacterModel

sealed class UIState {
    object Loading : UIState()
    data class Loaded(val listOfCharacters: List<CharacterModel>) : UIState()
    data class Error(val msg : String) : UIState()
}
