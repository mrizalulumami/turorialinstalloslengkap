package com.uas.tib.tutorialinstalasicomputerlengkap

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Windows10_class : AppCompatActivity() {
    lateinit var Langkah10: ImageButton
    lateinit var Simul10: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.windows10_layout)
        Langkah10=findViewById(R.id.langkh7)
        Simul10=findViewById(R.id.simuls7)
        Langkah10.setOnClickListener {
            startActivity(Intent(this,Langkah2Win10::class.java))
        }
        Simul10.setOnClickListener {
            startActivity(Intent(this,Simul2Win10::class.java))
        }
    }
}
