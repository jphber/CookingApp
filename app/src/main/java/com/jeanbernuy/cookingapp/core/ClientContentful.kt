package com.jeanbernuy.cookingapp.core

import com.apollographql.apollo.ApolloClient
import com.jeanbernuy.cookingapp.core.AppConstants.LOCALE
import com.jeanbernuy.cookingapp.core.AppConstants.SPACE_ID
import com.jeanbernuy.cookingapp.core.AppConstants.TOKEN
import okhttp3.OkHttpClient


object ClientContentful {

    val httpClient: OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor { chain ->
            chain.proceed(
                chain.request().newBuilder().addHeader(
                    "Authorization",
                    "Bearer $TOKEN"
                ).build()
            )
        }
        .build()

    val clientContentfulGraphQL by lazy {
        ApolloClient
            .builder()
            .serverUrl("https://graphql.contentful.com/content/v1/spaces/$SPACE_ID?locale=$LOCALE")
            .callFactory { request ->
                httpClient.newCall(request)
            }
            .build()
    }
}
