package com.example.marcador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marcador.databinding.ActivityResultadosBinding

class Resultados : AppCompatActivity() {

    companion object {
        const val ResultadoKey="resultado"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)
        val binding=ActivityResultadosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle=intent.extras!!
        val marca=bundle.getParcelable<Marcadorc>(ResultadoKey)!!
        binding.marcador=marca
        binding.total.text=comparar(marca)
    }

    private fun comparar(mar: Marcadorc): String? {
        if (mar.local.toInt() > mar.visitante.toInt())
        {
            return "Gano el local"
        }
        if (mar.local.toInt() < mar.visitante.toInt())
        {
            return "Gano el visitante"
        }
        else{
            return "Empate"
        }
    }

}