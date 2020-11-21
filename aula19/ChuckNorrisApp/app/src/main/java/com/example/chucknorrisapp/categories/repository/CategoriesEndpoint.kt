package com.example.chucknorrisapp.categories.repository

import com.example.chucknorrisapp.data.api.NetworkUtils
import retrofit2.http.GET

interface CategoriesEndpoint {
    @GET("categories")
    suspend fun getCategories(): List<String>

    companion object {
        val endpoint: CategoriesEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(CategoriesEndpoint::class.java)
        }
    }
}