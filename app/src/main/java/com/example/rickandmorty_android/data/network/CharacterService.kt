package com.example.rickandmorty_android.data.network

import retrofit2.http.GET

interface CharacterService {
    @GET("character")
    suspend fun getCharacters() : CharactersListModel
}
