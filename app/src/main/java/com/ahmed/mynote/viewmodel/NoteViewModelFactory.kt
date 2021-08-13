package com.ahmed.mynote.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahmed.mynote.repository.NoteRepository

@Suppress("UNCHECKED_CAST")
class NoteViewModelFactory(private val repo: NoteRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NoteViewModel(repo) as T
    }
}