package com.example.rickandmorty_android.character

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.rickandmorty_android.character.native.CharactersActivity
import com.example.rickandmorty_android.character.ui.CharacterListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContent {
            CharacterListScreen()
        }
        startActivity(Intent(this, CharactersActivity::class.java ))
    }
}


