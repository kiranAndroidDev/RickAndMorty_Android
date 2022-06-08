package com.example.rickandmorty_android.character

import com.example.rickandmorty_android.data.CharacterModel

interface CharacterRepo {
    suspend fun getCharactersFromServer(): List<CharacterModel>
}
