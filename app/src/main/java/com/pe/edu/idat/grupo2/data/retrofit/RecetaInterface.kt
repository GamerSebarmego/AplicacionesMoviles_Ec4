package com.pe.edu.idat.grupo2.data.retrofit

import com.pe.edu.idat.grupo2.data.response.ListaRecetaResponse
import retrofit2.http.GET

interface RecetaInterface {
    @GET("api/json/v1/1/search.php?s")
    suspend fun getAllRecetas(): ListaRecetaResponse
}