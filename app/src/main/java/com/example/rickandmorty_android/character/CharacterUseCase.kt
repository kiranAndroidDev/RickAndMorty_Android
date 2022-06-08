package com.example.rickandmorty_android.character

interface CharacterUseCase {
    suspend fun getCharacters(): UIState
}
