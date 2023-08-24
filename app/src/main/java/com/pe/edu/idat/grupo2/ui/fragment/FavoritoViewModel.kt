package com.pe.edu.idat.grupo2.ui.fragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.pe.edu.idat.grupo2.data.db.RecetaDatabase
import com.pe.edu.idat.grupo2.data.repository.RecetaRepository
import com.pe.edu.idat.grupo2.model.Recetas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritoViewModel(application: Application):AndroidViewModel(application) {
    private val repository: RecetaRepository
    private val _favorites:MutableLiveData<List<Recetas>> = MutableLiveData()
    val favorites:LiveData<List<Recetas>> = _favorites

    init {
        val dao = RecetaDatabase.getDatabase(application).recetaDao()
        repository = RecetaRepository(dao)
    }
    fun getFavorities(){
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getFavorites()
            data?.let{
                _favorites.postValue(it)
            }
        }
    }
}