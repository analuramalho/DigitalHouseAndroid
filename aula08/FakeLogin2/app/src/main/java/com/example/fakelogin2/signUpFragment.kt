package com.example.fakelogin2

import android.icu.text.UnicodeSet
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.example.fakelogin2.users.UserService
import com.google.android.material.textfield.TextInputLayout
import java.lang.Exception

class signUpFragment : Fragment() {
    private  lateinit var viewSignUp: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewSignUp= inflater.inflate(R.layout.fragment_sign_up, container, false)

        val btnSignUp = viewSignUp.findViewById<Button>(R.id.btnSignUpSignUp)
        btnSignUp.setOnClickListener {
            val apelido = viewSignUp.findViewById<TextInputLayout>(R.id.textUsernameSignUp)
            val apelidoText = apelido.editText?.text.toString()
            val senha = viewSignUp.findViewById<TextInputLayout>(R.id.textPasswordSignUp)
            val senhaText=senha.editText?.text.toString()
            val senhaConfirmacao = viewSignUp.findViewById<TextInputLayout>(R.id.textConfirmPasswordSignUp)
            val senhaConfirmacaoText=senhaConfirmacao.editText?.text.toString()

            when {
                apelidoText.isEmpty() -> {
                    apelido.error="Preencha o username"
                }
                senhaText.isEmpty() -> {
                    senha.error="Preencha a password"
                }
                senhaConfirmacaoText.isEmpty() -> {
                    senhaConfirmacao.error="Preencha a password"
                }
                else -> {
                    try {
                        UserService.register(apelidoText,senhaText,senhaConfirmacaoText)
                        Toast.makeText(viewSignUp.context,"Usuário Cadastrado com sucesso ",Toast.LENGTH_LONG).show()
                    }catch(e: Exception){
                        Toast.makeText(viewSignUp.context,e.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        val ckSignUp= viewSignUp.findViewById<CheckBox>(R.id.ckIagree)
        ckSignUp.setOnCheckedChangeListener{_,isChecked ->
            btnSignUp.isEnabled=isChecked
        }

        return viewSignUp
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            signUpFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}