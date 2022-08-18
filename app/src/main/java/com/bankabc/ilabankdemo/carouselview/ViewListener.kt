package com.bankabc.ilabankdemo.carouselview

import android.view.View

interface ViewListener {
    fun setViewForPosition(position: Int): View?
}