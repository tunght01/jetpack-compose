package com.tutorials.mywishlistappp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tutorials.mywishlistappp.data.Graph
import com.tutorials.mywishlistappp.data.Wish
import com.tutorials.mywishlistappp.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRepository: WishRepository= Graph.wishReposiottory
): ViewModel() {
    var wishTtileState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun wishTitleStateChanged(newString:String){
        wishTtileState = newString
    }
    fun wishDescriptionStateChanged(newString:String){
        wishDescriptionState = newString
    }

    lateinit var getAllWishes:Flow<List<Wish>>
     init {
         viewModelScope.launch {
             getAllWishes = wishRepository.getWish()
         }
     }
    fun addWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) { // điều phối viên giúp tối ưu hóa
            // mỗi điều phói viên có quyết định đưucọ thiết kế cho mỗi khối lượng hay
            // hoạt động công việc khác nhaui: io là input và output tôối ưu hóa đầu vào và dầu ra
            // khi nó hoạt động có thể phải chờ để nó có thể dộc và ghi, nên nó sẽ diều phối để nó có thể tối ưu thời gian
            //quản lý luồn hiệu quả có
            wishRepository.addWISH(wish)
        }
    }

     fun getAWíhById(id:Long):Flow<Wish>{
        return wishRepository.getAWishById(id)
    }
    fun updateWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) { // điều phối viên giúp tối ưu hóa
            // mỗi điều phói viên có quyết định đưucọ thiết kế cho mỗi khối lượng hay
            // hoạt động công việc khác nhaui: io là input và output tôối ưu hóa đầu vào và dầu ra
            // khi nó hoạt động có thể phải chờ để nó có thể dộc và ghi, nên nó sẽ diều phối để nó có thể tối ưu thời gian
            //quản lý luồn hiệu quả có
            wishRepository.updateAWish(wish)
        }
    }
    fun deleteWish(wish: Wish){
        viewModelScope.launch (Dispatchers.IO){
            wishRepository.deleteAWish(wish)
        }
    }
}