package com.example.chucknorrisapp.jokes.repository

import com.example.chucknorrisapp.categories.repository.CategoriesEndpoint
import com.example.chucknorrisapp.data.api.NetworkUtils
import com.example.chucknorrisapp.jokes.model.JokesModel
import retrofit2.http.GET
import retrofit2.http.Query

interface JokesEndpoint {

    @GET("random")
    suspend fun getJoke(@Query("category") category: String?): JokesModel

    companion object {
        val endpoint: JokesEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(JokesEndpoint::class.java)
        }
    }
}