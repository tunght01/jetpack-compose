package com.tutorials.mywishlistappp


import AppBarView
import android.widget.Toast
import androidx.compose.animation.animateColorAsState
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
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tutorials.mywishlistappp.data.Wish


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(
    navController: NavController,
    viewModel: WishViewModel
) {
    val context = LocalContext.current
    Scaffold(topBar = {
        AppBarView(title = "WishList", onBackNavClicked = {
            Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
        })

    },
        floatingActionButton = {
            FloatingActionButton(modifier = Modifier.padding(20.dp),
                contentColor = Color.White,
                containerColor = colorResource(id = R.color.appbar_color),
                onClick = {
                    navController.navigate(Screen.AddScreeen.route+"/0L")
                }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)

            }
        }
    ) {
        val wishList = viewModel.getAllWishes.collectAsState(initial = listOf())
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items(wishList.value, key = {wish -> wish.id  }) { wish ->
                val dismissState = rememberDismissState(
                    confirmValueChange = {
                        if (it == DismissValue.DismissedToEnd || it == DismissValue.DismissedToStart){
                            viewModel.deleteWish(wish)
                        }
                        true
                    }
                )
                SwipeToDismiss(
                    state = dismissState,
                    directions = setOf(DismissDirection.EndToStart),
                    background = {
                        val color by animateColorAsState(
                            if (dismissState.dismissDirection == DismissDirection.EndToStart) Color.Red else Color.Transparent,
                            label = ""
                        )
                        val alignment = Alignment.CenterEnd
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .background(color)
                            .padding(horizontal = 20.dp),
                            contentAlignment = alignment){
                            Icon(imageVector = Icons.Default.Delete, contentDescription = null, tint = Color.White)
                        }


                    },
                    dismissContent = {
                        WishItem(wish = wish) {
                            val id = wish.id
                            navController.navigate(Screen.AddScreeen.route + "/$id")
                        }

                    },

                )

            }
        }
    }
}

@Composable
fun WishItem(wish: Wish, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            .clickable {
                onClick()
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black

        )
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
            Text(text = wish.description)
        }


    }

}