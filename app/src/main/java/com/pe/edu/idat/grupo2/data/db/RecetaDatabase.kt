package com.pe.edu.idat.grupo2.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pe.edu.idat.grupo2.model.Recetas

@Database(entities = [Recetas::class], version = 1)
abstract class RecetaDatabase:RoomDatabase() {
    //Ahora se agrega el dao
    abstract fun recetaDao():RecetaDao

    companion object{
        private  var instance: RecetaDatabase? =null //Se crea la instancia de la base de datos

        fun getDatabase(context:Context):RecetaDatabase{
            val temp = instance
            if(temp != null){
                return temp
            }
            //Synchronized
            // Crea una nueva instancia y lo que hace es crear la BD en caso
            // no esta creada o traerá la referencia de la BD
            synchronized(this){
                val _instance = Room.databaseBuilder(
                    context.applicationContext,
                    RecetaDatabase::class.java,
                    "fastrecipedb"
                ).build()
                instance = _instance
                return  _instance

                //Finalización de seteo de la BD
            }
        }
    }

}