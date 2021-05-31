package com.example.galleryemikookotlinproject.gallery

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.galleryemikookotlinproject.ImagesGallery
import com.example.galleryemikookotlinproject.R
import com.example.galleryemikookotlinproject.model.imageArray
import kotlinx.android.synthetic.main.activity_gallery.*


class GalleryActivity : AppCompatActivity() {

    lateinit var adapter: GalleryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        checkPermissions()
        setupRecyclerView()
    }

    private fun checkPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if ((checkSelfPermission( Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED)
                && (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED)
            ) {
                val permission = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                val permissionCoarse = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                requestPermissions(permission, 1)
                requestPermissions(permissionCoarse, 2)
            }
        }
    }

    private fun setupRecyclerView() {
        adapter = GalleryAdapter()
        recycler_view.adapter = adapter
        recycler_view.layoutManager = GridLayoutManager(this, 3)
        adapter.addItems(ImagesGallery.listOfImages(this))
    }

}