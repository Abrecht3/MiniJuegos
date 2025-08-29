package com.albrecht3.minijuegos.rockpaperscissors

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.albrecht3.minijuegos.databinding.ActivityMenuRpsBinding

class MenuRPSActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuRpsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuRpsBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)

        initButtons()

    }

    private fun initButtons() {
        binding.playRPS.setOnClickListener { startGame() }
    }

    private fun startGame() {
        startActivity(Intent(this@MenuRPSActivity, GameRPSActivity::class.java))
    }
}
