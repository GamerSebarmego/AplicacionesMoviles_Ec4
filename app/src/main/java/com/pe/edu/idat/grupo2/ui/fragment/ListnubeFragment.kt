package com.pe.edu.idat.grupo2.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pe.edu.idat.grupo2.R
import com.pe.edu.idat.grupo2.databinding.FragmentListarApiBinding
import com.pe.edu.idat.grupo2.databinding.FragmentListnubeBinding

class ListnubeFragment : Fragment() {
    lateinit var binding: FragmentListnubeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListnubeBinding.inflate(inflater,container,false)
        return binding.root
    }
}