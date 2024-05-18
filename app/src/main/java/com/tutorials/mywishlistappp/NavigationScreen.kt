package com.tutorials.mywishlistappp

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation


@Composable
fun Navigation(viewModel: WishViewModel = viewModel(),
               navController:NavHostController){
     NavHost(navController = navController,
         startDestination = Screen.HomeScreeen.route ){
         composable(Screen.HomeScreeen.route){
             HomeView(viewModel = viewModel, navController = navController)
         }
         composable(Screen.AddScreeen.route){
             AddEditDeatailView(id = 0L, viewModel = viewModel, navController = navController)

         }




     }

}