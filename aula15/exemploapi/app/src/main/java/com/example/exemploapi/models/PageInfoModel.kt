package com.example.exemploapi.models

data class PageInfoModel (
    val count: Int,
    val pages:Int,
    val next:String?,
    val prev:String?
)


/*
data class PageInfoModel (
    @SerializedName(count)
    val count: Int,
    val pages:Int,
    val next:String?,
    val prev:String?
)*/

//o certo é utilizar os nomes igual o da api mas
// caso queira personalizar o nome use o @SerializedName(nome do campo na api)
//e embaixo declare sua variavel normalmente

