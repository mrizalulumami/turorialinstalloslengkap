package com.uas.tib.tutorialinstalasicomputerlengkap

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Ubuntu_class : AppCompatActivity() {
    lateinit var Langkhubun:ImageButton
    lateinit var Simulubuntu:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ubuntu_layout)
        Langkhubun=findViewById(R.id.langkh7)
        Simulubuntu=findViewById(R.id.simuls7)
        Langkhubun.setOnClickListener {
            startActivity(Intent(this,Langkah2Ubun::class.java))
        }
        Simulubuntu.setOnClickListener {
            startActivity(Intent(this,Simul2Ubun::class.java))
        }
    }
}
