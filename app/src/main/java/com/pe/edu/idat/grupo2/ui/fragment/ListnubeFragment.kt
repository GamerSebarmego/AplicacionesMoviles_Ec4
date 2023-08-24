package com.pe.edu.idat.grupo2.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pe.edu.idat.grupo2.R
import com.pe.edu.idat.grupo2.databinding.FragmentListnubeBinding
import com.pe.edu.idat.grupo2.ui.AddRecetasNubeActivity

class ListnubeFragment : Fragment() {
    lateinit var binding: FragmentListnubeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListnubeBinding.inflate(inflater,container,false)

        binding.fabAddReceta.setOnClickListener{
            val intent = Intent(requireContext(), AddRecetasNubeActivity::class.java)
            startActivity(intent)
        }

        return binding.root


    }
}