package com.jeanbernuy.cookingapp.ui.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jeanbernuy.cookingapp.RecipeQuery
import com.jeanbernuy.cookingapp.core.Resource
import com.jeanbernuy.cookingapp.data.DataSource


class ListRecipeViewModel : ViewModel() {

    private val dataRepository = DataSource()
    var listRecipes = MutableLiveData<Resource.Success<RecipeQuery.Data>?>()

    init {
        fetchRecipes()
    }

    fun fetchRecipes() {
        dataRepository.getRecipeCollection {
            val handler = Handler(Looper.getMainLooper())
            handler.post {
                listRecipes.value = it
            }
        }
    }
}