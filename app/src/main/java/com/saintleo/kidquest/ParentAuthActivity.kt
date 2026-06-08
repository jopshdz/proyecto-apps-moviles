package com.saintleo.kidquest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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

        // Vinculamos los nuevos botones con los IDs correctos de tu XML
        val btnRegister = findViewById<Button>(R.id.btnRegisterGoogle)
        val btnLogin = findViewById<Button>(R.id.btnLoginGoogle)

        // ESCENARIO 1: BOTÓN DORADO (REGISTRO)
        btnRegister.setOnClickListener {
            Toast.makeText(this, "Iniciando registro con Google...", Toast.LENGTH_SHORT).show()

            // Nos lleva a la pantalla de llenar los datos del niño
            val intent = Intent(this, ChildProfileSetupActivity::class.java)
            startActivity(intent)

            // Si quieres que el usuario no pueda volver atrás con el botón físico de retroceso,
            // puedes descomentar la siguiente línea:
            // finish()
        }

        // ESCENARIO 2: BOTÓN AZUL (INICIO DE SESIÓN)
        btnLogin.setOnClickListener {
            Toast.makeText(this, "Recuperando datos de la nube...", Toast.LENGTH_SHORT).show()

            // Nos lleva directamente al selector de perfiles (ya registrados)
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            // Igual que arriba, puedes agregar finish() si deseas cerrar esta pantalla.
        }
    }
}