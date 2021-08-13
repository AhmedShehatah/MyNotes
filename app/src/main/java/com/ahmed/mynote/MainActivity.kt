package com.ahmed.mynote

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ahmed.mynote.data.local.NoteRoomDB
import com.ahmed.mynote.databinding.ActivityMainBinding
import com.ahmed.mynote.repository.NoteRepository
import com.ahmed.mynote.viewmodel.NoteViewModel
import com.ahmed.mynote.viewmodel.NoteViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var mainActivityViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            setContentView(binding.root)
            val repository = NoteRepository(NoteRoomDB(this))
            val viewModelFactory = NoteViewModelFactory(repository)
            mainActivityViewModel = ViewModelProvider(
                this,
                viewModelFactory
            )[NoteViewModel::class.java]

        } catch (ex: Exception) {
            Toast.makeText(this, "error occur", Toast.LENGTH_SHORT).show()
        }


    }
}