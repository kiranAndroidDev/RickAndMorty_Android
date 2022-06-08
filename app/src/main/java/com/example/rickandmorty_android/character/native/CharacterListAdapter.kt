package com.example.rickandmorty_android.character.native

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty_android.R
import com.example.rickandmorty_android.data.CharacterModel
import com.example.rickandmorty_android.databinding.CharacterListItemBinding

class CharacterListAdapter :
    ListAdapter<CharacterModel, CharacterListAdapter.ViewHolder>(characterDiffUtilCallback) {

    private lateinit var binding: CharacterListItemBinding

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        binding = CharacterListItemBinding.inflate(LayoutInflater.from(viewGroup.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(getItem(position))
    }

    class ViewHolder(private val binding: CharacterListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: CharacterModel) {
            binding.model = model
            binding.tvStatus.background = when(model.status){
                "Alive".trim() -> binding.root.context.getDrawable(R.drawable.chip_layout_alive)
                "Dead".trim() -> binding.root.context.getDrawable(R.drawable.chip_layout_dead)
                else -> binding.root.context.getDrawable(R.drawable.chip_layout_default)
            }
        }
    }
}

