package com.example.galleryemikookotlinproject.selected_gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.galleryemikookotlinproject.R
import com.example.galleryemikookotlinproject.gallery.GalleryActivity.Companion.SELECTED_ARRAY
import com.example.galleryemikookotlinproject.model.Photo
import kotlinx.android.synthetic.main.activity_gallery.*
import kotlinx.android.synthetic.main.activity_selected_gallery.*
import kotlinx.android.synthetic.main.activity_selected_gallery.recycler_view

class SelectedGalleryActivity : AppCompatActivity() {

    lateinit var adapter: SelectedGalleryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_gallery)

        setupViews()
    }

    private fun setupViews() {
        setupRecyclerView()
        setupListener()
    }

    private fun setupRecyclerView() {
        var item = intent.getSerializableExtra(SELECTED_ARRAY) as MutableList<Photo>

        adapter = SelectedGalleryAdapter()
        recycler_view.adapter = adapter
        adapter.addItems(item)
    }

    private fun setupListener() {
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}