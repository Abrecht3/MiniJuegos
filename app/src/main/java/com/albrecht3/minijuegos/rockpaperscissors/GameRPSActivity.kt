package com.albrecht3.minijuegos.rockpaperscissors

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.albrecht3.minijuegos.R
import com.albrecht3.minijuegos.databinding.ActivityGameRpsBinding
import kotlinx.coroutines.delay

class GameRPSActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameRpsBinding

    private var playerScore = 0
    private var comScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameRpsBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        initGame()

    }

    private fun initGame() {
        binding.apply {
            btnRock.setOnClickListener {
                player1.setImageResource(R.drawable.rock)
                result(1)
            }
            btnPaper.setOnClickListener {
                player1.setImageResource(R.drawable.paper)
                result(2)
            }
            btnScissor.setOnClickListener {
                player1.setImageResource(R.drawable.scissors)
                result(3)
            }
        }
    }

    private fun jugadaCom(): Int {
        binding.apply {
            val opcion: Int = ((Math.random() * 3) + 1).toInt()
            when (opcion) {
                1 -> {
                    playCPU.setImageResource(R.drawable.rock)
                }

                2 -> {
                    playCPU.setImageResource(R.drawable.paper)
                }

                3 -> {
                    playCPU.setImageResource(R.drawable.scissors)
                }
            }
            return opcion
        }
    }

    private fun result(player: Int) {
        var message = ""
        val com = jugadaCom()

        if (player == com) message = "Empate"
        if (player == 1 && com == 2 || player == 2 && com == 3 || player == 3 && com == 1) {
            message = "Perdiste :("
            comScore++
        }
        if (player == 1 && com == 3 || player == 2 && com == 1 || player == 3 && com == 2) {
            message = "Ganaste :)"
            playerScore++
        }

        showMyDialog(message)
    }

    private fun showMyDialog(title: String){
        val message = "\nPlayer $playerScore\n\nCom $comScore"
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Reset") { _, _ ->
                resetBoard()
            }.setCancelable(false).show()
    }

    private fun resetBoard() {
        binding.player1.setImageResource(R.drawable.fondot)
        binding.playCPU.setImageResource(R.drawable.fondot)
    }
}

