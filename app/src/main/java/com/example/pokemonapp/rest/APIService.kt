package com.example.pokemonapp.rest

import com.example.pokemonapp.model.Pokemon
import com.example.pokemonapp.model.PokemonList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {
    @GET("pokemon/?offset=0&limit=20")    //End Url
    fun fetchPokemons(): Call<PokemonList>

    @GET("pokemon/{name}")
    fun getPokemon(@Path("name")name :String): Call<Pokemon>
}
