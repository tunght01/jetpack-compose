package com.tutorials.mywishlistappp

sealed class Screen(val route:String) {
    object HomeScreeen: Screen("home_screen")
    object AddScreeen: Screen("add_screen")
}