package com.example.exemploapi.models

data class ApiResponseModel<T>(
    val info: PageInfoModel,
    val results:List<T>
)