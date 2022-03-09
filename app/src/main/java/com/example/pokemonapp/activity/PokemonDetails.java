package com.example.pokemonapp.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.pokemonapp.R;
import com.example.pokemonapp.model.Pokemon;

import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

public class PokemonDetails extends AppCompatActivity {
    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_details);
        TextView textView = findViewById(R.id.name);
        TextView textView1 = findViewById(R.id.hp);
        TextView textView2 = findViewById(R.id.attack);
        TextView textView3 = findViewById(R.id.defense);
        TextView textView4 = findViewById(R.id.special_attack);
        TextView textView5 = findViewById(R.id.special_defense);
        TextView textView6 = findViewById(R.id.speed);
        TextView textView7 = findViewById(R.id.types);
        TextView textView8 = findViewById(R.id.type);
        ImageView imageView = findViewById(R.id.image);

        Intent intent = getIntent();

        Pokemon pokemon = (Pokemon) intent.getSerializableExtra("pokemon");

        textView.setText(pokemon.getPokemoname().toUpperCase(Locale.ROOT));
        Glide.with(this).load(pokemon.getSprites().getOther().getHome().getFront_default()).into(imageView);
        textView1.setText(String.format("%s - %d", pokemon.getStats().get(0).getStat().getStatname(),
                pokemon.getStats().get(0).getBase_stat()));
        textView2.setText(String.format("%s - %d", pokemon.getStats().get(1).getStat().getStatname(),
                pokemon.getStats().get(1).getBase_stat()));
        textView3.setText(String.format("%s - %d", pokemon.getStats().get(2).getStat().getStatname(),
                pokemon.getStats().get(2).getBase_stat()));
        textView4.setText(String.format("%s - %d", pokemon.getStats().get(3).getStat().getStatname(),
                pokemon.getStats().get(3).getBase_stat()));
        textView5.setText(String.format("%s - %d", pokemon.getStats().get(4).getStat().getStatname(),
                pokemon.getStats().get(4).getBase_stat()));
        textView6.setText(String.format("%s - %d", pokemon.getStats().get(5).getStat().getStatname(),
                pokemon.getStats().get(5).getBase_stat()));

        if (pokemon.getPokemoname().equals("charmeleon")) {

            textView7.setText(pokemon.getTypes().get(0).getType().getName());
        } else if (pokemon.getPokemoname().equals("charmander")) {
            textView7.setText(pokemon.getTypes().get(0).getType().getName());

        } else if (pokemon.getPokemoname().equals("caterpie")) {
            textView7.setText(pokemon.getTypes().get(0).getType().getName());

        } else if (pokemon.getPokemoname().equals("squirtle")) {
            textView7.setText(pokemon.getTypes().get(0).getType().getName());

        } else if (pokemon.getPokemoname().equals("wartortle")) {
            textView7.setText(pokemon.getTypes().get(0).getType().getName());

        } else if (pokemon.getPokemoname().equals("metapod")) {
            textView7.setText(pokemon.getTypes().get(0).getType().getName());

        } else if (pokemon.getPokemoname().equals("blastoise")) {
            textView7.setText(pokemon.getTypes().get(0).getType().getName());

        } else if (pokemon.getPokemoname().equals("rattata")) {
            textView7.setText(pokemon.getTypes().get(0).getType().getName());

        } else if (pokemon.getPokemoname().equals("raticate")) {
            textView7.setText(pokemon.getTypes().get(0).getType().getName());

        } else {
            textView7.setText(pokemon.getTypes().get(0).getType().getName());
            textView8.setText(pokemon.getTypes().get(1).getType().getName());
        }

    }
}
