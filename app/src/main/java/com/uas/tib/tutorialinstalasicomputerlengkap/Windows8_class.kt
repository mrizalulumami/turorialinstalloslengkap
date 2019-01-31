package com.uas.tib.tutorialinstalasicomputerlengkap

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Windows8_class : AppCompatActivity() {
    lateinit var Langkah8:ImageButton
    lateinit var Simul8:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.windows8_layout)
        Langkah8=findViewById(R.id.langkh7)
        Simul8=findViewById(R.id.simuls7)
        Langkah8.setOnClickListener {
            startActivity(Intent(this,Langkah2Win8::class.java))
        }
        Simul8.setOnClickListener {
            startActivity(Intent(this,Simul2Win8::class.java))
        }
    }
}
