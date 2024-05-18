package com.tutorials.mywishlistappp

import AppBarView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AddEditDeatailView(
    id:Long,
    viewModel: WishViewModel,
    navController: NavController
){
    Scaffold(topBar = {
        AppBarView(title =
            if (id != 0L) stringResource(id = R.string.add_wish)
            else stringResource(id = R.string.add_wish)
                           , onBackNavClicked = {
            navController.navigateUp()
        })
    }){
            paddingValues -> Column(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues), horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
        ) {
                Spacer(modifier = Modifier.height(10.dp))
                WishTextFiledf(label = "title", value = viewModel.wishTtileState,
                    onValueSchanged = {
                        viewModel.wishTitleStateChanged(it)
                    })

                Spacer(modifier = Modifier.height(10.dp))
        WishTextFiledf(label = "Description", value = viewModel.wishDescriptionState,
            onValueSchanged = {
                viewModel.wishDescriptionStateChanged(it)
            })
                Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {  }, colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.appbar_color)
        )
        ) {
            Text(text = if(id != 0L) stringResource(id = R.string.update_wish)
            else stringResource(id = R.string.add_wish) , style = TextStyle(fontSize = 18.sp)
            )
        }

        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishTextFiledf(
    label:String,
    value:String,
    onValueSchanged:(String)->Unit)
{
    OutlinedTextField(
        value = value, 
        onValueChange = onValueSchanged,
        label = {Text(text = label, color = Color.Black)},
        modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 15.dp),

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.black),
            focusedBorderColor = colorResource(id = R.color.black),
            cursorColor = colorResource(id = R.color.black),
            focusedLabelColor = colorResource(id = R.color.black),
            unfocusedLabelColor = colorResource(id = R.color.black),
        )
        )
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun outlinePreview(){
    WishTextFiledf("label","",{})
}