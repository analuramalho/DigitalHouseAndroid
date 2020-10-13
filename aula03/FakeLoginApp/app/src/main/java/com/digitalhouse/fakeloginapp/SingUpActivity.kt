package com.digitalhouse.fakeloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.digitalhouse.fakeloginapp.users.UserService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sing_up.*

class SingUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)

        ckSignUp.setOnCheckedChangeListener{_,isChecked ->
            btnSingUp.isEnabled = isChecked
        }

        btnLoginSingUp.setOnClickListener {
            finish()
        }

        btnSingUp.setOnClickListener {
            val name= edtNomeSingUp.text.toString()
            val email= edtEmailSingUp.text.toString()
            val password= edtSenhaSingUp.text.toString()

            if(name.isEmpty()){
                edtNomeSingUp.error="Preencha o nome"
            }else if (email.isEmpty()){
                edtEmailSingUp.error="Preencha o email"
            }else if (password.isEmpty()){
                edtSenhaSingUp.error="Preencha a senha"
            }else{
                try{
                    UserService.register(name,email,password)
                    Toast.makeText(this,"Usuário Cadastrado com sucesso ",Toast.LENGTH_LONG).show()
                    finish()
                }catch(e: Exception){
                    Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}