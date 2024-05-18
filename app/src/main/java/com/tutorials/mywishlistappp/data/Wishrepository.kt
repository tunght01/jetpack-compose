package com.tutorials.mywishlistappp.data

import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao: WishDao) {
    suspend fun addWISH(wish: Wish){
        wishDao.addAWish(wish)
    }

    suspend fun getWish():Flow<List<Wish>> = wishDao.getAllWishes()

    suspend fun getAWishById(id:Long):Flow<Wish>{
        return wishDao.getAWishesById(id)
    }
    suspend fun updateAWish(wish: Wish){
        wishDao.updateAWish(wish);
    }
    suspend fun deleteAWish(wish: Wish){
        wishDao.deletaAWish(wish);
    }
}