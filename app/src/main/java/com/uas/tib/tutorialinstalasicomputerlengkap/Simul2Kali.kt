package com.uas.tib.tutorialinstalasicomputerlengkap

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.view.ViewPager
import android.widget.Button
import java.util.*

class Simul2Kali : AppCompatActivity() {
    lateinit var Change: Button
    private var imageModel6ArrayList: ArrayList<ImageModel6>? = null

    private val myImageList6 = intArrayOf(
        R.drawable.k1, R.drawable.k2,
        R.drawable.k3, R.drawable.k4,
        R.drawable.k5,R.drawable.k6,
        R.drawable.k7, R.drawable.k8,
        R.drawable.k9, R.drawable.k10,
        R.drawable.k11,R.drawable.k12,
        R.drawable.k13, R.drawable.k14,
        R.drawable.k15, R.drawable.k16,
        R.drawable.k17,R.drawable.k18,
        R.drawable.k19, R.drawable.k20,
        R.drawable.k21, R.drawable.k22,
        R.drawable.k23,R.drawable.win724)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.simul2_kali_layout)
        Change = findViewById(R.id.next6)
        Change.setOnClickListener {
            startActivity(Intent(this,Kali_class::class.java))
            super.finish()
        }
        //untuk image slider
        imageModel6ArrayList = ArrayList()
        imageModel6ArrayList = populateList()

        init()

    }

    private fun populateList(): ArrayList<ImageModel6> {

        val list = ArrayList<ImageModel6>()

        for (i in 0..23) {
            val imageModel6 = ImageModel6()
            imageModel6.setImage_drawables(myImageList6[i])
            list.add(imageModel6)
        }

        return list
    }

    private fun init() {

        mPager = findViewById(R.id.pager6) as ViewPager
        mPager!!.adapter = SlidingImage_adafter6(this@Simul2Kali,this.imageModel6ArrayList!!)

        //Set circle indicator radius

        NUM_PAGES = imageModel6ArrayList!!.size

        // Auto start of viewpager
        val handler = Handler()
        val Update = Runnable {
            if (currentPage == NUM_PAGES) {
                currentPage = 0
            }
            mPager!!.setCurrentItem(currentPage++, true)
        }
        val swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(Update)
            }
        }, 8000,8000)
    }

    companion object {

        private var mPager: ViewPager? = null
        private var currentPage = 0
        private var NUM_PAGES = 0
    }
}
