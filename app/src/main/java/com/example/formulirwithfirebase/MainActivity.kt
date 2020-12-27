package com.example.formulirwithfirebase


import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.TableLayout
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.formulirwithfirebase.adapter.OnBoardingViewPagerAdapter
import com.example.formulirwithfirebase.model.OnBoardingData
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.onboarding_screen_layout.*



class MainActivity : AppCompatActivity() {

    var onBoardingViewPagerAdapter: OnBoardingViewPagerAdapter? = null
    var tabLayout: TabLayout? = null
    var onBoardingViewPager : ViewPager? = null
    var next: TextView? = null
    var position = 0
    var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        if (restorePrefData()){
            val i = Intent(applicationContext, LoginActivity::class.java)
            startActivity(i)
            finish()
        }

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tab_indicator)
        next = findViewById(R.id.next)
        


        val onBoardingData:MutableList<OnBoardingData> = ArrayList()
        onBoardingData.add(OnBoardingData("Bekerja Dari Rumah","Tetap bekerja dari rumah untuk mencegah penyebaran virus dan selalu jaga kesehatan Anda.", R.drawable.working))
        onBoardingData.add(OnBoardingData("Infeksi Virus","Gunakan masker jika ingin keluar rumah selalu jaga jarak dengan orang lain dan jangan lupa untuk mengganti masker Anda.", R.drawable.masker))
        onBoardingData.add(OnBoardingData("Jaga Kesehatan","Selalu jaga daya tahan tubuh Anda untuk selalu sehat dan bugar. Ingat selalu untuk berolahraga walau berkerja Dari Rumah.", R.drawable.health))

        setOnBoardingViewPagerAdapter(onBoardingData)

        position = onBoardingViewPager!!.currentItem

        next?.setOnClickListener {
            if (position < onBoardingData.size) {
                position++
                onBoardingViewPager!!.currentItem = position
            }

            if(position == onBoardingData.size){
                savePrefData()
                val i = Intent(applicationContext, LoginActivity::class.java)
                startActivity(i)
                finish()
            }
        }


        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                position = tab!!.position
                if (tab.position == onBoardingData.size - 1) {
                    next!!.text = "Mulai"
                } else {
                    next!!.text = "Lanjut"
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

    private fun setOnBoardingViewPagerAdapter(onBoardingData: List<OnBoardingData>){

        onBoardingViewPager = findViewById(R.id.screenPager)
        onBoardingViewPagerAdapter = OnBoardingViewPagerAdapter(this, onBoardingData)
        onBoardingViewPager!!.adapter = onBoardingViewPagerAdapter
        tabLayout?.setupWithViewPager(onBoardingViewPager)
    }

    private fun savePrefData(){
        sharedPreferences = applicationContext.getSharedPreferences("pref", MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPreferences!!.edit()
        editor.putBoolean("isFirstTimeRun", true)
        editor.apply()
    }

    private fun restorePrefData(): Boolean{
        sharedPreferences = applicationContext.getSharedPreferences("pref", MODE_PRIVATE)
        return sharedPreferences!!.getBoolean("isFirstTimeRun", false)
    }
}





