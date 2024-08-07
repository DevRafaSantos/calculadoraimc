package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


            val result = intent.getFloatExtra(KEY_RESULT_IMC,0f)
            val tvResult = findViewById<TextView>(R.id.tv_result)
            val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
            tvResult.text = result.toString()

             var (classificacao: String, color) = when {
                 result <= 18.5f -> {
                     "Subpeso" to R.color.Subpeso
                 }

                 result > 18.5f && result <= 25.0f -> {
                     "Normal" to R.color.Normal
                 }

                 else -> {
                     "Sobrepeso" to R.color.Sobrepeso

                 }
             }

            tvClassificacao.setTextColor(ContextCompat.getColor(this, color))
            tvClassificacao.text = classificacao
        }
    }