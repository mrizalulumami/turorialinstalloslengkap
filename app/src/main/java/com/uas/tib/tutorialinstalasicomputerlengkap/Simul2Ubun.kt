package com.uas.tib.tutorialinstalasicomputerlengkap

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.view.ViewPager
import android.widget.Button
import java.util.*

class Simul2Ubun : AppCompatActivity() {
    lateinit var Change: Button
    private var imageModel5ArrayList: ArrayList<ImageModel5>? = null

    private val myImageList5 = intArrayOf(
        R.drawable.u1, R.drawable.u2,
        R.drawable.u3, R.drawable.u4,
        R.drawable.u5,R.drawable.u6,
        R.drawable.u7, R.drawable.u8,
        R.drawable.u9, R.drawable.u10,
        R.drawable.u11,R.drawable.u12,
        R.drawable.u13)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.simul2_ubun_layout)
        Change = findViewById(R.id.next5)
        Change.setOnClickListener {
            startActivity(Intent(this,Ubuntu_class::class.java))
            super.finish()
        }
        //untuk image slider
        imageModel5ArrayList = ArrayList()
        imageModel5ArrayList = populateList()

        init()

    }

    private fun populateList(): ArrayList<ImageModel5> {

        val list = ArrayList<ImageModel5>()

        for (i in 0..12) {
            val imageModel5 = ImageModel5()
            imageModel5.setImage_drawables(myImageList5[i])
            list.add(imageModel5)
        }

        return list
    }

    private fun init() {

        mPager = findViewById(R.id.pager5) as ViewPager
        mPager!!.adapter = SlidingImage_adafter5(this@Simul2Ubun,this.imageModel5ArrayList!!)

        //Set circle indicator radius

        NUM_PAGES = imageModel5ArrayList!!.size

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
