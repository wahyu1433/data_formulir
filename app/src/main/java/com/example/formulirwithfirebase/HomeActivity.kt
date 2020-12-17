package com.example.formulirwithfirebase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    var keluar: ImageView? = null
    var stat: Button? = null
    var form: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        keluar = findViewById(R.id.imageView)
        //Keluar
        keluar?.setOnClickListener{
            val popup = PopupMenu(this@HomeActivity, keluar)
            //Inflating the Popup using xml file
            popup.menuInflater.inflate(R.menu.menu_logout, popup.menu)

            popup.setOnMenuItemClickListener({
                if (it.itemId == R.id.keluar) {
                    AuthUI.getInstance()
                            .signOut(this)
                            .addOnCompleteListener(object : OnCompleteListener<Void> {
                                override fun onComplete(p0: Task<Void>) {
                                    Toast.makeText(this@HomeActivity, "Logout Berhasil", Toast.LENGTH_SHORT).show()
                                    intent = Intent(applicationContext,
                                            LoginActivity::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            })
                } else {
                    Toast.makeText(applicationContext, "None", Toast.LENGTH_SHORT).show()
                }
                true
            })

            popup.show()//showing popup menu

        }


        stat = findViewById(R.id.stat)

        stat?.setOnClickListener{
            val i = Intent(applicationContext, StatisticsActivity::class.java)
            startActivity(i)
        }


        form = findViewById(R.id.isi_formulir)

            form?.setOnClickListener{
                val i = Intent(applicationContext, FormulirDataActivity::class.java)
                startActivity(i)
        }
    }








}