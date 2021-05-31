package com.example.galleryemikookotlinproject.gallery

import android.Manifest
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader
import com.example.galleryemikookotlinproject.R
import com.example.galleryemikookotlinproject.model.Photo
import kotlinx.android.synthetic.main.activity_gallery.*


class GalleryActivity : AppCompatActivity() {

    lateinit var adapter: GalleryAdapter
    val imageList: MutableList<Photo> = mutableListOf()
    var projection =
        arrayOf(MediaStore.MediaColumns.DATA)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        getPermission()
    }

    private fun getPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
            != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)
            ) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1
                )
            }
        } else {
            setupRecyclerView()
            getAllImages()
        }
    }

    private fun setupRecyclerView() {
        adapter = GalleryAdapter()
        recycler_view.adapter = adapter
        adapter.photoArray = imageList
    }

    fun getAllImages() {
        imageList.clear()
        val cursor: Cursor? = contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            projection,
            null,
            null,
            null
        )
        if (cursor != null){
            while (cursor.moveToNext()) {
                val absolutePathOfImage: String =
                    cursor.getString(cursor.getColumnIndex(MediaStore.MediaColumns.DATA))
                val ImageModel = Photo()
                ImageModel.image = absolutePathOfImage
                imageList.add(ImageModel)
            }
            cursor.close()
        }
    }
}