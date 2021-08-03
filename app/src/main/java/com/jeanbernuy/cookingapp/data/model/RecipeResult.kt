package com.jeanbernuy.cookingapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeResult(
    val recipes: List<RecipeItem>
) : Parcelable {
    companion object
}