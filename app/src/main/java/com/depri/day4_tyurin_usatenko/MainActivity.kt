package com.depri.day4_tyurin_usatenko

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listView = findViewById<ListView>(R.id.listViewMovies)
        val movies = listOf(
            "Начало",
            "Бегущий по лезвию 2049",
            "Матрица",
            "Оно",
            "Время",
            "Драйв"
        )
        val movieDescription = mapOf(
            "Начало" to "Фильм о воре, который крадёт секреты из подсознания во время сна.",
            "Бегущий по лезвию 2049" to "К раскрывает давнюю тайну, которая может разрушить границу между людьми и репликантами и поставить под угрозу общество.",
            "Матрица" to "Хакер узнаёт шокирующую правду о реальности",
            "Оно" to "Группа подростков противостоит древнему злу в облике клоуна Пеннивайза.",
            "Время" to "Мужчина ищет способ спасти дочь, пока трудовые часы заменяют деньги, а время становится главной валютой.",
            "Драйв" to "Безымянный водитель-каскадёр по ночам работает на грабителей, но случайная доброта к соседке втягивает его в смертельную игру с мафией."
        )
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            movies
        )

        listView.adapter = adapter

        listView.setOnItemClickListener{ parent, view, position, id ->
            val selectedMovie = movies[position]
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("movie_name", selectedMovie)
            intent.putExtra("movie_description", movieDescription[selectedMovie])
            startActivity(intent)
        }
    }
}