
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.colorResource
import com.tutorials.mywishlistappp.R

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun AppBarView(title:String, onBackNavClicked:()->Unit){
    val navigationIcon: (@Composable () -> Unit) = {
        if (!title.contains("WishList")){
            IconButton(onClick = { onBackNavClicked() } ) {
                Icon(Icons.Default.ArrowBack, contentDescription = null, tint =  Color.White)
            }
        }else{
            null
        }
    }
    TopAppBar(
        title = { Text(text =  title) }, navigationIcon = navigationIcon,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.appbar_color),
            titleContentColor = colorResource(id = R.color.white),
        ),
    )
}