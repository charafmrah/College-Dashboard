package com.pangolin.collegedashboard.ui.classesschedule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClassScheduleViewModel : ViewModel() {

        private val _text = MutableLiveData<String>().apply {
            value = "This is classchedule Fragment"
        }
        val text: LiveData<String> = _text

}

