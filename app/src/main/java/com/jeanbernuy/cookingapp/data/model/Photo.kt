package com.jeanbernuy.cookingapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Photo(val url: String? = "") : Parcelable