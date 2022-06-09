package com.example.rickandmorty_android.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val useCase: CharacterUseCase) :
    ViewModel() {
    private var currentState = MutableStateFlow<UIState>(
        UIState.Loading
    )

    fun getState() = currentState.asStateFlow()

    fun getCharacters() {
        viewModelScope.launch {
            currentState.emit(UIState.Loading)
            currentState.emit(useCase.getCharacters())
        }
    }
}
