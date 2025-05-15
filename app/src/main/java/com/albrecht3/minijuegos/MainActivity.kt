package com.albrecht3.minijuegos

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.albrecht3.minijuegos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.Base_Theme_MiniJuegos)

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(binding.root)

        binding.apply {

            rpsButton.setOnClickListener {
                startActivity(Intent(this@MainActivity, RockPaperScissors::class.java))
            }
        }
    }
}
