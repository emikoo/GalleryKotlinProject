package com.example.galleryemikookotlinproject.model

data class Photo (
    var image: String,
    var isSelected: Boolean = false
)

val imageArray = mutableListOf<Photo>().apply {
    add(Photo("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.cdjapan.co.jp%2Fproduct%2FINRC-31&psig=AOvVaw2Ep8FN3G1fQwdigBPL20r1&ust=1622542080255000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCPj1vLXW8_ACFQAAAAAdAAAAABAD",
    false)
    ) }


