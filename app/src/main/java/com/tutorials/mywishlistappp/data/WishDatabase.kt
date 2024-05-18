package com.tutorials.mywishlistappp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Wish::class], // tham chiếu đến wish và các thuộc tính trrong wish sẽ thành cột trong bảng đó
    version = 1, // phiên bản đầu tiên mình tạo database
    exportSchema = false // đặt thành false là không xuât dữ lịệu ra
)
abstract class WishDatabase:RoomDatabase() {
    abstract fun wishDao():WishDao
}