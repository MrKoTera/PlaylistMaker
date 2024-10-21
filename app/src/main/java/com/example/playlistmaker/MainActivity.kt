package com.example.playlistmaker

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchButton = findViewById<Button>(R.id.buttonSearch)
        searchButton.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
        
        val mediaButton = findViewById<Button>(R.id.buttonMedia)
        mediaButton.setOnClickListener {
            val intent = Intent(this, MediaActivity::class.java)
            startActivity(intent)
        }

        val settingsButton = findViewById<Button>(R.id.buttonSettings)
        settingsButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}