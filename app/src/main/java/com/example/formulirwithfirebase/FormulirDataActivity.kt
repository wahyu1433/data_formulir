package com.example.formulirwithfirebase

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils.isEmpty
import android.view.View
import android.widget.*
import androidx.core.view.get
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_formulir_data.*
import kotlinx.android.synthetic.main.activity_formulir_data.pilihjadwal
import kotlinx.android.synthetic.main.activity_update_data.*
import java.text.SimpleDateFormat
import java.util.*

class FormulirDataActivity : AppCompatActivity() {

    private var auth: FirebaseAuth? = null
    private val RC_SIGN_IN = 1




    companion object {
        val NAMA: String? = "nama"
        val JKEL: String? = "jenis kelamin"
        val TTL: String? = "tempat tanggal lahir"
        val NOHP: String? = "noor hp"
        val ALAMAT: String? = "alamat"
        val EMAIL: String? = "email"
        val JADWALJAM: String? = "jam"

        //Gekala Klinis

        val Radio1: String? = "radio1"
        val Radio2: String? = "radio2"
        val Radio3: String? = "radio3"
        val Radio4: String? = "radio4"
        val Radio5: String? = "radio5"
        val Radio6: String? = "radio6"
        val Radio7: String? = "radio7"

    }

    var formatDate = SimpleDateFormat("dd MMMM YYYY", Locale.US)


    var lahir: EditText? = null
    var pilihtanggal: EditText? = null
    var jadwaljam: EditText? = null
    var next: Button? = null
    var simpan: Button? = null
    var jam: Spinner? = null
    var adapter: ArrayAdapter<String>? = null
    var jams = arrayOf("08:00 - 10:00", "13.00 - 15:00")




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulir_data)

