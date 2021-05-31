package com.example.galleryemikookotlinproject.gallery

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.galleryemikookotlinproject.R
import com.example.galleryemikookotlinproject.helper.*
import com.example.galleryemikookotlinproject.model.Photo
import com.example.galleryemikookotlinproject.selected_gallery.SelectedGalleryActivity
import kotlinx.android.synthetic.main.activity_gallery.*
import java.io.Serializable


class GalleryActivity : AppCompatActivity(), ClickListener {

    lateinit var adapter: GalleryAdapter
    lateinit var photoArray: MutableList<Photo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        checkPermissions()
    }

    private fun checkPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        photoArray = ImagesGallery.listOfImages(this)
        setupRecyclerView()
        setupListener()
    }

    private fun setupRecyclerView() {
        adapter = GalleryAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = GridLayoutManager(this, 3)
        adapter.addItems(photoArray)
    }

    override fun onItemCLick(item: Photo, position: Int) {
        var size = photoArray.filter { it.isSelected }.size
        if (size < 10) {
            photoArray[position].isSelected = !photoArray[position].isSelected
            size = photoArray.filter { it.isSelected }.size
            num_selected.visible()
            if (size in 2..10) text_selected.textNumsSelected(size)
            else if (size == 1) text_selected.textNumSelected(size)
            else num_selected.gone()
            adapter.addItems(photoArray)
        } else {
            showToast(getText(R.string.constraint) as String)
            if (photoArray[position].isSelected) photoArray[position].isSelected = false
            adapter.addItems(photoArray)
        }
    }

    private fun setupListener() {
        btn_done.setOnClickListener {
            val selectedArray = photoArray.filter { it.isSelected } as Serializable
            val intent = Intent(this, SelectedGalleryActivity::class.java)
            intent.putExtra(SELECTED_ARRAY, selectedArray)
            startActivity(intent)
        }
    }

    companion object {
        val SELECTED_ARRAY = "SELECTED_IMAGE"
    }
}