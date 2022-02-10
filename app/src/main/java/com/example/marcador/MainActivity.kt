package com.example.marcador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        val restart_boton=binding.botonReset
        val siguinete_boton=binding.botonResultado


        val Marcador=Marcadorc(marcador_local.text.toString(),marcador_visitante.text.toString())

        boton_mas_2_local.setOnClickListener{
            binding.LocalMarcador.text=sumar2("local", Marcador)
        }
        boton_mas_local.setOnClickListener{
            binding.LocalMarcador.text=sumar("local",Marcador)
        }
        boton_menos_local.setOnClickListener {
            if (Marcador.local.toInt()<=0)
            {
                Toast.makeText(this, "No se puede restar a local", Toast.LENGTH_SHORT).show()
            }
            else{
                binding.LocalMarcador.text=restar("local",Marcador)
            }

        }




        boton_mas_2_visitante.setOnClickListener{
            binding.VisitanteMarcador.text=sumar2("visitante", Marcador)
        }
        boton_mas_visitante.setOnClickListener{
            binding.VisitanteMarcador.text=sumar("visitante",Marcador)
        }
        boton_maenos_visitante.setOnClickListener{
            if (Marcador.visitante.toInt()<=0)
            {
                Toast.makeText(this, "No se puede restar a visitante", Toast.LENGTH_SHORT).show()
            }
            else{
                binding.VisitanteMarcador.text=restar("visitante",Marcador)
            }
    }

        restart_boton.setOnClickListener {
            binding.VisitanteMarcador.text=reiniciar(Marcador)
            binding.LocalMarcador.text=reiniciar(Marcador)
        }
        siguinete_boton.setOnClickListener {
            val marcador=Marcadorc(binding.LocalMarcador.text.toString(),binding.VisitanteMarcador.text.toString())
            openResultado(marcador)

        }



    }

    private fun openResultado(marcadorc: Marcadorc) {
        val intent=Intent(this,Resultados::class.java)
        intent.putExtra(Resultados.ResultadoKey,marcadorc)
        startActivity(intent)
    }

    private fun reiniciar(Marcadorc: Marcadorc): String? {
        val re= "0"
        Marcadorc.local=re
        Marcadorc.visitante=re
        return re
    }

    private fun sumar(vis: String, Marcadorc: Marcadorc): String? {
        if (vis=="local")
        {
            val local_sum=Marcadorc.local.toInt()+1
            Marcadorc.local=local_sum.toString()
            return local_sum.toString()
        }
        else{
            val visit_sum=Marcadorc.visitante.toInt()+1
            Marcadorc.visitante=visit_sum.toString()
            return visit_sum.toString()
        }
    }


    private fun sumar2(vis:String, Marcadorc: Marcadorc): String {
        if (vis=="local")
        {
            val local_sum=Marcadorc.local.toInt()+2
            Marcadorc.local=local_sum.toString()
            return local_sum.toString()
        }
        else{
            val visit_sum=Marcadorc.visitante.toInt()+2
            Marcadorc.visitante=visit_sum.toString()
            return visit_sum.toString()
        }
    }

    private fun restar(vis:String, Marcadorc: Marcadorc): String? {

            if (vis=="local")
            {
                val local_sum=Marcadorc.local.toInt()-1
                Marcadorc.local=local_sum.toString()
                return local_sum.toString()
            }

        else{
            val visit_sum=Marcadorc.visitante.toInt()-1
            Marcadorc.visitante=visit_sum.toString()
            return visit_sum.toString()
        }
    }
}


