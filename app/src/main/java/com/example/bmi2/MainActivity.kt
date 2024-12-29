package com.example.bmi2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button = findViewById<AppCompatButton>(R.id.calcButton)

        button.setOnClickListener{
            val weight = findViewById<Slider>(R.id.slider1).value
            val height = findViewById<Slider>(R.id.slider2).value

            val heightInMeter = height /100

            val bmi = weight/(heightInMeter*heightInMeter)
            val answer = findViewById<TextView>(R.id.answer)
            answer.text = bmi.toString()
        }
    }
}