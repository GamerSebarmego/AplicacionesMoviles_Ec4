package com.pe.edu.idat.grupo2.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pe.edu.idat.grupo2.R
import com.pe.edu.idat.grupo2.databinding.FragmentFavoritoBinding

class FavoritoFragment : Fragment() {
    private lateinit var binding: FragmentFavoritoBinding
    private lateinit var viewModel: FavoritoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[FavoritoViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavoritoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RVRecetaAdapter(listOf()){receta ->
            val direcction = FavoritoFragmentDirections.actionFavoritoFragmentToRecetaDetailFragment(receta)
            //controlador de recetas_grap
            findNavController().navigate(direcction) //Aqui ya podemos ir a la pantalla fragment detalle
        }
        binding.rvFavorites.adapter = adapter

        binding.rvFavorites.layoutManager = GridLayoutManager(requireContext(),2,
            RecyclerView.VERTICAL,false)

        viewModel.favorites.observe(requireActivity()){ recetas ->
            adapter.recetas = recetas

            adapter.notifyDataSetChanged()
        }
        viewModel.getFavorities()//Aqui se llama al evento para mostrarse la lista de favoritos
    }
}