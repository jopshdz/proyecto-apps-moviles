package com.saintleo.kidquest

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChildProfileSetupActivity : AppCompatActivity() {

    private var generoSeleccionado: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_child_profile_setup)

        val rootLayout = findViewById<android.view.View>(android.R.id.content)
        ViewCompat.setOnApplyWindowInsetsListener(rootLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dbHelper = KidQuestDbHelper(this)

        val ivSetupAvatar = findViewById<ImageView>(R.id.ivSetupAvatar)
        val etChildName = findViewById<EditText>(R.id.etChildName)
        val etChildAge = findViewById<EditText>(R.id.etChildAge)
        val etChildBirthday = findViewById<EditText>(R.id.etChildBirthday)
        val cvBoy = findViewById<CardView>(R.id.cvBoy)
        val cvGirl = findViewById<CardView>(R.id.cvGirl)
        val btnFinishSetup = findViewById<Button>(R.id.btnFinishSetup)

        ivSetupAvatar.setOnClickListener {
            Toast.makeText(this, "Abriendo selector de Avatares 3D...", Toast.LENGTH_SHORT).show()
        }


        cvBoy.setOnClickListener {
            generoSeleccionado = "NINO"
            cvBoy.setCardBackgroundColor(Color.parseColor("#00F0FF"))
            cvGirl.setCardBackgroundColor(Color.parseColor("#1A2035"))
        }

        cvGirl.setOnClickListener {
            generoSeleccionado = "NINA"
            cvGirl.setCardBackgroundColor(Color.parseColor("#FF4081"))
            cvBoy.setCardBackgroundColor(Color.parseColor("#1A2035"))
        }

        btnFinishSetup.setOnClickListener {
            val name = etChildName.text.toString().trim()
            val ageString = etChildAge.text.toString().trim()
            val birthday = etChildBirthday.text.toString().trim()

            if (name.isEmpty() || ageString.isEmpty() || birthday.isEmpty() || generoSeleccionado.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los datos y selecciona si eres niño o niña", Toast.LENGTH_SHORT).show()
            } else {
                val age = ageString.toIntOrNull() ?: 0
                val defaultAvatarId = R.drawable.ic_launcher_foreground

                val db = dbHelper.writableDatabase

                val values = ContentValues().apply {
                    put(KidProfileContract.ProfileEntry.COLUMN_NAME_NOMBRE, name)
                    put(KidProfileContract.ProfileEntry.COLUMN_NAME_EDAD, age)
                    put(KidProfileContract.ProfileEntry.COLUMN_NAME_CUMPLEANOS, birthday)
                    put(KidProfileContract.ProfileEntry.COLUMN_NAME_GENERO, generoSeleccionado)
                    put(KidProfileContract.ProfileEntry.COLUMN_NAME_AVATAR_ID, defaultAvatarId)
                    put(KidProfileContract.ProfileEntry.COLUMN_NAME_MONEDAS, 0)
                    put(KidProfileContract.ProfileEntry.COLUMN_NAME_FIREBASE_KEY, "")
                }

                val newRowId = db.insert(KidProfileContract.ProfileEntry.TABLE_NAME, null, values)

                if (newRowId != -1L) {
                    val sharedPreferences = getSharedPreferences("KidQuestPrefs", Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString("CHILD_NAME", name)
                    editor.apply()

                    Toast.makeText(this, "¡Perfil de $name guardado localmente en SQLite!", Toast.LENGTH_LONG).show()

                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Error crítico al guardar en la base de datos local", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}