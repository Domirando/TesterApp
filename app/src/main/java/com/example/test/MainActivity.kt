package com.example.test

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.scaleMatrix


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed(Runnable {
            // Intent is used to switch from one activity to another.
            val i = Intent(this@MainActivity, SubjectsOption::class.java)
            startActivity(i) // invoke the SecondActivity.
            finish() // the current activity will get finished.
        }, 3000)
        val text = findViewById<ConstraintLayout>(R.id.text)
        text.animate().apply{
            duration = 0
            rotation(270F)
        }.withEndAction {
            text.animate().apply {
                duration = 1000
                rotation(0F)
            }
        }
    }
}