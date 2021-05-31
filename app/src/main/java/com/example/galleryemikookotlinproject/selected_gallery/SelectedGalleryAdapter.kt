package com.example.galleryemikookotlinproject.selected_gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.galleryemikookotlinproject.R
import com.example.galleryemikookotlinproject.base.BaseAdapter
import com.example.galleryemikookotlinproject.base.BaseViewHolder
import com.example.galleryemikookotlinproject.helper.gone
import com.example.galleryemikookotlinproject.model.Photo
import com.example.galleryemikookotlinproject.helper.visible
import kotlinx.android.synthetic.main.item_photo.view.*

class SelectedGalleryAdapter : BaseAdapter() {

    var selectedPhotoArray = mutableListOf<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return SelectedGalleryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return selectedPhotoArray.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        setupGalleryViewHolder(holder as SelectedGalleryViewHolder, position)
    }

    private fun setupGalleryViewHolder(holder: SelectedGalleryViewHolder, position: Int){
        val item = selectedPhotoArray[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
        }
    }

    fun addItems(items: MutableList<Photo>) {
        selectedPhotoArray = items
        notifyDataSetChanged()
    }

}

class SelectedGalleryViewHolder(itemView: View): BaseViewHolder(itemView){
    private val image: ImageView = itemView.findViewById(R.id.iv_photo)
    fun bind(item: Photo){
        Glide
            .with(image.context)
            .load(item.image)
            .placeholder(R.color.color_grey_dark)
            .centerCrop()
            .transition(DrawableTransitionOptions.withCrossFade(500))
            .into(image)
    }
}

