package com.example.notesapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class AddNoteActivity : AppCompatActivity() {
    private val changeImage = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val data = it.data
            val imgUri = data?.data
            val imageButton = findViewById<ImageButton>(R.id.add_note_d_image)
            imageButton.setImageURI(imgUri)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)
        setupUI()
    }

    private fun setupUI() {
        val button = findViewById<Button>(R.id.confirm_note_button)
        val title = findViewById<TextView>(R.id.title_textview)
        val description = findViewById<TextView>(R.id.description_textview)
        val imageButton = findViewById<ImageButton>(R.id.add_note_d_image)

        imageButton.setOnClickListener {
            val pickImg = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            changeImage.launch(pickImg)
        }

        button.setOnClickListener {
//            val bitmap: Bitmap = drawableToBitmap(imageButton.drawable)
            val data = Intent()
            data.putExtra("title", title.text.toString())
            data.putExtra("description", description.text.toString())
            data.putExtra("bitmap", "")
            setResult(RESULT_OK, data)
            finish()
        }
    }
    private fun drawableToBitmap(drawable: Drawable): Bitmap {
        if (drawable is BitmapDrawable) {
            return drawable.bitmap
        }

        val bitmap = Bitmap.createBitmap(
            drawable.intrinsicWidth,
            drawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )

        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)

        return bitmap
    }
}