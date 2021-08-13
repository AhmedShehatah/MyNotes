package com.ahmed.mynote.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val noteTitle: String,
    val noteBody: String
)