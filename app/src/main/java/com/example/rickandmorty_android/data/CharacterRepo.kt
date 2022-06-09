package com.example.rickandmorty_android.data

import com.example.rickandmorty_android.data.network.CharacterModel

interface CharacterRepo {
    suspend fun getCharactersFromServer(): List<CharacterModel>
}
