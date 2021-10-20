package com.pangolin.collegedashboard.ui.pomodoro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PomodoroViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is pomodoro Fragment"
    }
    val text: LiveData<String> = _text

}