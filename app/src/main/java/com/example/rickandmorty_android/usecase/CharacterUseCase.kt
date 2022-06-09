package com.example.rickandmorty_android.usecase

import com.example.rickandmorty_android.presentation.v2.UIState

interface CharacterUseCase {
    suspend fun getCharacters(): UIState
}
