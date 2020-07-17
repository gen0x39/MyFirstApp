package com.example.myfirstapp

import android.app.DatePickerDialog
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
// need to import for Kotlin Android Extensions
import kotlinx.android.synthetic.main.activity_main.*

import java.util.Locale

class MainActivity : FragmentActivity(), DatePickerDialog.OnDateSetListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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