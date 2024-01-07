package com.example.notesapplication

import android.graphics.Bitmap
import android.media.Image

data class Notes(
    val title: String,
    val description: String,
    val bitmap: Bitmap?,
)