package com.example.groceryapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GroceryViewModal (private val repository:GrocerRepository):ViewModel(){

    fun insert(items:GroceryItems)=GlobalScope.launch {
        repository.insert(items)
    }

    fun delete(items:GroceryItems)=GlobalScope.launch {
        repository.insert(items)
    }
    fun getAllGroceryItems()=repository.getAllItems()
}