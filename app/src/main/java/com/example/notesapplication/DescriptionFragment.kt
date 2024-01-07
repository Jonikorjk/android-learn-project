package com.example.notesapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class DescriptionFragment(private val note: Notes) : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onStart() {
        super.onStart()

        val backButton = requireView().findViewById<Button>(R.id.details_back_button)
        val titleTextView = requireView().findViewById<TextView>(R.id.title_textview)
        val descriptionTextView = requireView().findViewById<TextView>(R.id.description_textview)

        titleTextView.text = note.title
        descriptionTextView.text = note.description

        backButton.setOnClickListener {
            getFragmentManager()?.popBackStack()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description, container, false)
    }
}