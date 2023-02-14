package com.example.test

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed(Runnable {
            val i = Intent(this@MainActivity, RegistrationActivity::class.java)
            startActivity(i)
            finish()
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