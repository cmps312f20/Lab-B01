package com.cmps312.mysecondapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showbtn.setOnClickListener {
            val name = nameEdt.text.toString().toInt()
            displayTv.text = "Welcome to CMPS 312 Mr . $name"
        }
    }
}