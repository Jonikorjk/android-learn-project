package com.example.notesapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class NotesAdapter(context: Context, items: List<Notes>) :
    ArrayAdapter<Notes>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context)
                .inflate(R.layout.custom_cell_layout, parent, false)
        }

        val itemNameTextView: TextView = itemView!!.findViewById(R.id.itemNameTextView)
        itemNameTextView.text = "xyi"

        return itemView
    }
}
