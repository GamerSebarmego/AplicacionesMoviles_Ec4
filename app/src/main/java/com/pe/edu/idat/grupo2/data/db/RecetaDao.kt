package com.pe.edu.idat.grupo2.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pe.edu.idat.grupo2.model.Recetas

@Dao //Para que la interface se use como dao
interface RecetaDao {
    // Aqui se agregan todas las funciones del CRUD o llamar un query

    @Query("Select * from receta")
    suspend fun getFavorites(): List<Recetas>

    //En casos de conflictos de insercion de dato usar "onConflict"
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addToFavorite(recetas:Recetas)

    @Delete
    suspend fun deleteFavorite(recetas:Recetas)


}