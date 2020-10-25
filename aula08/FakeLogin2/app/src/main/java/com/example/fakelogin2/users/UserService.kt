package com.example.fakelogin2.users

import java.lang.Exception

class UserService {
    companion object {

        private val users = arrayListOf<UserModel>()

        /**
         * Realiza login
         */
        fun logIn(username: String, password: String): UserModel? {
            return users.find {
                it.username == username.toLowerCase().trim() && it.password == password
            }
        }

        /**
         * Registra um usuário
         */
        fun register(username: String, password: String, passwordConfirm: String) {
            // Verifica se já existe usuário com email cadastrado
            val user = users.find {
                it.username == username.toLowerCase().trim()
            }

            if (user != null) {
                throw Exception("E-mail já cadastrado!")
            }

            //Verifica senha
            if(password!=passwordConfirm){
                throw Exception("Senhas diferentes!")
            }
                        
            users.add(UserModel(username.toLowerCase().trim(), password))
        }
    }
}