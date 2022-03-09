package com.example.pokemonapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Pokemon(
    @SerializedName("name")
    val pokemoname: String,
    val url: String,
    val sprites: Sprites,
    val stats: List<Stats>,
    val types: List<Types>
) : Serializable

data class Stats(
    val stat: Stat,
    val base_stat: Int
) : Serializable

data class Stat(
    @SerializedName("name")
    val statname: String
) : Serializable

data class Types(
    val type: Type
) : Serializable

data class Type(
    val name: String
) : Serializable









