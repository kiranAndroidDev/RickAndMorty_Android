package com.example.rickandmorty_android.presentation.v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty_android.R
import com.example.rickandmorty_android.presentation.viewmodel.CharacterViewModel
import com.example.rickandmorty_android.databinding.CharacterListActivityV2Binding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterListActivityV2 : AppCompatActivity() {

    private lateinit var binding: CharacterListActivityV2Binding
    private val viewModel: CharacterViewModel by viewModels()

    private lateinit var listAdapter: CharacterListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.character_list_activity_v2)
        initRecyclerView()
        lifecycleScope.launch {
            viewModel.getState().collect {
                when (it) {
                    is UIState.Error -> {
                        showProgressBar(false)
                        showMsg(it.msg)
                    }
                    is UIState.Loaded -> {
                        showProgressBar(false)
                        listAdapter.submitList(it.listOfCharacters)
                    }
                    UIState.Loading -> showProgressBar(true)
                }
            }
        }
        viewModel.getCharacters()
    }

    private fun initRecyclerView() {
        listAdapter = CharacterListAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@CharacterListActivityV2)
            adapter = listAdapter
        }
    }

    private fun showProgressBar(show: Boolean) {
        binding.progressBar.visibility = if (show) View.VISIBLE else View.GONE
        binding.recyclerView.visibility = if (show) View.GONE else View.VISIBLE
    }

    private fun showMsg(msg: String) {
        Snackbar.make(binding.root, msg, Snackbar.LENGTH_SHORT).show()
    }
}
