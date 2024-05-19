package com.tutorials.mywishlistappp

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation


@Composable
fun Navigation(viewModel: WishViewModel = viewModel(),
               navController:NavHostController){
     NavHost(navController = navController,
         startDestination = Screen.HomeScreeen.route ){
         composable(Screen.HomeScreeen.route){
             HomeView(viewModel = viewModel, navController = navController)
         }
         composable(
             Screen.AddScreeen.route+ "/{id}",
             arguments = listOf(
                 navArgument("id"){
                     type = NavType.LongType
                     defaultValue = 0L
                     nullable = false
                 }
             )
         ){
             entry ->
             val id = if (entry.arguments != null) entry.arguments!!.getLong("id") else 0L
             AddEditDeatailView(id = id, viewModel = viewModel, navController = navController)

         }




     }

}