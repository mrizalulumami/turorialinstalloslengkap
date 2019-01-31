package com.uas.tib.tutorialinstalasicomputerlengkap

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.view.ViewPager
import android.widget.Button
import java.util.*

class Simul2Win10 : AppCompatActivity() {
    lateinit var Change: Button
    private var imageModel4ArrayList: ArrayList<ImageModel4>? = null

    private val myImageList4 = intArrayOf(
        R.drawable.win101, R.drawable.win102,
        R.drawable.win103, R.drawable.win104,
        R.drawable.win105,R.drawable.win106,
        R.drawable.win107, R.drawable.win108,
        R.drawable.win109, R.drawable.win1010,
        R.drawable.win1011,R.drawable.win1012,
        R.drawable.win1013, R.drawable.win1014,
        R.drawable.win1015, R.drawable.win1016,
        R.drawable.win1017,R.drawable.win1018,
        R.drawable.win1019, R.drawable.win1020,
        R.drawable.win1021, R.drawable.win1022,
        R.drawable.win1023)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.simul2_win10_layout)
        Change = findViewById(R.id.next3)
        Change.setOnClickListener {
            startActivity(Intent(this,Windows10_class::class.java))
            super.finish()
        }
        //untuk image slider
        imageModel4ArrayList = ArrayList()
        imageModel4ArrayList = populateList()

        init()

    }

    private fun populateList(): ArrayList<ImageModel4> {

        val list = ArrayList<ImageModel4>()

        for (i in 0..22) {
            val imageModel4 = ImageModel4()
            imageModel4.setImage_drawables(myImageList4[i])
            list.add(imageModel4)
        }

        return list
    }

    private fun init() {

        mPager = findViewById(R.id.pager3) as ViewPager
        mPager!!.adapter = SlidingImage_adafter4(this@Simul2Win10,this.imageModel4ArrayList!!)

        //Set circle indicator radius

        NUM_PAGES = imageModel4ArrayList!!.size

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
