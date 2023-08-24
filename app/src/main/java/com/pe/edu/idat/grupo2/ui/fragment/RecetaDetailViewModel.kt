package com.pe.edu.idat.grupo2.ui.fragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.pe.edu.idat.grupo2.data.db.RecetaDao
import com.pe.edu.idat.grupo2.data.db.RecetaDatabase
import com.pe.edu.idat.grupo2.data.repository.RecetaRepository
import com.pe.edu.idat.grupo2.model.Recetas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecetaDetailViewModel (application: Application):AndroidViewModel(application){
    private val repository:RecetaRepository

    init {
        val dao = RecetaDatabase.getDatabase(application).recetaDao()
        repository = RecetaRepository(dao)
    }
    //Aqui ya se agrega a favoritos
    fun addToFavorites(recetas: Recetas){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addToFavorites(recetas)
        }
    }

    fun deleteRecetas(recetas: Recetas){
        viewModelScope.launch {
            repository.deleteToFavorites(recetas)
        }
    }

}