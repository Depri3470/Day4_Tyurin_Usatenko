package com.depri.day4_tyurin_usatenko

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val movieName = intent.getStringExtra("movie_name") ?: "Неизвестный фильм"
        val movieDescription = intent.getStringExtra("movie_description")
        val tvTitle = findViewById<TextView>(R.id.tvMovieTitle)
        val tvDescription = findViewById<TextView>(R.id.tvMovieDescription)
        val btnBack = findViewById<Button>(R.id.btnBack)

        tvTitle.text = movieName
        tvDescription.text = movieDescription

        btnBack.setOnClickListener {
            finish()
        }
    }
}