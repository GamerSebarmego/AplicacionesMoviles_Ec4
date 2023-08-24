package com.pe.edu.idat.grupo2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.pe.edu.idat.grupo2.R
import com.google.firebase.firestore.ktx.firestore
import androidx.activity.contextaware.withContextAvailable
import com.google.firebase.ktx.Firebase
import com.pe.edu.idat.grupo2.databinding.ActivityAddRecetasNubeBinding

class AddRecetasNubeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddRecetasNubeBinding
    private lateinit var firestore: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firestore = Firebase.firestore
        binding = ActivityAddRecetasNubeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegisterReceta.setOnClickListener {
            val mael = binding.tilStrMael.editText?.text.toString()
            val category = binding.tilStrCategory.editText?.text.toString()
            val area = binding.tilStrArea.editText?.text.toString()
            val instruction = binding.tilStrInstructions.editText?.text.toString()
            val image = binding.tilStrimage.editText?.text.toString()
            val isFavorite = binding.switchFavorite.isChecked

            if (mael.isNotEmpty() && category.isNotEmpty() && area.isNotEmpty() && instruction.isNotEmpty() && image.isNotEmpty()){
                addRecetaToFirestore(mael,category,area,instruction,image,isFavorite)
            }
        }
        getRecetas()

    }
    private fun addRecetaToFirestore(
        mael: String,
        category: String,
        area: String,
        instruction: String,
        image: String,
        favorite: Boolean
    ) {
        val receta = hashMapOf<String, Any>(
            "mael" to mael,
            "category" to category,
            "area" to area,
            "instruction" to instruction,
            "isFavorite" to favorite,
            "image" to image
        )
        firestore.collection("Recetas").add(receta)
            .addOnSuccessListener {
                Toast.makeText(this,"Receta Agregada: ${it.id}",Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener{
                Toast.makeText(this, "Ocurrio un error", Toast.LENGTH_SHORT).show()
            }

    }
    private fun getRecetas(){
        firestore.collection("Recetas").whereEqualTo("isFavorite", true).get()
            .addOnSuccessListener {
                val recetas = it.documents
                for (document in recetas){
                    Log.d("Recetas",document.id)
                }
            }
            .addOnFailureListener{}

    }

}