package com.albrecht3.minijuegos.memory_sequence

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.albrecht3.minijuegos.R
import com.albrecht3.minijuegos.databinding.ActivityMenuMemsimonBinding
import com.albrecht3.minijuegos.tictactoe.TicTacToeActivity

class MenuSimon : AppCompatActivity() {

    private lateinit var binding: ActivityMenuMemsimonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMenuMemsimonBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.playSimon.setOnClickListener {
            startActivity(Intent(this@MenuSimon, GameSimonActivity::class.java))
        }
    }
}