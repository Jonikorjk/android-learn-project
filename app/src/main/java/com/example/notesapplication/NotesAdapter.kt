package com.example.notesapplication

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class NotesAdapter(context: Context, items: List<Notes>) :
    ArrayAdapter<Notes>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView

        if (itemView == null) {
            itemView = LayoutInflater.from(context)
                .inflate(R.layout.custom_cell_layout, parent, false)
        }

        val item = getItem(position)
        val itemNameTextView: TextView = itemView!!.findViewById(R.id.cell_note_title)
        itemNameTextView.text = item?.title ?: "Note is empty"


        val imageView: ImageView = itemView!!.findViewById(R.id.cell_imageview)
        if (item?.bitmap != null) {
            imageView.setImageBitmap(item?.bitmap)
        }

        return itemView
    }
}
