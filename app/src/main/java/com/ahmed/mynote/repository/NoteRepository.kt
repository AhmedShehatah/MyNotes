package com.ahmed.mynote.repository

import com.ahmed.mynote.data.local.NoteRoomDB
import com.ahmed.mynote.data.local.entities.Note

class NoteRepository(private val noteDatabase: NoteRoomDB) {


    suspend fun insertNote(note: Note) =
        noteDatabase.NoteDao().insertNote(note)

    suspend fun updateNote(note: Note) =
        noteDatabase.NoteDao().updateNote(note)

    suspend fun deleteNote(note: Note) =
        noteDatabase.NoteDao().deleteNote(note)

     fun getAllNotes() =
        noteDatabase.NoteDao().getAllNotes()

    suspend fun deleteAllNotes() =
        noteDatabase.NoteDao().deleteAllNotes()

}