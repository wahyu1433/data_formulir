package com.example.formulirwithfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_formulir_data.*

class GejalaKlinis : AppCompatActivity() {

    var next: Button? = null
    var back: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gejala_klinis)



        next = findViewById(R.id.next2)
        back = findViewById(R.id.back2)

//        next?.setOnClickListener {
//            val i = Intent(applicationContext, PilihJadwal::class.java)
//            startActivity(i)
//        }

        next?.setOnClickListener {
            val intent = Intent(this, PilihJadwal::class.java)
            val bundle = Bundle()

            bundle.putString(FormulirDataActivity.NAMA, nama_lengkap.text.toString())
            bundle.putString(FormulirDataActivity.TTL, ttl.text.toString())
            bundle.putString(FormulirDataActivity.NOHP, nomorhp.text.toString())
            bundle.putString(FormulirDataActivity.ALAMAT, alamat.text.toString())
            bundle.putString(FormulirDataActivity.EMAIL, email.text.toString())

            val id = jkelgroup.checkedRadioButtonId
            val radioButton = findViewById(id) as RadioButton
            bundle.putString(FormulirDataActivity.JKEL, radioButton.text.toString())
            intent.putExtras(bundle)
            startActivity(intent)
        }

        back?.setOnClickListener {
            val i = Intent(applicationContext, FormulirDataActivity::class.java)
            startActivity(i)
        }


    }

}