package com.pe.edu.idat.grupo2.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pe.edu.idat.grupo2.data.DatosResults
import com.pe.edu.idat.grupo2.data.repository.RecetaRepository
import com.pe.edu.idat.grupo2.model.Recetas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListApiViewModel:ViewModel() {
    private val _recetas : MutableLiveData<List<Recetas>> = MutableLiveData<List<Recetas>>()
    val recetas:LiveData<List<Recetas>> = _recetas
    val repository = RecetaRepository()


    //CoRutinas
    fun getRecetaFromService(){
        viewModelScope.launch (Dispatchers.IO){
            val response = repository.getRecetas()

            when(response){
                is DatosResults.Success ->{
                    _recetas.postValue(response.data.meals)
                }
                is DatosResults.Error ->{

                }
            }
        }
    }
}