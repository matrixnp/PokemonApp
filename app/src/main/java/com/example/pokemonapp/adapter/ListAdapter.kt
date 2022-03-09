package com.example.pokemonapp.adapter

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.pokemonapp.R
import com.example.pokemonapp.activity.PokemonDetails
import com.example.pokemonapp.model.Pokemon
import kotlinx.android.synthetic.main.list_item.view.*
import kotlinx.android.synthetic.main.list_item.view.image
import kotlinx.android.synthetic.main.pokemon_details.view.*


class ListAdapter(
    val context: Context,
    private val data: List<Pokemon?>,
    private val mRowLayout: Int
) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(mRowLayout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    Log.d(TAG, "LOG 1: " + data[position]!!.pokemoname + " " + data!![position]!!.types)

        holder.name?.text = context.resources.getString(R.string.name, data[position]?.pokemoname?.uppercase())
        Glide.with(context).load(data[position]?.sprites?.other?.home?.front_default).into(holder.image)
        holder.containerView.setOnClickListener {
            val intent = Intent(context, PokemonDetails::class.java)
            intent.putExtra("pokemon", data[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data!!.size
    }

    inner class ViewHolder(val containerView: View) : RecyclerView.ViewHolder(containerView) {

        val name = containerView.title
        val image = containerView.findViewById<ImageView>(R.id.image)
        val types = containerView.types




    }
}
