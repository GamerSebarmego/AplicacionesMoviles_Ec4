package com.pe.edu.idat.grupo2.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pe.edu.idat.grupo2.R
import com.pe.edu.idat.grupo2.databinding.FragmentListarApiBinding

class ListarApiFragment : Fragment() {
    private lateinit var binding:FragmentListarApiBinding
    private lateinit var viewModel:ListApiViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[ListApiViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListarApiBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RVRecetaAdapter(listOf()){receta ->
            val direcction = ListarApiFragmentDirections.actionListarApiFragmentToRecetaDetailFragment(receta)
            //controlador de recetas_grap
            findNavController().navigate(direcction) //Aqui ya podemos ir a la pantalla fragment detalle
            //findNavController().navigate(R.id.action_listarApiFragment_to_recetaDetailFragment)
        }
        binding.rvRecetas.adapter = adapter

        binding.rvRecetas.layoutManager = GridLayoutManager(requireContext(),2,
        RecyclerView.VERTICAL,false)

        viewModel.recetas.observe(requireActivity()){ recetas ->
            adapter.recetas = recetas

            adapter.notifyDataSetChanged()
        }
        viewModel.getRecetaFromService()

    }
}