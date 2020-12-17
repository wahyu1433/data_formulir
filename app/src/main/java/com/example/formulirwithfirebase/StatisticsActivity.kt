package com.example.formulirwithfirebase

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.common.api.Response
import com.lazday.covid_19.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback


class StatisticsActivity : AppCompatActivity() {


    var back: ImageView? = null
    var Positif: TextView? = null
    var Sembuh: TextView? = null
    var Meninggal: TextView? = null
    var ProgressBar: ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)



        Positif = findViewById(R.id.textView12)
        Sembuh = findViewById(R.id.textView18)
        Meninggal = findViewById(R.id.textView14)
        ProgressBar = findViewById(R.id.progresBar)


        back = findViewById(R.id.imageView)

        back?.setOnClickListener{
            val i = Intent(applicationContext, HomeActivity::class.java)
            startActivity(i)
        }
    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    private fun getData(){
        showLoading(true)
        ApiService.endpoint.getData()
                .enqueue(object : Callback<List<MainModel>> {
                    override fun onResponse(
                            call: Call<List<MainModel>>,
                            response: retrofit2.Response<List<MainModel>>
                    ) {
                        showLoading(false)
                        if (response.isSuccessful){
                            val mainModel: List<MainModel> = response.body()!!
                            setResponse(mainModel)
                        }
                    }

                    override fun onFailure(call: Call<List<MainModel>>, t: Throwable) {
                        showLoading(false)
                    }

                })
    }

    private fun setResponse(mainModel: List<MainModel>){


        val response = mainModel[0]
//        val response1 = mainModel[0]
//        val response2 = mainModel[0]
        Positif?.setText("${response.positif}")
        Sembuh?.setText("${response.sembuh}")
        Meninggal?.setText("${response.meninggal}")


    }

    private fun showLoading(loading: Boolean){
        when(loading){
            true -> ProgressBar?.visibility = View.VISIBLE
            false -> ProgressBar?.visibility = View.GONE
        }
    }





}