package com.example.rickandmorty_android.presentation.v2

import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmorty_android.data.network.CharacterModel

val characterDiffUtilCallback = object : DiffUtil.ItemCallback<CharacterModel>() {
    override fun areItemsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
        return oldItem == newItem
    }

}
