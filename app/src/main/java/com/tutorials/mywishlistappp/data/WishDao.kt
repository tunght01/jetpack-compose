package com.tutorials.mywishlistappp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao  // dao sẽ chịu trách nhiệm truy vấn đến csdl
abstract class WishDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) // nếu tồn tại thì nó sẽ bỏ qua / replace nó sẽ ghi đè, và các thằng khác tự tìm hiểu
    abstract suspend fun addAWish(wishEntity: Wish)

    // lấy tất cả dữ liệu from the wish table
    @Query("Select * from `wish-table`")
    abstract suspend fun getAllWishes(): Flow<List<Wish>>

    @Update
    abstract suspend fun updateAWish(wishEntity: Wish)

    @Delete
    abstract suspend fun deletaAWish(wishEntity: Wish)

    @Query("Select * from `wish-table` where id=:id")
    abstract suspend fun getAWishesById(id:Long): Flow<Wish>

}