package com.example.notesapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.ListFragment

class NotesListFragment(private var notes: List<Notes>, private var callback: (Notes) -> Int) :ListFragment() {
    override fun onStart() {
        super.onStart()
        listView.setOnItemClickListener { _, _, _, id ->
            callback(notes[id.toInt()])
        }
    }

    override fun onResume() {
        super.onResume()
        listAdapter = NotesAdapter(requireActivity(), notes)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_custom_list, container, false)
    }
}