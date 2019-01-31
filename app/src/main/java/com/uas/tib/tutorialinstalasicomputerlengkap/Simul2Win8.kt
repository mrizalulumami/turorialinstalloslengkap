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

class Simul2Win8 : AppCompatActivity() {
    lateinit var Change:Button
    private var imageModel3ArrayList: ArrayList<ImageModel3>? = null

    private val myImageList3 = intArrayOf(
        R.drawable.win81, R.drawable.win82,
        R.drawable.win83, R.drawable.win84,
        R.drawable.win85,R.drawable.win86,
        R.drawable.win87, R.drawable.win88,
        R.drawable.win89, R.drawable.win810,
        R.drawable.win811,R.drawable.win812,
        R.drawable.win813, R.drawable.win814,
        R.drawable.win815, R.drawable.win816,
        R.drawable.win817,R.drawable.win818,
        R.drawable.win819, R.drawable.win820,
        R.drawable.win821, R.drawable.win822,
        R.drawable.win823)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.simul2_win8_layout)
        Change = findViewById(R.id.next2)
        Change.setOnClickListener {
            startActivity(Intent(this,Windows8_class::class.java))
            super.finish()
        }
        //untuk image slider
        imageModel3ArrayList = ArrayList()
        imageModel3ArrayList = populateList()

        init()

    }

    private fun populateList(): ArrayList<ImageModel3> {

        val list = ArrayList<ImageModel3>()

        for (i in 0..22) {
            val imageModel3 = ImageModel3()
            imageModel3.setImage_drawables(myImageList3[i])
            list.add(imageModel3)
        }

        return list
    }

    private fun init() {

        mPager = findViewById(R.id.pager2) as ViewPager
        mPager!!.adapter = SlidingImage_adafter3(this@Simul2Win8,this.imageModel3ArrayList!!)

        //Set circle indicator radius

        NUM_PAGES = imageModel3ArrayList!!.size

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
