package com.example.chucknorrisapp.jokes.repository


class JokesRepository {
    private val client = JokesEndpoint.endpoint

    suspend fun getJokes(category: String) = client.getJoke(category)

}