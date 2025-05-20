package com.albrecht3.minijuegos.rockpaperscissors

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.albrecht3.minijuegos.R
import com.albrecht3.minijuegos.databinding.ActivityGameRpsBinding
import kotlinx.coroutines.delay

class GameRPSActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameRpsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameRpsBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.apply {
            btnRock.setOnClickListener {
                player1.setImageResource(R.drawable.rock)
                jugadaCom(1)
            }
            btnPaper.setOnClickListener {
                player1.setImageResource(R.drawable.paper)
                jugadaCom(2)
            }
            btnScissor.setOnClickListener {
                player1.setImageResource(R.drawable.scissors)
                jugadaCom(3)
            }
        }
    }

    private fun jugadaCom(play: Int){
        binding.apply {
            var opcion: Int = ((Math.random()*3)+1).toInt()
            when (opcion){
                1->{
                    playCPU.setImageResource(R.drawable.rock)
                    if (play == 1) result.setText(R.string.draw)
                    if (play == 2) result.setText(R.string.lose)
                    if (play == 3) result.setText(R.string.win)
                }
                2->{
                    playCPU.setImageResource(R.drawable.paper)
                    if (play == 1) result.setText(R.string.win)
                    if (play == 2) result.setText(R.string.draw)
                    if (play == 3) result.setText(R.string.lose)
                }
                3->{
                    playCPU.setImageResource(R.drawable.scissors)
                    if (play == 1) result.setText(R.string.lose)
                    if (play == 2) result.setText(R.string.win)
                    if (play == 3) result.setText(R.string.draw)
                }
            }
        }
    }
}