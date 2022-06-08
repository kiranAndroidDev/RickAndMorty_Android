package com.example.rickandmorty_android.character

import javax.inject.Inject
import kotlin.Exception

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

