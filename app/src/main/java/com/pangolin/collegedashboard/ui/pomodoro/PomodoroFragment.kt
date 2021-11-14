package com.pangolin.collegedashboard.ui.pomodoro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pangolin.collegedashboard.databinding.FragmentPomodoroBinding
import com.pangolin.collegedashboard.ui.pomodoro.PomodoroViewModel

class PomodoroFragment : Fragment() {

    private lateinit var pomodoroViewModel: PomodoroViewModel
    private var _binding: FragmentPomodoroBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pomodoroViewModel =
            ViewModelProvider(this).get(PomodoroViewModel::class.java)

        _binding = FragmentPomodoroBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}