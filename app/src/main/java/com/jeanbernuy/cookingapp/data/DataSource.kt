package com.jeanbernuy.cookingapp.data

import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.jeanbernuy.cookingapp.core.ClientContentful
import com.jeanbernuy.cookingapp.core.Resource
import com.jeanbernuy.cookingapp.RecipeQuery


class DataSource {

    fun getRecipeCollection(completion: (result: Resource.Success<RecipeQuery.Data>) -> Unit) {
        ClientContentful.clientContentfulGraphQL.query(RecipeQuery())
            .enqueue(object : ApolloCall.Callback<RecipeQuery.Data>() {
                override fun onFailure(e: ApolloException) {

                }

                override fun onResponse(response: Response<RecipeQuery.Data>) {
                    if (response.data != null) {
                        completion(Resource.Success(response.data!!))
                    }
                }
            })
    }
}