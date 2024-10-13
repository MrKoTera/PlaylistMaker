package com.example.playlistmaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val backButton = findViewById<ImageView>(R.id.backSettings)
        backButton.setOnClickListener {
            finish()
        }

        val shareAppButton = findViewById<TextView>(R.id.button_share_app)
        val supportButton = findViewById<TextView>(R.id.button_support)
        val termsButton = findViewById<TextView>(R.id.button_terms)

        shareAppButton.setOnClickListener {
            shareApp()
        }

        supportButton.setOnClickListener {
            writeToSupport()
        }

        termsButton.setOnClickListener {
            openTerms()
        }
    }

    private fun shareApp() {
        val shareMessage = getString(R.string.share_message)
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, shareMessage)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(Intent.createChooser(intent, getString(R.string.share_app)))
        } else {
            Toast.makeText(this, "Нет доступных приложений для шаринга", Toast.LENGTH_SHORT).show()
        }
    }

    private fun writeToSupport() {
        val email = getString(R.string.support_email)
        val subject = getString(R.string.support_subject)
        val body = getString(R.string.support_body)

        val uriText = "mailto:$email" +
                "?subject=" + Uri.encode(subject) +
                "&body=" + Uri.encode(body)
        val uri = Uri.parse(uriText)

        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = uri
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Нет доступных почтовых клиентов", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openTerms() {
        val url = getString(R.string.terms_url)
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
            addCategory(Intent.CATEGORY_BROWSABLE)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Нет доступных браузеров", Toast.LENGTH_SHORT).show()
        }
    }
}
