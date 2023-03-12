package com.example.test
import android.graphics.Color
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.Display.Mode
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_math_test.*
import kotlinx.android.synthetic.main.activity_rating.*
import kotlin.properties.Delegates

class Rating : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView (R.layout.activity_rating)
        createUser()
    }

    fun createUser() {
        var sharedPreferences = getSharedPreferences("reg", MODE_PRIVATE)
        var name = sharedPreferences.getString("name","")
        var score = sharedPreferences.getString("score","")
        var i =0
        var name_v = findViewById<TextView>(R.id.name)
        var score_v = findViewById<TextView>(R.id.score)
        name_v.text ="${name}"
        score_v.text = "${score}"
    }
}