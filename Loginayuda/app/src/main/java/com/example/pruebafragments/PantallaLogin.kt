package com.example.pruebafragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar

class Cliente (usuario:String,password:String){
    var users = usuario
    var passwords = password
}

class PantallaLogin : Fragment() {

    companion object {
        fun newInstance() = PantallaLogin()
    }

    private lateinit var viewModel: PantallaLoginViewModel

    lateinit var button: Button
    lateinit var button2: Button
    lateinit var User : EditText
    lateinit var Password : EditText
    lateinit var datoUser : String
    lateinit var datoPassword : String
    var listaCliente: List<Cliente> = listOf(Cliente("floppy","cricri"),Cliente("drito","tomasito"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pantalla_login, container, false)

        button = view.findViewById(R.id.botonLogin)
        button2 = view.findViewById(R.id.botonSignup)

        button.setOnClickListener {
            User = view.findViewById(R.id.user)
            Password = view.findViewById(R.id.password)
            datoUser = User.text.toString()
            datoPassword = Password.text.toString()

            if (datoUser == listaCliente[0].users && datoPassword == listaCliente[0].passwords) {
                val snackbarAprobado1 = Snackbar.make(it, "Login Correcto", Snackbar.LENGTH_SHORT)
                snackbarAprobado1.show()
            } else if (datoUser == listaCliente[1].users && datoPassword == listaCliente[1].passwords) {
                val snackbarAprobado1 = Snackbar.make(it, "Login Correcto", Snackbar.LENGTH_SHORT)
                snackbarAprobado1.show()
            } else {
                val snackbarDenegado = Snackbar.make(it, "Login Incorrecto", Snackbar.LENGTH_SHORT)
                snackbarDenegado.show()
            }
        }

        button2.setOnClickListener {
            findNavController().navigate(R.id.pantallaRegister)
        }

        return view
    }



}


