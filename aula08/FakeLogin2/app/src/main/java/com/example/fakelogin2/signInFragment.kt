package com.example.fakelogin2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.fakelogin2.users.UserService
import com.google.android.material.textfield.TextInputLayout
import java.lang.Exception

class signInFragment : Fragment() {
    private lateinit var viewSignIn : View
    /*private var param1: String? = null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            /*param1=it.getString("USERNAME")*/
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewSignIn= inflater.inflate(R.layout.fragment_sign_in, container, false)

        val btnlogin = viewSignIn.findViewById<Button>(R.id.btnLogInSingIn)
        btnlogin.setOnClickListener {
            val apelido = viewSignIn.findViewById<TextInputLayout>(R.id.textUsernameSignIn)
            val apelidoText = apelido.editText?.text.toString()
            val senha = viewSignIn.findViewById<TextInputLayout>(R.id.textPasswordSignIn)
            val senhaText=senha.editText?.text.toString()

            when {
                apelidoText.isEmpty() -> {
                    apelido.error="Preencha o username"
                }
                senhaText.isEmpty() -> {
                   senha.error="Preencha a password"
                }
                else -> {
                    try {
                        val user= UserService.logIn(apelidoText,senhaText)
                        if(user!=null){
                            Toast.makeText(viewSignIn.context,"Logado Viado", Toast.LENGTH_SHORT).show()
                            apelido.editText?.text?.clear()
                            senha.editText?.text?.clear()

                        }else{
                            Toast.makeText(viewSignIn.context,"Email ou senha incorretos", Toast.LENGTH_SHORT).show()
                            apelido.editText?.text?.clear()
                            senha.editText?.text?.clear()
                        }
                    }catch(e: Exception){
                        Toast.makeText(viewSignIn.context,e.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }


        return viewSignIn
    }

    companion object {
        @JvmStatic
        fun newInstance(username: String) =
            signInFragment().apply {
                arguments = Bundle().apply {
                    putString("USERNAME",username)
                }
            }
    }
}