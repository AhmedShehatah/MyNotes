package com.ahmed.mynote.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ahmed.mynote.R
import com.ahmed.mynote.data.local.entities.Note
import com.ahmed.mynote.databinding.NoteListItemBinding

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {
    var listItems: List<Note> = ArrayList()

    class ViewHolder(binding: NoteListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvTitle = binding.tvTitle
        val tvBody = binding.tvBody
        val noteCardView = binding.noteCardView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            NoteListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentNote = listItems[position]
        holder.tvTitle.text = currentNote.noteTitle
        holder.tvBody.text = currentNote.noteBody

        holder.noteCardView.setOnClickListener {
            val navController = Navigation.findNavController(holder.itemView)

            navController.navigate(R.id.action_notesListFragment_to_addNoteFragment)
        }


    }

    fun getList(noteList: List<Note>) {
        listItems = noteList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listItems.size

    }

}