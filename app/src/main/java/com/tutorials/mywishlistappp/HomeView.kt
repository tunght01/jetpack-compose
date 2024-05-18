package com.tutorials.mywishlistappp


import AppBarView
import android.provider.CalendarContract.Colors
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tutorials.mywishlistappp.data.DummyWish
import com.tutorials.mywishlistappp.data.Wish


@Composable
fun HomeView(
    navController: NavController,
    viewModel: WishViewModel
){
    val context = LocalContext.current
    Scaffold(topBar = {
        AppBarView(title = "WishList", onBackNavClicked = {
            Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
        })

    },
        floatingActionButton = {
            FloatingActionButton(modifier = Modifier.padding(20.dp),
                contentColor = Color.White, containerColor = colorResource(id = R.color.appbar_color),
                onClick = {
                    navController.navigate(Screen.AddScreeen.route)
                }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
                
            }
        }
        ) {
        paddingValues -> LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
        ) {
            items(DummyWish.wishList){
                wish-> WishItem(wish = wish) {

            }
            }
    }
    }
}
@Composable
fun WishItem(wish: Wish, onClick:()->Unit){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp, start = 8.dp, end = 8.dp)
        .clickable {
            onClick
        },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors =  CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black

        )) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
            Text(text = wish.description)
        }


    }

}