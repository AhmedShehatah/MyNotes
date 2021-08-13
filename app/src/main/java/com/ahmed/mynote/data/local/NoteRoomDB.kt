package com.ahmed.mynote.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ahmed.mynote.data.local.entities.Note

@Database(entities = [Note::class], version = 4, exportSchema = false)
abstract class NoteRoomDB : RoomDatabase() {

    abstract fun NoteDao(): NoteDao


    companion object {
        @Volatile
        private var instance: NoteRoomDB? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            NoteRoomDB::class.java, "note_database"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
}

