package com.example.formulirwithfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Spinner

class PilihJadwal : AppCompatActivity() {


    var peserta: Spinner? = null
    var event: Spinner? = null
    var jam: Spinner? = null
    var adapter: ArrayAdapter<String>? = null
    val pesertas = arrayOf("1 peserta", "2 peserta", "3 peserta", "4 peserta", "5 peserta")
    val events = arrayOf("RAPIDTEST MALANG 1 - Kecamatan Lowokwaru, Jalan Soekarno - Hatta, Kota Malang, Jawa Timur", "RAPIDTEST MALANG 2 - KecamatanKedungkandang, Jalan Rajasa No.27, Kota Malang, Jawa Timur")
    val jams = arrayOf("08:00 - 10:00", "13.00 - 15:00")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_jadwal)


        peserta = findViewById(R.id.peserta)
        event = findViewById(R.id.event)
        jam = findViewById(R.id.jam)



        val arrayAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1,pesertas)
        peserta?.adapter = arrayAdapter

        val arrayAdapter2 = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1,events)
        event?.adapter = arrayAdapter2

        val arrayAdapter3 = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1,jams)
        jam?.adapter = arrayAdapter3

    }
}