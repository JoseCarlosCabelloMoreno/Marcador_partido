package com.example.marcador

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


        val Marcador=marcador(marcador_local.text.toString(),marcador_visitante.text.toString())

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
    }

    private fun reiniciar(Marcador: marcador): String? {
        val re= "0"
        Marcador.local=re
        Marcador.visitante=re
        return re
    }

    private fun sumar(vis: String,Marcador: marcador): String? {
        if (vis=="local")
        {
            val local_sum=Marcador.local.toInt()+1
            Marcador.local=local_sum.toString()
            return local_sum.toString()
        }
        else{
            val visit_sum=Marcador.visitante.toInt()+1
            Marcador.visitante=visit_sum.toString()
            return visit_sum.toString()
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

    private fun restar(vis:String,Marcador: marcador): String? {

            if (vis=="local")
            {
                val local_sum=Marcador.local.toInt()-1
                Marcador.local=local_sum.toString()
                return local_sum.toString()
            }

        else{
            val visit_sum=Marcador.visitante.toInt()-1
            Marcador.visitante=visit_sum.toString()
            return visit_sum.toString()
        }
    }
}


