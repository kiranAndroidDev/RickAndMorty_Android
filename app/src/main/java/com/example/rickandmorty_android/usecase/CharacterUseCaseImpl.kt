package com.example.rickandmorty_android.usecase

import com.example.rickandmorty_android.data.CharacterRepo
import com.example.rickandmorty_android.presentation.v2.UIState
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

