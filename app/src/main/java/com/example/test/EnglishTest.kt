package com.example.test

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_math_test.*
import lecho.lib.hellocharts.model.PieChartData
import lecho.lib.hellocharts.model.SliceValue


class EnglishTest : AppCompatActivity(), View.OnClickListener {
    var tests = arrayListOf<Test>()
    var index = 0
    var numberOfIncorrectAnswers: Int = 0
    var numberOfCorrectAnswers: Int = 0
    var count: Boolean = false
    var pieData = ArrayList<SliceValue>()
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_test)
        tests.add(Test("What is the definition of 'mother'", "person who give a birth to someone", "doctor who treats everyone", "a person who teaches to maths", "a sister of someone", "person who give a birth to someone"))
        tests.add(Test("What is the definition of 'sister'", "a girl who is the closest relative to someone", "doctor who treats everyone", "a person who teaches to maths", "a sister of someone", "person who give a birth to someone"))
        tests.add(Test("What is the definition of 'brother'", "person who give a birth to someone", "a boy who is the closest relative to someone", "a person who teaches to maths", "a sister of someone", "person who give a birth to someone"))
        tests.add(Test("What is the definition of 'uncle'", "person who give a birth to someone", "doctor who treats everyone", "a person who teaches to maths", "a sister of someone", "person who give a birth to someone"))
        tests.add(Test("What is the definition of 'father'", "person who give a birth to someone", "doctor who treats everyone", "a person who teaches to maths", "a sister of someone", "person who give a birth to someone"))
        createNumber(tests.size)
        createTest(index)

        next.setOnClickListener {
            val checkedRadioButtonId = answers.checkedRadioButtonId
            tests[index].chosenAnswerIndex = checkedRadioButtonId
            if (index == tests.size - 2) {
                next.text = "Finish"
            }
            if (index == tests.size - 1) {
                questions.visibility = View.GONE
                result.visibility = View.VISIBLE
                pieData.add(SliceValue(numberOfCorrectAnswers.toFloat(), Color.GREEN))
                pieData.add(SliceValue(numberOfIncorrectAnswers.toFloat(), Color.RED))
                var pieChartData = PieChartData(pieData)
                container.setBackgroundResource(R.drawable.wallpaper)
                chart.pieChartData = pieChartData;
                score.text = "${numberOfCorrectAnswers} out of ${tests.size}"
            }
            var TOAST_LENGTH = 50
            check()
            if (checkedRadioButtonId != -1){
                tests[index].status = true
                if (index<tests.size-1){
                    index++
                }
                createTest(index)

                answers.clearCheck()
            }else {
                Toast.makeText(this,"Tanlanmagan", TOAST_LENGTH).show()
            }

        }

    }

    fun createTest(n:Int){
        var test = tests[n]
        question.text = test.question
        answer_1.text = test.answer1
        answer_2.text = test.answer2
        answer_3.text = test.answer3
        answer_4.text = test.answer4
        if (tests[n].status) {
            var radioButton = findViewById<RadioButton>(tests[n].chosenAnswerIndex)
            radioButton.isChecked = true
        } else {
            answers.clearCheck()
        }
    }

    @SuppressLint("ResourceAsColor")
    fun createNumber(n:Int){
        for (i in 0 until n){
            var btn = Button(this)
            btn.id = i
            btn.text ="${i+1}"
            btn.tag = "$i"
            val param = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1.0f
            )
            btn.setLayoutParams(param)
            if (!tests[i].status){
                btn.setBackgroundColor(R.color.purple_700)
                btn.setTextColor(Color.WHITE)
            }
            btn.setOnClickListener(this)
            questions_number.addView(btn)
        }
    }

    override fun onClick(p0: View?) {
        var btn = findViewById<Button>(p0!!.id)
        check()
        index = btn.tag.toString().toInt()
        if (index == tests.size - 1) {
            next.text = "Finish"
        } else {
            next.text = "next"
        }

        createTest(index)
        createNumber(tests.size)
    }
    private fun check() {
        if (answers.checkedRadioButtonId != -1) {
            tests[index].status = true
            tests[index].chosenAnswerIndex = answers.checkedRadioButtonId

            var radioButton = findViewById<RadioButton>(tests[index].chosenAnswerIndex)
            var chosenVariantText = radioButton.text

            if (chosenVariantText.equals(tests[index].correct_answer) && !count && index <= tests.size - 1) {
                if (index == tests.size - 1) {
                    count = true
                }
                numberOfCorrectAnswers++
            }
            Log.d("correct answers -> ", numberOfCorrectAnswers.toString())
            numberOfIncorrectAnswers = tests.size-numberOfCorrectAnswers

        }
    }
}