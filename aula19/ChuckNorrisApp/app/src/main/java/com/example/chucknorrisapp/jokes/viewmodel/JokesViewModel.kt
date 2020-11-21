package com.example.chucknorrisapp.jokes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.chucknorrisapp.categories.repository.CategoriesRepository
import com.example.chucknorrisapp.jokes.model.JokesModel
import com.example.chucknorrisapp.jokes.repository.JokesRepository
import kotlinx.coroutines.Dispatchers

class JokesViewModel(
    private val repository: JokesRepository
) :ViewModel(){
    var joke : JokesModel?=null

    fun getJokes(category: String) = liveData(Dispatchers.IO) {
        val response = repository.getJokes(category)
        joke = response
        emit(response)
    }

    class JokeViewModelFactory(
        private val repository: JokesRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return JokesViewModel(repository) as T
        }

    }
}