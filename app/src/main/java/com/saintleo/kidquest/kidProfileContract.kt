package com.saintleo.kidquest

import android.provider.BaseColumns

object KidProfileContract {
    // Definimos la estructura de la tabla basada en nuestro análisis de datos
    object ProfileEntry : BaseColumns {
        const val TABLE_NAME = "perfil_nino"

        // El campo _ID ya viene incluido por heredar de BaseColumns
        const val COLUMN_NAME_NOMBRE = "nombre"
        const val COLUMN_NAME_EDAD = "edad"
        const val COLUMN_NAME_CUMPLEANOS = "cumpleanos"
        const val COLUMN_NAME_GENERO = "genero"
        const val COLUMN_NAME_AVATAR_ID = "avatar_id"
        const val COLUMN_NAME_MONEDAS = "monedas"
        const val COLUMN_NAME_FIREBASE_KEY = "firebase_key"
    }
}