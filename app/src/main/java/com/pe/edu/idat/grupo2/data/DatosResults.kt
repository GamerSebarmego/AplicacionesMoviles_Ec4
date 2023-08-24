package com.pe.edu.idat.grupo2.data

sealed class DatosResults<T> (data : T? = null, error : Exception? = null){
    data class Success<T>(val data : T): DatosResults<T>(data, null)
    data class Error<T>(val error : Exception): DatosResults<T>(null,error)
}