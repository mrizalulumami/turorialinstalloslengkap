package com.uas.tib.tutorialinstalasicomputerlengkap

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Handler
import android.support.v4.view.ViewPager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import java.util.ArrayList
import java.util.Timer
import java.util.TimerTask

class HomeMenu : AppCompatActivity() {
    lateinit var Facebook:ImageButton
    lateinit var Watsapp:ImageButton
    lateinit var Twitter:ImageButton
    lateinit var uriString1:String
    lateinit var uriString2:String
    lateinit var uriString3:String
    var hasPackage1:Boolean=false
    var hasPackage2:Boolean=false
    var hasPackage3:Boolean=false

    lateinit var Wind7:ImageButton
    lateinit var Wind8:ImageButton
    lateinit var Wind10:ImageButton
    lateinit var Ubuntu:ImageButton
    lateinit var Kali:ImageButton
    lateinit var About:ImageButton

    private var imageModel1ArrayList: ArrayList<ImageModel1>? = null

    private val myImageList = intArrayOf(
        R.drawable.instalasi1, R.drawable.install2,
        R.drawable.komputer1, R.drawable.komputer2,
        R.drawable.komputer4, R.drawable.komputer5,
        R.drawable.komputer6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_menu)

        Facebook=findViewById(R.id.fcbk)
        Watsapp=findViewById(R.id.wa)
        Twitter=findViewById(R.id.twit)

        hasPackage1=checkFacebookPackage(this@HomeMenu,"m.facebook.com")
        hasPackage2=checWhatsappPackage(this@HomeMenu,"com.whatsapp")
        hasPackage3=checTwitterPackage(this@HomeMenu,"com.twitter.android")

        Facebook.setOnClickListener {
            if(hasPackage1){
                Toast.makeText(applicationContext,"Facebook is installed...",Toast.LENGTH_LONG).show()
                val intent=Intent(Intent.ACTION_SEND)
                intent.type="text/plain"

                uriString1="learn to install OS using Turorial Instalasi OS lengkap"

                intent.putExtra(Intent.EXTRA_TEXT,uriString1)

                intent.`package`="com.facebook.katana"

                startActivity(intent)
            }
            else{
                Toast.makeText(applicationContext,"Facebook not installed...",Toast.LENGTH_LONG).show()
            }

        }
        Twitter.setOnClickListener {
            if(hasPackage3){
                Toast.makeText(applicationContext,"Twitter is installed...",Toast.LENGTH_LONG).show()
                val intent=Intent(Intent.ACTION_SEND)
                intent.type="text/plain"

                uriString3="learn to install OS using Turorial Instalasi OS lengkap"

                intent.putExtra(Intent.EXTRA_TEXT,uriString3)

                intent.`package`="com.twitter.android"

                startActivity(intent)
            }
            else{
                Toast.makeText(applicationContext,"Twitter not installed...",Toast.LENGTH_LONG).show()
            }

        }
        Watsapp.setOnClickListener {
            if(hasPackage2){
                Toast.makeText(applicationContext,"Whatsapp is installed...",Toast.LENGTH_LONG).show()
                val intent=Intent(Intent.ACTION_SEND)
                intent.type="text/plain"

                uriString2="learn to install OS using Turorial Instalasi OS lengkap"

                intent.putExtra(Intent.EXTRA_TEXT,uriString2)

                intent.`package`="com.whatsapp"

                startActivity(intent)
            }
            else{
                Toast.makeText(applicationContext,"Whatsapp not installed...",Toast.LENGTH_LONG).show()
            }

        }

        //untuk pemindahan kelas lewat tombol
        Wind7=findViewById(R.id.win7)
        Wind8=findViewById(R.id.win8)
        Wind10=findViewById(R.id.win10)
        Ubuntu=findViewById(R.id.ubuntu)
        Kali=findViewById(R.id.kali)
        About=findViewById(R.id.about)

        About.setOnClickListener {
            startActivity(Intent(this,About_class::class.java))
        }
        Wind7.setOnClickListener {
            startActivity(Intent(this,Windows7_class::class.java))
        }
        Wind8.setOnClickListener {
            startActivity(Intent(this,Windows8_class::class.java))
        }
        Wind10.setOnClickListener {
            startActivity(Intent(this,Windows10_class::class.java))
        }
        Ubuntu.setOnClickListener {
            startActivity(Intent(this,Ubuntu_class::class.java))
        }
        Kali.setOnClickListener {
            startActivity(Intent(this,Kali_class::class.java))
        }

        //untuk image slider
        imageModel1ArrayList = ArrayList()
        imageModel1ArrayList = populateList()

        init()

    }

    private fun populateList(): ArrayList<ImageModel1> {

        val list = ArrayList<ImageModel1>()

        for (i in 0..6) {
            val imageModel = ImageModel1()
            imageModel.setImage_drawables(myImageList[i])
            list.add(imageModel)
        }

        return list
    }

    private fun init() {

        mPager = findViewById(R.id.pager) as ViewPager
        mPager!!.adapter = SlidingImage_Adapter1(this@HomeMenu, this.imageModel1ArrayList!!)

        //Set circle indicator radius

        NUM_PAGES = imageModel1ArrayList!!.size

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
        }, 3000, 3000)
    }

    companion object {

        private var mPager: ViewPager? = null
        private var currentPage = 0
        private var NUM_PAGES = 0
    }
    private fun checkFacebookPackage(context: Context, target: String):Boolean{
        val pm=context.packageManager
        try {
            pm.getPackageInfo(target, PackageManager.GET_META_DATA)
        }catch (exp:PackageManager.NameNotFoundException){
            return false
        }
        return true
    }
    private fun checTwitterPackage(context: Context, target: String):Boolean{
        val pm=context.packageManager
        try {
            pm.getPackageInfo(target, PackageManager.GET_META_DATA)
        }catch (exp:PackageManager.NameNotFoundException){
            return false
        }
        return true
    }
    private fun checWhatsappPackage(context: Context, target: String):Boolean{
        val pm=context.packageManager
        try {
            pm.getPackageInfo(target, PackageManager.GET_META_DATA)
        }catch (exp:PackageManager.NameNotFoundException){
            return false
        }
        return true
    }


}
