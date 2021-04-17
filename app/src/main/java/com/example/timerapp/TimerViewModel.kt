package com.example.timerapp

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log
import android.widget.Toast

class TimerViewModel() : ViewModel() {
    private val  _currentTime = MutableLiveData<Long>()
    val currentTime: LiveData<Long>
        get() = _currentTime
    private lateinit var timer : CountDownTimer
    var _time = MutableLiveData<Long>()
    val time : LiveData<Long>
        get() = _time


    init {
        _time.value = 0L
     }

    public fun startTimer(){
        var COUNTDOWN_TIME = _time.value!!

        timer = object : CountDownTimer(COUNTDOWN_TIME * 1000L , 1000L) {

            override fun onTick(millisUntilFinished: Long) {
                _currentTime.value = (millisUntilFinished / 1000L)
            }

            override fun onFinish() {


            }


        }
        timer.start()
    }
    fun canceltimer(){
        timer.cancel()
        _currentTime.value = 0L

    }

    

}