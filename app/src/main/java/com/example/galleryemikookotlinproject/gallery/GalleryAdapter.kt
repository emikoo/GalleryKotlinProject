package com.example.galleryemikookotlinproject.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.galleryemikookotlinproject.R
import com.example.galleryemikookotlinproject.base.BaseAdapter
import com.example.galleryemikookotlinproject.base.BaseViewHolder
import com.example.galleryemikookotlinproject.model.Photo
import kotlinx.android.synthetic.main.item_photo.view.*

class GalleryAdapter : BaseAdapter() {

    val photoArray = mutableListOf<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return GalleryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return photoArray.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        setupGalleryViewHolder(holder as GalleryViewHolder, position)
    }

    private fun setupGalleryViewHolder(holder: GalleryViewHolder, position: Int){
        val item = photoArray[position]
        holder.bind(item)
    }

}

class GalleryViewHolder(itemView: View): BaseViewHolder(itemView){
    fun bind(item: Photo){
        itemView.iv_photo
        Glide
            .with(itemView.iv_photo.context)
            .load(item.url)
            .into(itemView.iv_photo)
    }
}