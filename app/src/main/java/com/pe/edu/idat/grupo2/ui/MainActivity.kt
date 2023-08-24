package com.pe.edu.idat.grupo2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.pe.edu.idat.grupo2.R
import com.pe.edu.idat.grupo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = supportFragmentManager.findFragmentById(R.id.fcv_navigation) as NavHostFragment
        val navController = fragment.navController
        binding.bnvinferior.setupWithNavController(navController)

        /*
        binding.fabAddReceta.setOnClickListener{
            val intent = Intent(this, AddRecetasNubeActivity::class.java)
            startActivity(intent)
        }*/
    }

}