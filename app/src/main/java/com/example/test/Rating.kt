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

class Rating : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView (R.layout.activity_rating)
        val users = getUser()
        if (users.size-1 < 5 ){
            createUser(users.size-1, users as MutableList<ModelClass>)
        }else {
            createUser(5, users as MutableList<ModelClass>)
        }
    }

    fun createUser(n: Int, users: MutableList<ModelClass>) {
        for (i in 0 until n) {
            var name = TextView(this)
            name.id = i
            name.text ="${users[i].name}"
            name.tag = "$i"
            val param = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1.0f
            )
            name.setLayoutParams(param)
            var score = TextView(this)
            score.id = i
            score.text ="${users[i].score}"
            score.tag = "$i"
            score.textAlignment = View.TEXT_ALIGNMENT_TEXT_END
            val param1 = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1.0f
            )
            score.setLayoutParams(param1)
            result_box.addView(score)
        }
    }
    private fun getUser():List<ModelClass> {
        var userList = mutableListOf<ModelClass>()
        var sharedPreferences = getSharedPreferences("reg", MODE_PRIVATE)
        var gson = Gson()
        var type = object : TypeToken<List<ModelClass>>() {}.type
        var users = sharedPreferences.getString("users","")
        userList = gson.fromJson(users,type)
        return userList
    }
}