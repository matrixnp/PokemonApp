package com.example.pokemonapp.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonapp.adapter.ListAdapter
import com.example.pokemonapp.model.Pokemon
import com.example.pokemonapp.model.PokemonList
import com.example.pokemonapp.rest.APIService
import com.example.pokemonapp.rest.RestClient
import com.example.pokemonapp.R
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var mApiService: APIService

    private var mAdapter: ListAdapter? = null
    private var data: MutableList<Pokemon?> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listRecyclerView!!.layoutManager =
            LinearLayoutManager(this)

        mAdapter = ListAdapter(this, data, R.layout.list_item)
        listRecyclerView!!.adapter = mAdapter
        mApiService = RestClient.client?.create(APIService::class.java)

        fetchPokemons()
    }

    private fun fetchPokemons() {
        val call = mApiService.fetchPokemons()
        call.enqueue(object : Callback<PokemonList> {

            override fun onResponse(call: Call<PokemonList>, response: Response<PokemonList>) {

                val pokemons = response.body()

                if (pokemons != null) {

                    for (i in pokemons.results!!){
                        val call2 = mApiService.getPokemon(i.pokemoname)
                         call2.enqueue(object : Callback<Pokemon>{
                             override fun onResponse(
                                 call: Call<Pokemon>,
                                 response: Response<Pokemon>
                             ) {
                                 data.add(response.body())
                                 mAdapter?.notifyDataSetChanged()
                             }

                             override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                                 Log.d(TAG, "onFailure: "+ t.localizedMessage)
                                 Toast.makeText(
                                     applicationContext,
                                     "Got error : " + t.localizedMessage,
                                     Toast.LENGTH_SHORT
                                 ).show()
                             }

                         } )
                    }
                }
                Log.d(TAG, "All Pokemons: " + data.toString())

            }

            override fun onFailure(call: Call<PokemonList>, t: Throwable) {
                Toast.makeText(
                    applicationContext,
                    "Got error : " + t.localizedMessage,
                    Toast.LENGTH_SHORT
                ).show()
            }

        })


    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}
