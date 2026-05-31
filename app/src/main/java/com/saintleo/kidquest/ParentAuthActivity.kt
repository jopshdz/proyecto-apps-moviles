package com.saintleo.kidquest

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ParentAuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_parent_auth)

        // CORRECCIÓN: Evitamos la referencia rota usando el ID nativo
        val rootLayout = findViewById<android.view.View>(android.R.id.content)
        ViewCompat.setOnApplyWindowInsetsListener(rootLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnGoogleSignIn = findViewById<CardView>(R.id.btnGoogleSignIn)

        btnGoogleSignIn.setOnClickListener {
            Toast.makeText(this, "Sesión iniciada con éxito", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, ChildProfileSetupActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}