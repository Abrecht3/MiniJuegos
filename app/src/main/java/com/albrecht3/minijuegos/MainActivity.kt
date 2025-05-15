package com.albrecht3.minijuegos

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.albrecht3.minijuegos.databinding.ActivityMainBinding
import com.albrecht3.minijuegos.rockpaperscissors.MenuRPSActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.Base_Theme_MiniJuegos)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        var view = binding.root
        setContentView(view)

        binding.apply {
            btnRPS.setOnClickListener {
                startActivity(Intent(this@MainActivity, MenuRPSActivity::class.java))
            }
        }
    }
}