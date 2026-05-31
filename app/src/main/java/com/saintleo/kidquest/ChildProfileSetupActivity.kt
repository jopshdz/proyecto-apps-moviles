package com.saintleo.kidquest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChildProfileSetupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_child_profile_setup)

        // CORRECCIÓN: Usamos android.R.id.content (el contenedor nativo de la pantalla)
        val rootLayout = findViewById<android.view.View>(android.R.id.content)
        ViewCompat.setOnApplyWindowInsetsListener(rootLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Vincular los componentes visuales
        val ivSetupAvatar = findViewById<ImageView>(R.id.ivSetupAvatar)
        val etChildName = findViewById<EditText>(R.id.etChildName)
        val etChildAge = findViewById<EditText>(R.id.etChildAge)
        val etChildBirthday = findViewById<EditText>(R.id.etChildBirthday)
        val btnFinishSetup = findViewById<Button>(R.id.btnFinishSetup)

        // Acción al tocar el Avatar
        ivSetupAvatar.setOnClickListener {
            Toast.makeText(this, "Abriendo selector de Avatares 3D...", Toast.LENGTH_SHORT).show()
        }

        // Lógica del botón finalizar
        btnFinishSetup.setOnClickListener {
            val name = etChildName.text.toString().trim()
            val age = etChildAge.text.toString().trim()
            val birthday = etChildBirthday.text.toString().trim()

            if (name.isEmpty() || age.isEmpty() || birthday.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los datos del perfil", Toast.LENGTH_SHORT).show()
            } else {
                // Guardar el nombre localmente
                val sharedPreferences = getSharedPreferences("KidQuestPrefs", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("CHILD_NAME", name)
                editor.apply()

                Toast.makeText(this, "¡Perfil de $name creado exitosamente!", Toast.LENGTH_SHORT).show()

                // Redirigir al Login (Tablero de Selección de Perfiles)
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}