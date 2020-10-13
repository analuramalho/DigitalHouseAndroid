package com.digitalhouse.fakeloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.digitalhouse.fakeloginapp.users.UserService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sing_up.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCreateAccount.setOnClickListener {
            val intent= Intent(this,SingUpActivity::class.java)
            startActivity(intent)

            edtEmail.text.clear()
            edtSenha.text.clear()
        }

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtSenha.text.toString()

            when {
                email.isEmpty() -> {
                    edtEmail.error="Preencha o email"
                }
                password.isEmpty() -> {
                    edtSenha.error="Preencha a senha"
                }
                else -> {
                    try{
                        val user= UserService.logIn(email,password)
                        if(user != null ){
                            val intent= Intent(this,WelcomeActivity::class.java)
                            intent.putExtra("NOME", user.name )
                            startActivity(intent)

                            edtEmail.text.clear()
                            edtSenha.text.clear()
                        }else{
                            Toast.makeText(this,"Email ou senha incorretos", Toast.LENGTH_SHORT).show()

                            edtEmail.text.clear()
                            edtSenha.text.clear()
                        }
                    }catch(e: Exception){
                        Toast.makeText(this,e.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}