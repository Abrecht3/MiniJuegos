package com.albrecht3.minijuegos

import android.R
import android.R.layout.*
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class RockPaperScissors : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(com.albrecht3.minijuegos.R.layout.activity_rock_paper_scissors)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(com.albrecht3.minijuegos.R.id.rpcactivity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        jugador();

    }

    //Funcion para realizar las tiradas del jugador
    @SuppressLint("ResourceType")
    private fun jugador() {

        val rock: ImageButton = findViewById(com.albrecht3.minijuegos.R.id.rock)
        val paper: ImageButton = findViewById(com.albrecht3.minijuegos.R.id.paper)
        val scissors: ImageButton = findViewById(com.albrecht3.minijuegos.R.id.scissors)
        var tiro: ImageView = findViewById(com.albrecht3.minijuegos.R.id.tirada)
        var player: Int
        var computer: Int


        rock.setOnClickListener {
            tiro.setImageResource(com.albrecht3.minijuegos.R.drawable.rock)
            player = 1
            computer=jugadaCom()
            resultado(player,computer)
        }
        paper.setOnClickListener {
            tiro.setImageResource(com.albrecht3.minijuegos.R.drawable.paper)
            player = 2
            computer=jugadaCom()
            resultado(player,computer)
        }
        scissors.setOnClickListener {
            tiro.setImageResource(com.albrecht3.minijuegos.R.drawable.scissors)
            player = 3
            computer=jugadaCom()
            resultado(player,computer)
        }
    }

    //Funcion que genera al azar la tirada de la computadora
    private fun jugadaCom(): Int {

        var tiroCom: ImageView = findViewById(com.albrecht3.minijuegos.R.id.tiradacom)
        var playCom: Int = 0
        var opcion: Int = ((Math.random()*3)+1).toInt()
        when(opcion){
            1-> {
                tiroCom.setImageResource(com.albrecht3.minijuegos.R.drawable.rockcom)
                playCom = 1
            }
            2-> {
                tiroCom.setImageResource(com.albrecht3.minijuegos.R.drawable.papercom)
                playCom = 2
            }
            3-> {
                tiroCom.setImageResource(com.albrecht3.minijuegos.R.drawable.scissorscom)
                playCom = 3
            }
        }
        return playCom
    }

    //Funcion que determina el resultado
    private fun resultado(player: Int, computer: Int){
        var resultado: TextView = findViewById(com.albrecht3.minijuegos.R.id.resultado)
        when(player){
            1->when(computer){
                1->{
                    resultado.setText(com.albrecht3.minijuegos.R.string.empate)
                }
                2->{
                    resultado.setText(com.albrecht3.minijuegos.R.string.pierde)
                }
                3->{
                    resultado.setText(com.albrecht3.minijuegos.R.string.gana)
                }
            }
            2->when(computer){
                1->{
                    resultado.setText(com.albrecht3.minijuegos.R.string.gana)
                }
                2->{
                    resultado.setText(com.albrecht3.minijuegos.R.string.empate)
                }
                3->{
                    resultado.setText(com.albrecht3.minijuegos.R.string.pierde)
                }
            }
            3->when(computer){
                1->{
                    resultado.setText(com.albrecht3.minijuegos.R.string.pierde)
                }
                2->{
                    resultado.setText(com.albrecht3.minijuegos.R.string.gana)
                }
                3->{
                    resultado.setText(com.albrecht3.minijuegos.R.string.empate)
                }
            }
        }
    }
}