package com.example.test

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_math_test.*

class Rating : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)
    }
    fun createUser(n:Int){
        for (i in 0 until n){

            var layout = LinearLayout(this)
            layout.weightSum = 3f
        }
    }
}