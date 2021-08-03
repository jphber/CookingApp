package com.jeanbernuy.cookingapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TagsCollection(val items: List<Item>?): Parcelable