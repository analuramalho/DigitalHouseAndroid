package com.example.exemploapi.repository

import com.example.exemploapi.models.ApiResponseModel
import com.example.exemploapi.models.LocationModel
import retrofit2.Call
import retrofit2.http.GET

interface LocationEndpoint {
    @GET("location")
    fun obterLocalizacao(): Call<ApiResponseModel<LocationModel>>
}