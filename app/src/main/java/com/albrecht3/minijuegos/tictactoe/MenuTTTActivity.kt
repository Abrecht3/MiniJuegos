package com.albrecht3.minijuegos.tictactoe

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.albrecht3.minijuegos.R
import com.albrecht3.minijuegos.databinding.ActivityMenuTttactivityBinding

class MenuTTTActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuTttactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuTttactivityBinding.inflate(layoutInflater)
        val view=binding.root
        enableEdgeToEdge()
        setContentView(view)

        binding.apply {
            playXO.setOnClickListener {
                startActivity(Intent(this@MenuTTTActivity, TicTacToeActivity::class.java))
            }
        }
    }
}