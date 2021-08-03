package com.jeanbernuy.cookingapp.data

import com.jeanbernuy.cookingapp.RecipeQuery
import com.jeanbernuy.cookingapp.data.model.*

fun RecipeResult.Companion.fromGraphQlEntry(item: RecipeQuery.Data) = with(item) {
    RecipeResult(recipeCollection()?.items().orEmpty().map {
        RecipeItem(
            it.title(),
            it.description(),
            Photo(it.photo()?.url()),
            Chef(it.chef()?.name()),
            TagsCollection(it.tagsCollection()?.items().orEmpty().map { Item(it.name()) })
        )
    })
}
