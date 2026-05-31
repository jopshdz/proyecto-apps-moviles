package com.saintleo.kidquest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Vincular componentes visuales
        val cardParent = findViewById<CardView>(R.id.cardParent)
        val cardChild = findViewById<CardView>(R.id.cardChild)
        val tvChildNameSelection = findViewById<TextView>(R.id.tvChildNameSelection)

        // 1. Leer el nombre guardado desde SharedPreferences
        val sharedPreferences = getSharedPreferences("KidQuestPrefs", Context.MODE_PRIVATE)

        // Buscamos "CHILD_NAME". Si no existe nada guardado, usará "Ariel" por defecto.
        val savedChildName = sharedPreferences.getString("CHILD_NAME", "Ariel")

        // 2. Asignamos el nombre recuperado al TextView de la tarjeta
        tvChildNameSelection.text = savedChildName

        // Configurar los clics
        cardParent.setOnClickListener {
            Toast.makeText(this, "Abriendo Portal de Padres...", Toast.LENGTH_SHORT).show()
        }

        cardChild.setOnClickListener {
            // Usamos la variable con el nombre dinámico también en el Toast
            Toast.makeText(this, "¡Entrando al mundo de $savedChildName!", Toast.LENGTH_SHORT).show()
        }
    }
}