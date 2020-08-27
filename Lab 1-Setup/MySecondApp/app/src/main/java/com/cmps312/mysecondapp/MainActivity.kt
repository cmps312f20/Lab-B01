package com.cmps312.mysecondapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var range = 1..100

        range.forEach(::println)
        range.reduce { acc, i -> acc + i }


        showBtn.setOnClickListener {
            val name = nameEdt.text.toString()
            displayTv.text = "Welcome to CMPS 312 Mr . $name"
        }
    }
}