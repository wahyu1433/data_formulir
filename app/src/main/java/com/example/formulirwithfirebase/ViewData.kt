package com.example.formulirwithfirebase

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_view_data.*

class ViewData : AppCompatActivity() {

    private var auth: FirebaseAuth? = null
//    private var database1: DatabaseReference? = null
//    private var auth: FirebaseAuth? = null
//    private var cekNama: String? = null
//    private var cekTglLahir: String? = null
//    private var cekNomorHp: String? = null
//    private var cekAlamat: String? = null
//    private var cekEmail: String? = null
//    private var recyclerView: RecyclerView? = null
//    private var adapter: RecyclerView.Adapter<*>? = null
//    private var layoutManager: RecyclerView.LayoutManager? = null
//    //Deklarasi Variable Database Reference & ArrayList dengan Parameter Class Model kita.
//    val database = FirebaseDatabase.getInstance()

    var kembali: Button? = null
    val database = FirebaseDatabase.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_data)



        auth = FirebaseAuth.getInstance()

        kembali = findViewById(R.id.kembali)

        kembali?.setOnClickListener{
            val i = Intent(applicationContext, HomeActivity::class.java)
            startActivity(i)

        }




        val bundle = intent.extras

        hasil_nama.text = (bundle?.getCharSequence(FormulirDataActivity.NAMA))
        hasil_jenis_kelamin.text = (bundle?.getCharSequence(FormulirDataActivity.JKEL))
        hasil_tanggal_lahir.text = (bundle?.getCharSequence(FormulirDataActivity.TTL))
        hasil_nomor_hp.text = (bundle?.getCharSequence(FormulirDataActivity.NOHP))
        hasil_alamat.text = (bundle?.getCharSequence(FormulirDataActivity.ALAMAT))
        hasil_email.text = (bundle?.getCharSequence(FormulirDataActivity.EMAIL))

        hasil_demam.text = (bundle?.getCharSequence(FormulirDataActivity.Radio1))
        hasil_batuk.text = (bundle?.getCharSequence(FormulirDataActivity.Radio2))
        hasil_pilek.text = (bundle?.getCharSequence(FormulirDataActivity.Radio3))
        hasil_tenggrokan.text = (bundle?.getCharSequence(FormulirDataActivity.Radio4))
        hasil_sesak_nafas.text = (bundle?.getCharSequence(FormulirDataActivity.Radio5))
        hasil_perjalanan_luar_negeri.text = (bundle?.getCharSequence(FormulirDataActivity.Radio6))
        hasil_perjalanan_dalam_negeri.text = (bundle?.getCharSequence(FormulirDataActivity.Radio7))
        hasil_tanggal.text = (bundle?.getCharSequence(FormulirDataActivity.JADWALJAM))
    }







}


