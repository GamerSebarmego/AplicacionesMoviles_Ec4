package com.pe.edu.idat.grupo2.ui.fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.pe.edu.idat.grupo2.R
import com.pe.edu.idat.grupo2.databinding.FragmentAccountBinding
import com.pe.edu.idat.grupo2.ui.LoginActivity


class AccountFragment : Fragment() {
    private lateinit var binding: FragmentAccountBinding
    // Se recoge el Shared Preferences de la clase Login
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var firebaseAuth: FirebaseAuth
    //Generacion de la variable para recibir la EMAIL_DATA
    private lateinit var email: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Se recoge la data de SHaredPreferences a traves de la SESSION_PREFERENCES_KEY
        sharedPreferences=requireActivity().getSharedPreferences(LoginActivity.SESSION_PREFERENCES_KEY, Context.MODE_PRIVATE)
        //Se guarda la EMAIL_DATA en la variable email
        email=sharedPreferences.getString(LoginActivity.EMAIL_DATA,"") ?:""
        //Inicializando el firebaseAuth
        firebaseAuth= Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAccountBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtemail.text=email
        /*Al dar clic al boton se activara dicha secuencia de procesos:
        1) Se editara la EMAIL_DATA y se dejara vacio ""
        2) Se aplica el edit con el apply
        3) Se le indica al firebase que cierre sesion en la app
        4) Se redirige a la pantalla de Login
        
        */
        binding.btnLogout.setOnClickListener{
            with(sharedPreferences.edit()){
                putString(LoginActivity.EMAIL_DATA,"")
                apply()
            }
            firebaseAuth.signOut()
            goToLogin()
        }
    }

    private fun goToLogin() {
        val intent= Intent(requireActivity(), LoginActivity::class.java)
        requireActivity().startActivity(intent)
        requireActivity().finish()
    }

}
