package com.example.exemploapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.exemploapi.models.ApiResponseModel
import com.example.exemploapi.models.CharacterModel
import com.example.exemploapi.models.LocationModel
import com.example.exemploapi.repository.CharacterEndpoint
import com.example.exemploapi.repository.LocationEndpoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //fins de teste
        // var client = getRetrofitInstance(BASE_URL)

        httpClient = NetworkUtils.getRetrofitInstance(BASE_URL)

        var characterEndpoint = httpClient.create(CharacterEndpoint::class.java)
        var locationEndpoint = httpClient.create(LocationEndpoint::class.java)

        ObterPersonagens(characterEndpoint)

        ObterLocalizacao(locationEndpoint)


    }

    private fun ObterLocalizacao(locationEndpoint: LocationEndpoint) {
        locationEndpoint.obterLocalizacao().enqueue(object : Callback<ApiResponseModel<LocationModel>> {
            override fun onFailure(call: Call<ApiResponseModel<LocationModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<ApiResponseModel<LocationModel>>, response: Response<ApiResponseModel<LocationModel>>) {
                val resposta = response.body()
                val resultado = findViewById<TextView>(R.id.txtResultado)
                resultado.text = resposta!!.results[0].name
            }

        })
    }

    private fun ObterPersonagens(endpoint: CharacterEndpoint) {
        endpoint.obterPersonagens().enqueue(object : Callback<ApiResponseModel<CharacterModel>> {
            override fun onFailure(call: Call<ApiResponseModel<CharacterModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<ApiResponseModel<CharacterModel>>, response: Response<ApiResponseModel<CharacterModel>>) {
                val resultado = response.body()
                Toast.makeText(this@MainActivity, resultado!!.results[0].name, Toast.LENGTH_LONG).show()
            }

        })
    }


    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
        lateinit var httpClient: Retrofit
    }
}