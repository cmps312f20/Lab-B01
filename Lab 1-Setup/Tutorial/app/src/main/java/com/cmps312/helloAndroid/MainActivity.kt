package com.cmps312.helloAndroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //we learn how to handle events
        showBtn.setOnClickListener {

            var name = nameEdt.text.toString()
            displayTv.text = "Welcome to cmps 312 Mr. $name"
        }


    }
}