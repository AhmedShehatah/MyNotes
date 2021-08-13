package com.ahmed.mynote.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmed.mynote.data.local.entities.Note
import com.ahmed.mynote.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(private val repositoryObject: NoteRepository) : ViewModel() {

    fun insertNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repositoryObject.insertNote(note)

    }

    fun deleteNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repositoryObject.deleteNote(note)
    }

    fun deleteAllNotes() = viewModelScope.launch(Dispatchers.IO) {
        repositoryObject.deleteAllNotes()
    }

    fun getAllNotes(): LiveData<List<Note>> =
        repositoryObject.getAllNotes()


    fun updateNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repositoryObject.updateNote(note)
    }
}