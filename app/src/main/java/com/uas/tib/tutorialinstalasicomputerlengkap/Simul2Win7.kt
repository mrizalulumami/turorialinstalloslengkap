package com.uas.tib.tutorialinstalasicomputerlengkap

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.view.ViewPager
import android.widget.Button
import java.util.ArrayList
import java.util.Timer
import java.util.TimerTask

class Simul2Win7 : AppCompatActivity() {
    lateinit var Change:Button
    private var imageModel2ArrayList: ArrayList<ImageModel2>? = null

    private val myImageList2 = intArrayOf(
        R.drawable.win71, R.drawable.win72,
        R.drawable.win73, R.drawable.win74,
        R.drawable.win75,R.drawable.win76,
        R.drawable.win77, R.drawable.win78,
        R.drawable.win79, R.drawable.win710,
        R.drawable.win711,R.drawable.win712,
        R.drawable.win713, R.drawable.win714,
        R.drawable.win715, R.drawable.win716,
        R.drawable.win717,R.drawable.win718,
        R.drawable.win719, R.drawable.win720,
        R.drawable.win721, R.drawable.win722,
        R.drawable.win723,R.drawable.win724,
        R.drawable.win725, R.drawable.win726)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.simul2_win7_layout)
         Change = findViewById(R.id.next)

        Change.setOnClickListener {
            startActivity(Intent(this,Windows7_class::class.java))
            super.finish()
        }
        //untuk image slider
        imageModel2ArrayList = ArrayList()
        imageModel2ArrayList = populateList()

        init()

    }

    private fun populateList(): ArrayList<ImageModel2> {

        val list = ArrayList<ImageModel2>()

        for (i in 0..25) {
            val imageModel2 = ImageModel2()
            imageModel2.setImage_drawables(myImageList2[i])
            list.add(imageModel2)
        }

        return list
    }

    private fun init() {

        mPager = findViewById(R.id.pager1) as ViewPager
        mPager!!.adapter = SlidingImage_Adafter2(this@Simul2Win7,this.imageModel2ArrayList!!)

        //Set circle indicator radius

        NUM_PAGES = imageModel2ArrayList!!.size

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
