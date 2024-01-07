package com.example.notesapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class AddNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)
        setupButtonAction()
    }

    private fun setupButtonAction() {
        val button = findViewById<Button>(R.id.confirm_note_button)
        val title = findViewById<TextView>(R.id.title_textview)
        val description = findViewById<TextView>(R.id.description_textview)

        button.setOnClickListener {
            val data = Intent()
            data.putExtra("title", title.text.toString())
            data.putExtra("description", description.text.toString())
            setResult(RESULT_OK, data)
            finish()
        }
    }
}