package com.example.rickandmorty_android.character

import com.example.rickandmorty_android.data.CharacterModel
import com.example.rickandmorty_android.data.CharacterService
import javax.inject.Inject

class CharacterRepoImpl @Inject constructor(private val service: CharacterService) : CharacterRepo {
    override suspend fun getCharactersFromServer(): List<CharacterModel> {
        return service.getCharacters().results
    }
}

