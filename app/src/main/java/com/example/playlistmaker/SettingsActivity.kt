package com.example.playlistmaker

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

//        enableEdgeToEdge()

        val backButton = findViewById<ImageView>(R.id.backSettings)
        backButton.setOnClickListener {
            finish()
        }
    }
}