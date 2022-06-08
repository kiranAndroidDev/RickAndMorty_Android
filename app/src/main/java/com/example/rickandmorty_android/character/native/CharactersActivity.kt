package com.example.rickandmorty_android.character.native

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty_android.R
import com.example.rickandmorty_android.databinding.CharacterActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharactersActivity : AppCompatActivity() {

    private lateinit var binding: CharacterActivityBinding
    //val viewModel : CharacterViewModel by viewModels()

    private lateinit var listAdapter: CharacterListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<CharacterActivityBinding>(this,
            R.layout.character_activity)
        initRecyclerView()
        lifecycleScope.launch {
            /*viewModel.getState().collect {
                when (it) {
                    is UIState.Error -> {

                    }
                    is UIState.Loaded -> listAdapter.submitList(it.listOfCharacters)
                    UIState.Loading -> {}
                }
            }*/
        }
    }

    private fun initRecyclerView() {
        listAdapter = CharacterListAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@CharactersActivity)
            adapter = listAdapter
        }
    }
}
