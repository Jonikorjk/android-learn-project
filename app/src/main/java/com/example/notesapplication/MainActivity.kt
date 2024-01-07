package com.example.notesapplication

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var notes: MutableList<Notes> = mutableListOf()

    private fun setupInitialFragment() {
        val notesListFragment = NotesListFragment(notes) { note: Notes ->
            val fragment = DescriptionFragment(note)
            val tx = supportFragmentManager.beginTransaction()
            tx.replace(R.id.a_main_container, fragment).addToBackStack(null)
            tx.commit()
        }

        val tx = supportFragmentManager.beginTransaction()
        tx.replace(R.id.a_main_container, notesListFragment).addToBackStack(null)
        tx.commit()
    }

    private fun setupUI() {
        val button = findViewById<Button>(R.id.add_note_button)
        button.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupInitialFragment()
        setupUI()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {

//            val imageBytes = intent.getByteArrayExtra("bitmap")
//            val bitmap: Bitmap? = data?.getParcelableExtra("bitmap")

            notes.add(
                Notes(
                    title = data?.getStringExtra("title") ?: "empty data",
                    description = data?.getStringExtra("description") ?: "empty data",
                    null
                )
            )
            Log.d("my tag", notes.toString())
        }
    }

}