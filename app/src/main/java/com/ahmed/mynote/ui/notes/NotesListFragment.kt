package com.ahmed.mynote.ui.notes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ahmed.mynote.R
import com.ahmed.mynote.databinding.NotesListFragmentBinding
import com.ahmed.mynote.viewmodel.NoteViewModel


class NotesListFragment : Fragment(R.layout.notes_list_fragment), View.OnClickListener {
    private lateinit var binding: NotesListFragmentBinding
    private val noteActivityViewModel: NoteViewModel by activityViewModels()
    private lateinit var navController: NavController


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = NotesListFragmentBinding.bind(view)
        navController = Navigation.findNavController(view)
        binding.floatingActionButton.setOnClickListener(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val adapter = Adapter()
        binding.rvNotes.layoutManager = LinearLayoutManager(requireContext())

        binding.rvNotes.adapter = adapter

        val swipeToDeleteCallback = object : SwipeToDeleteCallback() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val pos = viewHolder.adapterPosition
                adapter.listItems.drop(pos)
                adapter.notifyDataSetChanged()
                val note = adapter.listItems[pos]
                noteActivityViewModel.deleteNote(note)
            }

        }
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(binding.rvNotes)

        noteActivityViewModel.getAllNotes().observe(requireActivity(), { list ->
            adapter.getList(list)

        })

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.floatingActionButton -> {navController.navigate(R.id.action_notesListFragment_to_addNoteFragment)
            }
        }
    }


}