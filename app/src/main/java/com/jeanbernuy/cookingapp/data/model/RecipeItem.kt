package com.jeanbernuy.cookingapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeItem(
    val title: String? = "",
    val description: String? = "",
    val photo: Photo?,
    val chef: Chef,
    val tagsCollection: TagsCollection
): Parcelable {
    companion object
}