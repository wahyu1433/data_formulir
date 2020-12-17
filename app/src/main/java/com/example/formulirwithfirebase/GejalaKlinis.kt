package com.example.formulirwithfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GejalaKlinis : AppCompatActivity() {

    var next: Button? = null
    var back: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gejala_klinis)



        next = findViewById(R.id.next2)
        back = findViewById(R.id.back2)

        next?.setOnClickListener {
            val i = Intent(applicationContext, PilihJadwal::class.java)
            startActivity(i)
        }

        back?.setOnClickListener {
            val i = Intent(applicationContext, FormulirDataActivity::class.java)
            startActivity(i)
        }


    }

}