package com.uas.tib.tutorialinstalasicomputerlengkap

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var isFragmentOneLoaded=true
    var manager=supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Change=findViewById<Button>(R.id.btn_change)
        ShowFragmentOne()
        Change.setOnClickListener ({
            if (isFragmentOneLoaded){
        ShowFragmentTwo()
            }
            else if(isFragmentOneLoaded){
        ShowFragmentOne()
            }
            else{
            startActivity(Intent(this,HomeMenu::class.java))
                finish()
            }
        })
    }
    fun ShowFragmentOne(){
        val transaction = manager.beginTransaction()
        val fragment=FragmentOne()
        transaction.replace(R.id.fragmentest, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded=true
    }
    fun ShowFragmentTwo(){
        val transaction = manager.beginTransaction()
        val fragment=FragmentTwo()
        transaction.replace(R.id.fragmentest,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded=false
    }
}
