package com.example.burbuja_s3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val inputs: List<EditText> = listOf(
            findViewById(R.id.et1),
            findViewById(R.id.et2),
            findViewById(R.id.et3),
            findViewById(R.id.et4),
            findViewById(R.id.et5)
        )
        val btnSort = findViewById<Button>(R.id.btnOrdenar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
//Código del manual de  CaseliGod
        btnSort.setOnClickListener {
            val numeros = inputs.map { it.text.toString().toIntOrNull() ?: 0 }.toMutableList()
            for (i in 0 until numeros.size - 1) {
                for (j in 0 until numeros.size - i - 1) {
                    if (numeros[j] > numeros[j + 1]) {
                        val temp = numeros[j]
                        numeros[j] = numeros[j + 1]
                        numeros[j + 1] = temp
                    }
                }
            }
            tvResultado.text = "Ordenado: ${numeros.joinToString(", ")}"
        }

    }
}