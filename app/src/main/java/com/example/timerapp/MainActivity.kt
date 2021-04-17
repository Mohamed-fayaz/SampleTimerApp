package com.example.timerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProviders
lateinit var viewModel : TimerViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        var timeText = findViewById<TextView>(R.id.TimetextView)
        var timeInput = findViewById<EditText>(R.id.time_edit)
        var timerTime = timeInput.text.toString()
        viewModel = ViewModelProviders.of(this).get(TimerViewModel::class.java)

        viewModel.currentTime.observe(this ,{ newTime->
           timeText.text = DateUtils.formatElapsedTime(newTime)
        })

        var startBtn = findViewById<Button> (R.id.Startbutton)

        startBtn.setOnClickListener(){
            viewModel._time.value = timeInput.text.toString().toLong()
            viewModel.startTimer()
        }

        var resetBtn = findViewById<Button>(R.id.ResetButton)
        resetBtn.setOnClickListener(){

            viewModel.canceltimer()        }




    }
}