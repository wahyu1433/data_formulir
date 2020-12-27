package com.example.formulirwithfirebase

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.text.TextUtils.isEmpty
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.view.get
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_formulir_data.*
import kotlinx.android.synthetic.main.activity_update_data.*
import kotlinx.android.synthetic.main.activity_view_data.*
import java.text.SimpleDateFormat
import java.util.*


class UpdateData : AppCompatActivity() {

    private var database: DatabaseReference? = null
    private var auth: FirebaseAuth? = null
    private var cekNama: String? = null
    private var cekJkel: String? = null
    private var cekTglLahir: String? = null
    private var cekNomorHp: String? = null
    private var cekAlamat: String? = null
    private var cekEmail: String? = null

    var updatelahir: EditText? = null
    var updatepilihtanggal: EditText? = null

    var formatDate = SimpleDateFormat("dd MMMM YYYY", Locale.US)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_data)

        auth = FirebaseAuth.getInstance()
        updatelahir = findViewById(R.id.new_ttl)

        updatelahir?.setOnClickListener(View.OnClickListener {

            val getDate: Calendar = Calendar.getInstance()
            val datepicker = DatePickerDialog(
                this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->

                    val selectDate = Calendar.getInstance()
                    selectDate.set(Calendar.YEAR, i)
                    selectDate.set(Calendar.MONTH, i2)
                    selectDate.set(Calendar.DAY_OF_MONTH, i3)
                    val date: String = formatDate.format(selectDate.time)
                    new_ttl.setText(date)


                },
                getDate.get(Calendar.YEAR),
                getDate.get(Calendar.MONTH),
                getDate.get(Calendar.DAY_OF_MONTH)
            )
            datepicker.show()
        })

        updatepilihtanggal = findViewById(R.id.new_pilihjadwal)

        updatepilihtanggal?.setOnClickListener(View.OnClickListener {
            val getDate: Calendar = Calendar.getInstance()
            val datepicker = DatePickerDialog(
                this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->

                    val selectDate = Calendar.getInstance()
                    selectDate.set(Calendar.YEAR, i)
                    selectDate.set(Calendar.MONTH, i2)
                    selectDate.set(Calendar.DAY_OF_MONTH, i3)
                    val date: String = formatDate.format(selectDate.time)
                    new_pilihjadwal.setText(date)


                },
                getDate.get(Calendar.YEAR),
                getDate.get(Calendar.MONTH),
                getDate.get(Calendar.DAY_OF_MONTH)
            )
            datepicker.show()
        })

        database = FirebaseDatabase.getInstance().reference
         data //memanggil method "data"

        edit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
//Mendapatkan Data Mahasiswa yang akan dicek
                cekNama = new_nama.getText().toString()
//                cekJkel = new_jkel.checkedRadioButtonId.toString()
                cekTglLahir = new_ttl.getText().toString()
                cekNomorHp = new_nomorhp.getText().toString()
                cekAlamat = new_alamat.getText().toString()
                cekEmail = new_email.getText().toString()

                //Mengecek agar tidak ada data yang kosong, saat proses update
                if (isEmpty(cekNama!!) ||
                    isEmpty(cekTglLahir!!) || isEmpty(cekNomorHp!!) ||
                    isEmpty(cekAlamat!!) || isEmpty(cekEmail!!)
                ) //||
