package com.example.rickandmorty_android.data

import retrofit2.http.GET

interface CharacterService {
    @GET("character")
    suspend fun getCharacters() : CharactersListModel
}
