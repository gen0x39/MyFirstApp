package com.example.myfirstapp

// need to import for Kotlin Android Extensions

import android.animation.ObjectAnimator
import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.DatePicker
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 水平プログレスバーの最大値
        var percent = 0
        ProgressBarHorizontal.max = 100
        ProgressBarHorizontal.progress = percent

        button.setOnClickListener {
            percent += 25
            onProgressChanged(percent)
        }
    }

    // Progress Bar のアニメーション部分
    private fun onProgressChanged(percentage: Int) {
        var animation = ObjectAnimator.ofInt(ProgressBarHorizontal, "progress", percentage)
        animation.duration = 500
        animation.interpolator = DecelerateInterpolator()
        animation.start()
    }


    override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        val str = String.format(Locale.US, "%d/%d/%d", year, monthOfYear+1, dayOfMonth)
        textView.text = str
    }
    fun showDatePickerDialog(v: View) {
        val newFragment = DatePick()
        newFragment.show(supportFragmentManager, "datePicker")
    }
}