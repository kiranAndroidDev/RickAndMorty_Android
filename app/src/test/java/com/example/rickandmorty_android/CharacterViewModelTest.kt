package com.example.rickandmorty_android

import com.example.rickandmorty_android.usecase.CharacterUseCaseImpl
import com.example.rickandmorty_android.data.CharacterRepo
import com.example.rickandmorty_android.presentation.viewmodel.CharacterViewModel
import com.example.rickandmorty_android.presentation.v2.UIState
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.resetMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class CharacterViewModelTest {

    private val repo = mockk<CharacterRepo>()

    private val viewModel = CharacterViewModel(CharacterUseCaseImpl(repo))

    @OptIn(ExperimentalCoroutinesApi::class)
    val dispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun `post state value as loaded when repo returns success`() {
        coEvery { repo.getCharactersFromServer() } returns listOf()
        runTest(dispatcher) {
            viewModel.getCharacters()
            assertEquals(UIState.Loading, viewModel.getState().value)
            delay(500)
            assertEquals(UIState.Loaded(listOf()), viewModel.getState().value)
        }
    }

    @Test
    fun `post state value as loaded when repo returns error`() {
        coEvery { repo.getCharactersFromServer() } throws Exception("")
        runTest(dispatcher) {
            viewModel.getCharacters()
            assertEquals(UIState.Loading, viewModel.getState().value)
            delay(500)
            assertEquals(UIState.Error(""), viewModel.getState().value)
        }
    }

    @After
    fun clear() {
        Dispatchers.resetMain()
    }

}
