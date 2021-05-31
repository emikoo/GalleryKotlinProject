package com.example.galleryemikookotlinproject.helper

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.TextView
import android.widget.Toast

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

@SuppressLint("SetTextI18n")
fun TextView.textNumsSelected(size: Int) {
    this.text = "Выбрано $size фотографии"
}

@SuppressLint("SetTextI18n")
fun TextView.textNumSelected(size: Int) {
    this.text = "Выбрана $size фотография"
}

fun Context.showToast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}