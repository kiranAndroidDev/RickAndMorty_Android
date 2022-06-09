package com.example.rickandmorty_android.data

import com.example.rickandmorty_android.data.network.CharacterModel
import com.example.rickandmorty_android.data.network.CharacterService
import javax.inject.Inject

class CharacterRepoImpl @Inject constructor(private val service: CharacterService) : CharacterRepo {
    override suspend fun getCharactersFromServer(): List<CharacterModel> {
        return service.getCharacters().results
    }
}

