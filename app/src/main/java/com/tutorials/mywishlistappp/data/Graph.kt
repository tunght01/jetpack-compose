package com.tutorials.mywishlistappp.data

import android.content.Context
import androidx.room.Room

// dendency injecttion nó sẽ là người cung cấp nhưng gì heej thống làm mà mình không phải tự tay làm
// graph là đối tượng hoạt động hiệu quả như một vùng chứa phụ thuojc đơn giản
// nó khởi tạo và cung cấp các phiên bản của =csdl và kho lưu trữ mà ứng dụng cần
// phù hợp quản lý các pohuj thuojc một cách tập trung, tránh sư liên kết chặt chẽ
// giữa các thành phần giuspo mã dễ kiểm tra và bảo trì hơn

// tạp graph ở đây như là chuẩn bị toàn bộ nhưng gì hệ thng cần để dùng csdl vậy
object Graph { // nó là duy nhất và không có object nào giống nó cẩ
    lateinit var database: WishDatabase
    val wishReposiottory by lazy {  // lzy dùng để giúp nó chỉ được khởi tạo khi nó thực sự có quyền truy cập
        // chứ không phải nó được chạy ngay từ đầu
        // giúp tối ưu và làm cho luồng an toàn hơn  repositpry sẽ chỉ khởi tạo một làn ngay cả khi truy acajp bởi nhiều luồng cùng 1 lúc
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context){
        // thư viện của android room persistence la một lơp trừu tượng nằm trên splite
        //nó cho phép truy cập csdl mạ nh mẽ hơn khi khái thác toàn bộ sức mạnh của sqlite
        database = Room.databaseBuilder(
            context,
            WishDatabase::class.java,"wishlist.db")
            .build() // tên csdl tron g điện thoại
    }
}