package com.albrecht3.minijuegos

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.albrecht3.minijuegos.databinding.ActivityMainBinding
import com.albrecht3.minijuegos.memory_sequence.MenuSimon
import com.albrecht3.minijuegos.rockpaperscissors.MenuRPSActivity
import com.albrecht3.minijuegos.tictactoe.MenuTTTActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.Base_Theme_MiniJuegos)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        val view = binding.root
        setContentView(view)

        initButtons()

    }

    private fun initButtons() {
        binding.apply {
            btnRPS.setOnClickListener { navigateToRPS() }

            btnXO.setOnClickListener { navigateToTicTacToe() }

            btnMemSequence.setOnClickListener { navigateToMemory() }
        }
    }

    private fun navigateToRPS() {
        startActivity(Intent(this@MainActivity, MenuRPSActivity::class.java))
    }

    private fun navigateToTicTacToe() {
        startActivity(Intent(this@MainActivity, MenuTTTActivity::class.java))
    }

    private fun navigateToMemory() {
        startActivity(Intent(this@MainActivity, MenuSimon::class.java))
    }
}