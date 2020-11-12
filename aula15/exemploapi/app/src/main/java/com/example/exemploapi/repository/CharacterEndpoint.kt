package com.example.exemploapi.repository

import retrofit2.Call
import com.example.exemploapi.models.ApiResponseModel
import com.example.exemploapi.models.CharacterModel
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterEndpoint {
    @GET("character")
    fun obterPersonagens(): Call<ApiResponseModel<CharacterModel>>

    @GET ("character/{id")
    fun obterPersonagensDetalhe(@Path("id") id:Int):Call<CharacterModel>
}