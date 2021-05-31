package com.example.galleryemikookotlinproject.model

import android.app.Activity
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore

data class Photo(
    val url: String,
    val is_checked: Boolean = false
)
