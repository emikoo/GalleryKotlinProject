package com.example.galleryemikookotlinproject.model

import java.io.Serializable

data class Photo (
    var image: String,
    var isSelected: Boolean = false
) : Serializable




