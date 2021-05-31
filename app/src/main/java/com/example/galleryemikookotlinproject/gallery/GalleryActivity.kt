package com.example.galleryemikookotlinproject.gallery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.galleryemikookotlinproject.R
import kotlinx.android.synthetic.main.activity_gallery.*


class GalleryActivity : AppCompatActivity() {

    lateinit var adapter: GalleryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = GalleryAdapter()
        recycler_view.adapter = adapter

    }
}