//        next = findViewById(R.id.next)
//        back = findViewById(R.id.back)
        jam = findViewById(R.id.jam)
        simpan = findViewById(R.id.simpandata)

        ////auth firebase

        auth = FirebaseAuth.getInstance()

        lahir = findViewById(R.id.ttl)

        pilihtanggal = findViewById(R.id.pilihjadwal)

        pilihtanggal?.setOnClickListener(View.OnClickListener {
            val getDate: Calendar = Calendar.getInstance()
            val datepicker = DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->

                val selectDate = Calendar.getInstance()
                selectDate.set(Calendar.YEAR, i)
                selectDate.set(Calendar.MONTH, i2)
                selectDate.set(Calendar.DAY_OF_MONTH, i3)
                val date: String = formatDate.format(selectDate.time)
                pilihjadwal.setText(date)


            }, getDate.get(Calendar.YEAR), getDate.get(Calendar.MONTH), getDate.get(Calendar.DAY_OF_MONTH))
            datepicker.show()
        })

        lahir?.setOnClickListener(View.OnClickListener {

            val getDate: Calendar = Calendar.getInstance()
            val datepicker = DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->

                val selectDate = Calendar.getInstance()
                selectDate.set(Calendar.YEAR, i)
                selectDate.set(Calendar.MONTH, i2)
                selectDate.set(Calendar.DAY_OF_MONTH, i3)
                val date: String = formatDate.format(selectDate.time)
                ttl.setText(date)


            }, getDate.get(Calendar.YEAR), getDate.get(Calendar.MONTH), getDate.get(Calendar.DAY_OF_MONTH))
            datepicker.show()
        })


        simpan?.setOnClickListener {

            val intent = Intent(this, ViewData::class.java)
            val bundle = Bundle()



            bundle.putString(NAMA, nama_lengkap.text.toString())
            bundle.putString(TTL, ttl.text.toString())
            bundle.putString(NOHP, nomorhp.text.toString())
            bundle.putString(ALAMAT, alamat.text.toString())
            bundle.putString(EMAIL, email.text.toString())

//            bundle.putString(TANGGAL, tanggal.text.toString())

            bundle.putString(JADWALJAM, pilihjadwal.text.toString())


            val id = jkelgroup.checkedRadioButtonId
            val radioButton = findViewById(id) as RadioButton
            bundle.putString(JKEL, radioButton.text.toString())

            //Gejala Klinis

            val id1 = radio_grup1.checkedRadioButtonId
            val radioButton1 = findViewById(id1) as RadioButton
            bundle.putString(Radio1, radioButton1.text.toString())

            val id2 = radio_grup2.checkedRadioButtonId
            val radioButton2 = findViewById(id2) as RadioButton
            bundle.putString(Radio2, radioButton2.text.toString())

            val id3 = radio_grup3.checkedRadioButtonId
            val radioButton3 = findViewById(id3) as RadioButton
            bundle.putString(Radio3, radioButton3.text.toString())

            val id4 = radio_grup4.checkedRadioButtonId
            val radioButton4 = findViewById(id4) as RadioButton
            bundle.putString(Radio4, radioButton4.text.toString())

            val id5 = radio_grup5.checkedRadioButtonId
            val radioButton5 = findViewById(id5) as RadioButton
            bundle.putString(Radio5, radioButton5.text.toString())
//Faktor Resiko
            val id6 = radio_grup6.checkedRadioButtonId
            val radioButton6 = findViewById(id6) as RadioButton
            bundle.putString(Radio6, radioButton6.text.toString())

            val id7 = radio_grup7.checkedRadioButtonId
            val radioButton7 = findViewById(id7) as RadioButton
            bundle.putString(Radio7, radioButton7.text.toString())


            val getUserID = auth!!.currentUser!!.uid


            val database = FirebaseDatabase.getInstance()

            val getNama: String = nama_lengkap.getText().toString()
            var idradio = jkelgroup.checkedRadioButtonId
            val radiojkel = findViewById(idradio) as RadioButton
            val getJkel: String = radiojkel.text.toString()

            var idradio1 = radio_grup1.checkedRadioButtonId
            val radio1 = findViewById(idradio1) as RadioButton
            val getDemam: String = radio1.text.toString()

            var idradio2 = radio_grup2.checkedRadioButtonId
            val radio2 = findViewById(idradio2) as RadioButton
            val getBatuk: String = radio2.text.toString()

            var idradio3 = radio_grup3.checkedRadioButtonId
            val radio3 = findViewById(idradio3) as RadioButton
            val getPilek: String = radio3.text.toString()

            var idradio4 = radio_grup4.checkedRadioButtonId
            val radio4 = findViewById(idradio4) as RadioButton
            val getTenggorokon: String = radio4.text.toString()

            var idradio5 = radio_grup5.checkedRadioButtonId
            val radio5 = findViewById(idradio5) as RadioButton
            val getSesak: String = radio5.text.toString()

            var idradio6 = radio_grup6.checkedRadioButtonId
            val radio6 = findViewById(idradio6) as RadioButton
            val getLuarNegeri: String = radio6.text.toString()

            var idradio7 = radio_grup7.checkedRadioButtonId
            val radio7 = findViewById(idradio7) as RadioButton
            val getDalamNegeri: String = radio7.text.toString()

            val getTglLahir: String = ttl.getText().toString()
            val getNomorHp: String = nomorhp.getText().toString()
            val getAlamat: String = alamat.getText().toString()
            val getEmail: String = email.getText().toString()
            val getJadwal: String = pilihjadwal.getText().toString()


            val getReference: DatabaseReference
            getReference = database.reference

            if (isEmpty(getNama) || isEmpty(getTglLahir) || isEmpty(getNomorHp) || isEmpty(getAlamat) || isEmpty(getEmail)
                || isEmpty(getDemam) || isEmpty(getBatuk) || isEmpty(getPilek) || isEmpty(getTenggorokon) || isEmpty(getSesak) || isEmpty(getLuarNegeri)
                || isEmpty(getDalamNegeri) || isEmpty(getJadwal)) {

                Toast.makeText(this@FormulirDataActivity, "Data tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show()
            } else {
                getReference.child("Admin").child(getUserID).child("Pasien").push()
                    .setValue(data_pasien(getNama, getJkel, getTglLahir,getNomorHp, getAlamat, getEmail, getDemam, getBatuk, getPilek,
                    getTenggorokon, getSesak, getLuarNegeri, getDalamNegeri,getJadwal))
                    .addOnCompleteListener(this) {
                        nama.setText("")
                        ttl.setText("")
                        nomorhp.setText("")
                        alamat.setText("")
                        email.setText("")

                        Toast.makeText(this@FormulirDataActivity, "Data Tersimpan",
                            Toast.LENGTH_SHORT).show()
                    }
            }

            intent.putExtras(bundle)
            startActivity(intent)
        }

        var arrayAdapter3 = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, jams)
        jam?.adapter = arrayAdapter3

    }
}