package com.depri.day4_tyurin_usatenko

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
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
            "Матрицы",
            "Оно",
            "Время",
            "Драйв"
        )
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            movies
        )

        listView.adapter = adapter
    }
}