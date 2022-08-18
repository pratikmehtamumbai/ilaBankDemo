package com.bankabc.ilabankdemo.carouselview

import android.widget.ImageView

interface ImageListener {
    fun setImageForPosition(position: Int, imageView: ImageView?)
}