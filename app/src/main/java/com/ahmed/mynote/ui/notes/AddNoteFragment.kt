package com.ahmed.mynote.ui.notes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ahmed.mynote.MainActivity
import com.ahmed.mynote.R
import com.ahmed.mynote.data.local.entities.Note
import com.ahmed.mynote.databinding.AddNoteFragmentBinding
import com.ahmed.mynote.viewmodel.NoteViewModel

class AddNoteFragment : Fragment(R.layout.add_note_fragment) {
    private lateinit var binding: AddNoteFragmentBinding
    private val noteActivityViewModel: NoteViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AddNoteFragmentBinding.bind(view)
        val activity = activity as MainActivity
        binding.btnAdd.setOnClickListener {
            val note = Note(0, binding.etTitle.text.toString(), binding.etBody.text.toString())
            noteActivityViewModel.insertNote(note)

            activity.onBackPressed()

        }
    }

}