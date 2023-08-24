package com.pe.edu.idat.grupo2.data.repository

import com.pe.edu.idat.grupo2.data.DatosResults
import com.pe.edu.idat.grupo2.data.db.RecetaDao
import com.pe.edu.idat.grupo2.data.response.ListaRecetaResponse
import com.pe.edu.idat.grupo2.data.retrofit.RetrofitHelper
import com.pe.edu.idat.grupo2.model.Recetas

//Implementacion del DAO agregando "val" y creando dos funciones
class RecetaRepository(val recetaDao:RecetaDao? = null) {
    suspend fun getRecetas():DatosResults<ListaRecetaResponse>{
        return try {
            val response = RetrofitHelper.recetaInstance.getAllRecetas()
            DatosResults.Success(response)
        }catch (e: Exception){
            DatosResults.Error(e)
        }
    }

    //1 trae favoritos
    suspend fun getFavorites(): List<Recetas>? {
        return recetaDao?.getFavorites()
    }
    //2 agrega favoritos
    suspend fun addToFavorites(recetas:Recetas){
        recetaDao?.addToFavorite(recetas)
    }

    //3 Delete de favoritos
    suspend fun deleteToFavorites(recetas:Recetas){
        recetaDao?.deleteFavorite(recetas)
    }
}