package com.example.chucknorrisapp.categories.repository

class CategoriesRepository {

    private val client = CategoriesEndpoint.endpoint

    suspend fun getCategories() = client.getCategories()
}