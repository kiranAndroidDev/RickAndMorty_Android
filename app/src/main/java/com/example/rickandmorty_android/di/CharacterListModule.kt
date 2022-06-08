package com.example.rickandmorty_android.di

import com.example.rickandmorty_android.character.CharacterRepo
import com.example.rickandmorty_android.character.CharacterRepoImpl
import com.example.rickandmorty_android.character.CharacterUseCase
import com.example.rickandmorty_android.character.CharacterUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CharacterListModule {
    @Binds
    abstract fun getCharacterRepo(impl: CharacterRepoImpl): CharacterRepo

    @Binds
    abstract fun getCharacterUseCase(impl: CharacterUseCaseImpl): CharacterUseCase

}
