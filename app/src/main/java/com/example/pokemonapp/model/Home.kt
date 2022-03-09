package com.example.pokemonapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Home(
    @SerializedName("front_default")
    val front_default: String

): Serializable
