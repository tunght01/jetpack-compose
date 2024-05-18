package com.tutorials.mywishlistappp

import android.app.Application
import com.tutorials.mywishlistappp.data.Graph

class WíhListApp:Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}