//                    isEmpty(cekRadioGroup1!!) || isEmpty(cekRadioGroup2!!) ||
//                    isEmpty(cekRadioGroup3!!) || isEmpty(cekRadioGroup4!!) ||
//                    isEmpty(cekRadioGroup5!!) || isEmpty(cekRadioGroup6!!) || isEmpty(cekRadioGroup7!!)
                {
                    Toast.makeText(
                        this@UpdateData,
                        "Data tidak boleh ada yang kosong",

                        Toast.LENGTH_SHORT

                    ).show()
                } else {
/*Menjalankan proses update data.
Method Setter digunakan untuk mendapakan data baru yang diinputkan User.*/
                    val setPasien = data_pasien()

                    val newid = new_jkelgroup.checkedRadioButtonId
                    val newradioButton = findViewById(newid) as RadioButton

                    val newid1 = new_radio_grup1.checkedRadioButtonId
                    val newradioButton1 = findViewById(newid1) as RadioButton

                    val newid2 = new_radio_grup2.checkedRadioButtonId
                    val newradioButton2 = findViewById(newid2) as RadioButton

                    val newid3 = new_radio_grup3.checkedRadioButtonId
                    val newradioButton3 = findViewById(newid3) as RadioButton

                    val newid4 = new_radio_grup4.checkedRadioButtonId
                    val newradioButton4 = findViewById(newid4) as RadioButton

                    val newid5 = new_radio_grup5.checkedRadioButtonId
                    val newradioButton5 = findViewById(newid5) as RadioButton

                    val newid6 = new_radio_grup6.checkedRadioButtonId
                    val newradioButton6 = findViewById(newid6) as RadioButton

                    val newid7 = new_radio_grup7.checkedRadioButtonId
                    val newradioButton7 = findViewById(newid7) as RadioButton

                    setPasien.nama = new_nama.getText().toString()
                    setPasien.jkel = newradioButton.getText().toString()
                    setPasien.ttl = new_ttl.getText().toString()
                    setPasien.nomorhp = new_nomorhp.getText().toString()
                    setPasien.alamat = new_alamat.getText().toString()
                    setPasien.email = new_email.getText().toString()
                    setPasien.demam = newradioButton1.getText().toString()
                    setPasien.batuk = newradioButton2.getText().toString()
                    setPasien.pilek = newradioButton3.getText().toString()
                    setPasien.nyeri_tenggorokan = newradioButton4.getText().toString()
                    setPasien.sesak_nafas = newradioButton5.getText().toString()
                    setPasien.perjalanan_luar_negeri = newradioButton6.getText().toString()
                    setPasien.perjalanan_dalam_negeri = newradioButton7.getText().toString()
                    setPasien.jadwal = new_pilihjadwal.getText().toString()
//                    setPasien.jkel = new_jkel.checkedRadioButtonId.toString()
//                    setPasien.jam = new_jam.selectedItem.toString()
//                    setPasien.RadioGroup1 = new_radio_grup1.checkedRadioButtonId.toString()
//                    setPasien.RadioGroup2 = new_radio_grup2.checkedRadioButtonId.toString()
//                    setPasien.RadioGroup3 = new_radio_grup3.checkedRadioButtonId.toString()
//                    setPasien.RadioGroup4 = new_radio_grup4.checkedRadioButtonId.toString()
//                    setPasien.RadioGroup5 = new_radio_grup5.checkedRadioButtonId.toString()
//                    setPasien.RadioGroup6 = new_radio_grup6.checkedRadioButtonId.toString()
//                    setPasien.RadioGroup7 = new_radio_grup7.checkedRadioButtonId.toString()

                    updatePasien(setPasien)
                }
            }
        })
    }


    private fun isEmpty(s: String): Boolean {
        return TextUtils.isEmpty(s)
    }
    //Menampilkan data yang akan di update
    private val data: Unit
        private get() {
//            val bnewid = jkelgroup.checkedRadioButtonId
//            val bnewradioButton = findViewById(bnewid) as RadioButton
//Menampilkan data dari item yang dipilih sebelumnya
            val getNama = intent.extras!!.getString("dataNama")
            val getJkel = intent.extras!!.getInt("dataJeniskelamin")
            val getTglLahir = intent.extras!!.getString("dataTglLahir")
            val getNomorHp = intent.extras!!.getString("dataNomorHp")
            val getAlamat = intent.extras!!.getString("dataAlamat")
            val getEmail = intent.extras!!.getString("dataEmail")
            val getJadwal= intent.extras!!.getString("dataJadwal")

            //val getJam = intent.extras!!.getString("dataJam")
//            val getRadioButton1 = intent.extras!!.getString("dataRadioButton1")
//            val getRadioButton2 = intent.extras!!.getString("dataRadioButton2")
//            val getRadioButton3 = intent.extras!!.getString("dataRadioButton3")
//            val getRadioButton4 = intent.extras!!.getString("dataRadioButton4")
//            val getRadioButton5 = intent.extras!!.getString("dataRadioButton5")
//            val getRadioButton6 = intent.extras!!.getString("dataRadioButton6")
//            val getRadioButton7 = intent.extras!!.getString("dataRadioButton7")
            new_nama!!.setText(getNama)
//            new_jkelgroup!!.setText("dataJeinskelamin", onOptionsItemSelected())
            new_ttl!!.setText(getTglLahir)
            new_nomorhp!!.setText(getNomorHp)
            new_alamat!!.setText(getAlamat)
            new_email!!.setText(getEmail)
            new_pilihjadwal!!.setText(getJadwal)
//            new_jkel!!.
//            new_radio_grup1!!.checkedRadioButtonId(getRadioButton1)
//            new_radio_grup2!!.checkedRadioButtonId(getRadioButton2)
//            new_radio_grup3!!.checkedRadioButtonId(getRadioButton3)
//            new_radio_grup4!!.setText(getRadioButton4)
//            new_radio_grup5!!.setText(getRadioButton5)
//            new_radio_grup6!!.setText(getRadioButton6)
//            new_radio_grup7!!.setText(getRadioButton7)
            //new_jam!!.selectedItemId(getJam)

        }
    //Proses Update data yang sudah ditentukan
    private fun updatePasien(pasien: data_pasien) {


        val userID = auth!!.uid
        val getKey = intent.extras!!.getString("getPrimaryKey")
        database!!.child("Admin")
            .child(userID!!)
            .child("Pasien")
            .child(getKey!!)
            .setValue(pasien)
            .addOnSuccessListener {
                new_nama!!.setText("")
                new_ttl!!.setText("")
                new_nomorhp!!.setText("")
                new_alamat!!.setText("")
                new_email!!.setText("")
                new_pilihjadwal!!.setText("")


//                new_radio_grup1!!.setText("")
//                new_radio_grup2!!.setText("")
//                new_radio_grup3!!.setText("")
//                new_radio_grup4!!.setText("")
//                new_radio_grup5!!.setText("")
//                new_radio_grup6!!.setText("")
//                new_radio_grup7!!.setText("")
                Toast.makeText(this@UpdateData, "Data Berhasil diubah", Toast.LENGTH_SHORT).show()
                finish()
            }
    }
}







//    //Deklarasi Variable

//    private  var cekJam: String? = null
////    private var cekRadioGroup1: String? = null
////    private var cekRadioGroup2: String? = null
////    private var cekRadioGroup3: String? = null
////    private var cekRadioGroup4: String? = null
////    private var cekRadioGroup5: String? = null
////    private var cekRadioGroup6: String? = null
////    private var cekRadioGroup7: String? = null

//

////                cekRadioGroup1 = new_radio_grup1.checkedRadioButtonId.toString()
////                cekRadioGroup2 = new_radio_grup2.checkedRadioButtonId.toString()
////                cekRadioGroup3 = new_radio_grup3.checkedRadioButtonId.toString()
////                cekRadioGroup4 = new_radio_grup4.checkedRadioButtonId.toString()
////                cekRadioGroup5 = new_radio_grup5.checkedRadioButtonId.toString()
////                cekRadioGroup6 = new_radio_grup6.checkedRadioButtonId.toString()
////                cekRadioGroup7 = new_radio_grup7.checkedRadioButtonId.toString()
//                cekJam = new_jam.selectedItemId.toString()

//    }
//    // Mengecek apakah ada data yang kosong, sebelum diupdate

