package com.example.rickandmorty_android.data.network

data class CharactersListModel (val results : List<CharacterModel>)
data class CharacterModel(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: Origin,
    val image: String,
    val url: String,
) {
    data class Origin(
        val name: String,
        val url: String,
    )
}
