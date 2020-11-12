package com.example.exemploapi.models

data class CharacterModel(
    val id:Int,
    val name: String,
    val status:String,
    val origin: OriginModel
)
