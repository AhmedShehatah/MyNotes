package com.ahmed.mynote.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ahmed.mynote.data.local.entities.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("DELETE FROM note")
    suspend fun deleteAllNotes()

    @Update
    suspend fun updateNote(note: Note)
}