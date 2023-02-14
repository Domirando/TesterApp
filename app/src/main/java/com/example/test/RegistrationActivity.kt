package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.view.View
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        register.setOnClickListener {
            val data = arrayListOf(name.text, email.text, username.text, password.text, checkbox.isChecked)
            if (name.text.isEmpty() || email.text.isEmpty() || username.text.isEmpty() || password.text.isEmpty())
                note.visibility = View.VISIBLE
            else {
                form.visibility = View.INVISIBLE
                subjects.visibility = View.VISIBLE
                title_name.text = name.text
            }
        }
        math.setOnClickListener {
            val i = Intent(this, MathTest::class.java)
            startActivity(i)
        }
        english.setOnClickListener {
            val i = Intent(this, EnglishTest::class.java)
            startActivity(i)
        }
        physics.setOnClickListener {
            val i = Intent(this, EnglishTest::class.java)
            startActivity(i)
        }
    }
}