package com.example.rickandmorty_android.character

import java.lang.Exception
import javax.inject.Inject

class CharacterUseCaseImpl @Inject constructor(private val repo: CharacterRepo) : CharacterUseCase {
    override suspend fun getCharacters(): UIState {
        return try {
            UIState.Loaded(repo.getCharactersFromServer())
        } catch (e: Exception) {
            e.printStackTrace()
            UIState.Error(e.message ?: "")
        }
    }
}

interface CharacterUseCase {
    suspend fun getCharacters(): UIState
}
