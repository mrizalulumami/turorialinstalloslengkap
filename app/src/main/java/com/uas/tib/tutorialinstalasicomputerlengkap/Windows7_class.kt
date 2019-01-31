package com.uas.tib.tutorialinstalasicomputerlengkap

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Windows7_class : AppCompatActivity() {
    lateinit var Langkhh7:ImageButton
    lateinit var Simull7:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.windows7_layout)
        Langkhh7=findViewById(R.id.langkh7)
        Simull7=findViewById(R.id.simuls7)
        Langkhh7.setOnClickListener {
            startActivity(Intent(this,Langkah2Win7::class.java))
        }
        Simull7.setOnClickListener {
            startActivity(Intent(this,Simul2Win7::class.java))
        }
    }
}
