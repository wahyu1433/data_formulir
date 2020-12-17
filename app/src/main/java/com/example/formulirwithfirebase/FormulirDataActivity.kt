package com.example.formulirwithfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FormulirDataActivity : AppCompatActivity() {


    var next: Button? = null
    var back: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulir_data)




        next = findViewById(R.id.next)
        back = findViewById(R.id.back)

        next?.setOnClickListener {
            val i = Intent(applicationContext, GejalaKlinis::class.java)
            startActivity(i)
        }

        back?.setOnClickListener {
            val i = Intent(applicationContext, HomeActivity::class.java)
            startActivity(i)
        }
    }
}