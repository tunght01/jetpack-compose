package com.tutorials.mywishlistappp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true) // tạo khóa chính và cho nó tự tăng
    val id:Long = 0L,
    @ColumnInfo(name = "wish-title") // đặt tên thành viên trong bảng
    val title:String = "",
    @ColumnInfo(name = "wish-desc")
    val description:String
)

object DummyWish{
    val wishList = listOf<Wish>(
        Wish(id = 1L, title = "Ha Thanh Tung", description = "Tu hoc jetpack compose"),
        Wish(id = 1L, title = "Ha Xuan Truong", description = "Tu hoc jetpack compose"),
        Wish(id = 1L, title = "Ha Thanh Tung", description = "Tu hoc jetpack compose"),
        Wish(id = 1L, title = "Ha Thanh Tung", description = "Tu hoc jetpack compose")
    )
}
