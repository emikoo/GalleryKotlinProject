package com.example.galleryemikookotlinproject.helper

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import com.example.galleryemikookotlinproject.model.Photo

object ImagesGallery {

    fun listOfImages(context: Context): ArrayList<Photo> {

        val cursor: Cursor
        val column_index_data: Int
        val listOfAllImages: ArrayList<Photo> = ArrayList()
        var absolutePathOfImage: String
        val uri: Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI

        val projection =
            arrayOf(MediaStore.MediaColumns.DATA, MediaStore.Images.Media.BUCKET_DISPLAY_NAME)
        val orderBy: String = MediaStore.Images.Media.DATE_TAKEN
        cursor = context.contentResolver.query(uri, projection, null, null, orderBy + " DESC")!!
        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA)


        while (cursor.moveToNext()) {
            absolutePathOfImage = cursor.getString(column_index_data)
            listOfAllImages.add(Photo(absolutePathOfImage, false))
        }
        return listOfAllImages
    }

}