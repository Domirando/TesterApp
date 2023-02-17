package com.example.test
import android.graphics.Color
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_math_test.*
import kotlinx.android.synthetic.main.activity_rating.*

class Rating : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView (R.layout.activity_rating)
        val users = getUser()
        Log.d("users", users.joinToString())
        if (users.size-1 <= 5 ){
            createUser(users.size-1, users)
        }else {
            createUser(5, users)
        }
    }

    fun createUser(n: Int, users_scores: Any) {
        for (i in 0 until n) {
            var btn = Button(this)
            btn.id = i
            btn.text ="${users_scores.toString()}"
            Log.d("btn", btn.text.toString())
            btn.tag = "$i"
            val param = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            btn.setLayoutParams(param)
            result_box.addView(btn)
        }
    }
    private fun getUser():List<ModelClass> {
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val jsonString = preferences.getString("users_scores", null)
        return if(jsonString!=null){
            Gson().fromJson(jsonString)
        } else
            listOf()

    }
}