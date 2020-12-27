package com.example.formulirwithfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_formulir_data.*

class PilihJadwal : AppCompatActivity() {

//    companion object {
//        val NAMA: String? = "nama"
//        val JKEL: String? = "jenis kelamin"
//        val TTL: String? = "tempat tanggal lahir"
//        val NOHP: String? = "noor hp"
//        val ALAMAT: String? = "alamat"
//        val EMAIL: String? = "email"
//    }


//    companion object {
//        val NAMA: String? = "nama"
//        var JKEL: String? = "jkel"
//        var TTL: String? = "ttl"
//        var NOHP: String? = "nohp"
//        var ALAMAT: String? = "alamat"
//        var EMAIL: String? = "email"
//    }


    var peserta: Spinner? = null
    var event: Spinner? = null
    var jam: Spinner? = null
    var adapter: ArrayAdapter<String>? = null
    val pesertas = arrayOf("1 peserta", "2 peserta", "3 peserta", "4 peserta", "5 peserta")
    val events = arrayOf("RAPIDTEST MALANG 1 - Kecamatan Lowokwaru, Jalan Soekarno - Hatta, Kota Malang, Jawa Timur", "RAPIDTEST MALANG 2 - KecamatanKedungkandang, Jalan Rajasa No.27, Kota Malang, Jawa Timur")
    val jams = arrayOf("08:00 - 10:00", "13.00 - 15:00")
    var simpan: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_jadwal)


        peserta = findViewById(R.id.peserta)
        event = findViewById(R.id.event)
        jam = findViewById(R.id.jam)
        simpan = findViewById(R.id.simpandata)

//        nama = findViewById(R.id.nama)
//        jkel = findViewById(R.id.jkel_formulir)
//        ttl = findViewById(R.id.ttl)
//        nohp = findViewById(R.id.nomorhp)
//        alamat = findViewById(R.id.alamat)
//        email = findViewById(R.id.email)



        val arrayAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1,pesertas)
        peserta?.adapter = arrayAdapter

        val arrayAdapter2 = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1,events)
        event?.adapter = arrayAdapter2

        val arrayAdapter3 = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1,jams)
        jam?.adapter = arrayAdapter3


//        simpan?.setOnClickListener {
//            val i = Intent(applicationContext, ViewData::class.java)
//            startActivity(i)
//        }

        simpan?.setOnClickListener {
            val intent = Intent(this, ViewData::class.java)
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

//        simpan?.setOnClickListener {
//            val intent = Intent(this, ViewData::class.java)
//            val bundle = Bundle()
//
//            bundle.putString(FormulirDataActivity.NAMA, nama_lengkap.text.toString())
//            bundle.putString(FormulirDataActivity.TTL, ttl.text.toString())
//            bundle.putString(FormulirDataActivity.NOHP, nomorhp.text.toString())
//            bundle.putString(FormulirDataActivity.ALAMAT, alamat.text.toString())
//            bundle.putString(FormulirDataActivity.EMAIL, email.text.toString())
//
//            val id = jkelgroup.checkedRadioButtonId
//            val radioButton = findViewById(id) as RadioButton
//            bundle.putString(FormulirDataActivity.JKEL, radioButton.text.toString())
//            intent.putExtras(bundle)
//            startActivity(intent)
//        }


//        val intent = Intent(this, ViewData::class.java)
//        val bundle = Bundle()
//
//        bundle.putString(NAMA, nama.text.toString())
//        bundle.putString(JKEL, jkel_formulir.checkedRadioButtonId.toString())
//        bundle.putString(TTL, ttl.text.toString())
//        bundle.putString(NOHP, nomorhp.text.toString())
//        bundle.putString(ALAMAT, alamat.text.toString())
//        bundle.putString(EMAIL, email.text.toString())
//
//        intent.putExtras(bundle)
//        startActivity(intent)

    }
}