package com.cmps312.spinthewheel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {
    var choices = arrayListOf<String>("Ali", "Omar", "Mohamed")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        addNameBtn.setOnClickListener {
            choices.add(choiceEdt.text.toString())
        }
        randomSpinBtn.setOnClickListener {
            var r = Random()
            var winner = choices[r.nextInt().absoluteValue.rem(choices.size)]

            choiceDisplayTv.text = "Winner is $winner"
        }

    }
}