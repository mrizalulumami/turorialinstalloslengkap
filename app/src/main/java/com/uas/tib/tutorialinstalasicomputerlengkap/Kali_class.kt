package com.uas.tib.tutorialinstalasicomputerlengkap

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Kali_class : AppCompatActivity() {
    lateinit var LangkahKal:ImageButton
    lateinit var Simulkali:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kali_layout)
        LangkahKal=findViewById(R.id.langkh7)
        Simulkali=findViewById(R.id.simuls7)
        LangkahKal.setOnClickListener {
            startActivity(Intent(this,Langkah2Kali::class.java))
        }
        Simulkali.setOnClickListener {
            startActivity(Intent(this,Simul2Kali::class.java))
        }
    }
}
