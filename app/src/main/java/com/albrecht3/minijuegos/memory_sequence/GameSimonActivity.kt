package com.albrecht3.minijuegos.memory_sequence

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.app.ActivityCompat
import androidx.core.view.forEach
import androidx.lifecycle.lifecycleScope
import com.albrecht3.minijuegos.R
import com.albrecht3.minijuegos.databinding.ActivityGameSimonBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameSimonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameSimonBinding

    private var score = 0
    private var result = ""
    private var answer = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityGameSimonBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        initComponents()
    }

    private fun initComponents() {
        binding.apply {
            panel1.setOnClickListener { this@GameSimonActivity }
            panel2.setOnClickListener { this@GameSimonActivity }
            panel3.setOnClickListener { this@GameSimonActivity }
            panel4.setOnClickListener { this@GameSimonActivity }
            startGame()
        }
    }

    private fun startGame() {
        disableButtons()
        lifecycleScope.launch {
            val round = (3..6).random()
            repeat(round) {
                delay(400)
                val randomPanel = (1..4).random()
                result += randomPanel
                val panel = when (randomPanel) {
                    1 -> binding.panel1
                    2 -> binding.panel2
                    3 -> binding.panel3
                    else -> binding.panel4
                }

                val drawableColor =
                    ActivityCompat.getDrawable(this@GameSimonActivity, R.drawable.btn_secuence)
                val drawableDefault =
                    ActivityCompat.getDrawable(this@GameSimonActivity, R.drawable.btn_state)

                panel.background = drawableColor
                delay(1000)
                panel.background = drawableDefault
            }
            enableButtons()
        }
    }

    private fun disableButtons() {
        binding.root.forEach {
            if (it is Button) {
                it.isEnabled = false
            }
        }
    }

    private fun enableButtons() {
        binding.root.forEach {
            if (it is Button) {
                it.isEnabled = true
            }
        }
    }


}