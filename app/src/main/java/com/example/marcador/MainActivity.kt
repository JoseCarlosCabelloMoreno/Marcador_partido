package com.example.marcador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marcador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val binding=ActivityMainBinding.inflate(layoutInflater)

    val boton_mas_local=binding.boton1Local
    val boton_mas_2_local=binding.boton2Local
    val boton_menos_local=binding.botonMenosLocal
    val boton_mas_visitante=binding.boton1Visitante
    val boton_mas_2_visitante=binding.boton2Visitante
    val boton_maenos_visitante=binding.botonMenosVisitante

    val marcador_local=binding.LocalMarcador
    val marcador_visitante=binding.VisitanteMarcador
}