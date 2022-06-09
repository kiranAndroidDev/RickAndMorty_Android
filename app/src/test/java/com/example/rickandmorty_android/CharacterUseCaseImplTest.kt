package com.example.rickandmorty_android

import com.example.rickandmorty_android.data.CharacterRepo
import com.example.rickandmorty_android.usecase.CharacterUseCaseImpl
import com.example.rickandmorty_android.presentation.v2.UIState
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CharacterUseCaseImplTest {

    private val repo = mockk<CharacterRepo>()
    private val useCaseImpl = CharacterUseCaseImpl(repo)

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `return Loaded state when repo returns success`() {
        coEvery { repo.getCharactersFromServer() } returns listOf()
        runTest {
            val res = useCaseImpl.getCharacters()
            assertEquals(UIState.Loaded(listOf()), res)
        }
    }

    @Test
    fun `return Loaded state when repo returns Error or null`() {
        coEvery { repo.getCharactersFromServer() } throws Exception("")
        runTest {
            val res = useCaseImpl.getCharacters()
            assertEquals(UIState.Error(""), res)
        }
    }
}
