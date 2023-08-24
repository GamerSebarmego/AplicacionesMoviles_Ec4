package com.pe.edu.idat.grupo2.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.pe.edu.idat.grupo2.R
import com.pe.edu.idat.grupo2.databinding.ItemRecetaBinding
import com.pe.edu.idat.grupo2.model.Recetas

class RVRecetaAdapter(var recetas :List<Recetas>, val onClickReceta: (Recetas) -> Unit): RecyclerView.Adapter<RecetaRV>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetaRV {
        //Asignar la vista y mandarlo al view holder
        val binding = ItemRecetaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RecetaRV(binding,onClickReceta)//onclickReceta se pasa como referencia desde el recycler view
    }

    override fun getItemCount():Int = recetas.size //Colocar cantidad de Items tendra la lista

    override fun onBindViewHolder(holder: RecetaRV, position: Int) {
        //Colocar los elementos de la data en la vista
        holder.bind(recetas[position])
    }
}

class RecetaRV(private val binding: ItemRecetaBinding, val onClickReceta: (Recetas) -> Unit):RecyclerView.ViewHolder(binding.root){
    fun bind(recetas: Recetas) {
        binding.txtRecetaName.text = recetas.strMeal
        binding.txtRecetaCategory.text = recetas.strCategory
        binding.txtRecetaLugar.text = recetas.strArea

        if(recetas.strMealThumb.isNotEmpty()){
            binding.imageReceta.load(recetas.strMealThumb)
        }
        else{
            binding.imageReceta.setImageResource(R.drawable.prueba_image)
        }

        if (recetas.isFavorite){
            binding.btnFavorite.setImageResource(R.drawable.baseline_favorite_24)
        }
        else{
            binding.btnFavorite.setImageResource(R.drawable.ic_favorite_border)
        }

        binding.root.setOnClickListener {
            onClickReceta(recetas)//Aqui ya se está ejecutando
        }
    }
}