package com.albrecht3.minijuegos.rockpaperscissors

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.albrecht3.minijuegos.R
import com.albrecht3.minijuegos.databinding.ActivityGameRpsBinding

class GameRPSActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameRpsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameRpsBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.apply {

        }
    }
}