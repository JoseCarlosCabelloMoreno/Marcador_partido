package com.example.marcador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marcador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val boton_mas_local=binding.boton1Local
        val boton_mas_2_local=binding.boton2Local
        val boton_menos_local=binding.botonMenosLocal
        val boton_mas_visitante=binding.boton1Visitante
        val boton_mas_2_visitante=binding.boton2Visitante
        val boton_maenos_visitante=binding.botonMenosVisitante
        val marcador_local=binding.LocalMarcador
        val marcador_visitante=binding.VisitanteMarcador


        val Marcador=marcador(marcador_local.text.toString(),marcador_visitante.text.toString())

        boton_mas_2_local.setOnClickListener{
            binding.LocalMarcador.text=sumar2("local", Marcador)
        }
        boton_mas_2_visitante.setOnClickListener{
            binding.VisitanteMarcador.text=sumar2("visitante", Marcador)
        }
    }

    private fun sumar2(vis:String, Marcador: marcador): String {
        if (vis=="local")
        {
            val local_sum=Marcador.local.toInt()+2
            Marcador.local=local_sum.toString()
            return local_sum.toString()
        }
        else{
            val visit_sum=Marcador.visitante.toInt()+2
            Marcador.visitante=visit_sum.toString()
            return visit_sum.toString()
        }
    }


}