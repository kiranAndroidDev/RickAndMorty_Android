package com.example.rickandmorty_android.di

import com.example.rickandmorty_android.data.CharacterRepo
import com.example.rickandmorty_android.data.CharacterRepoImpl
import com.example.rickandmorty_android.usecase.CharacterUseCase
import com.example.rickandmorty_android.usecase.CharacterUseCaseImpl
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
