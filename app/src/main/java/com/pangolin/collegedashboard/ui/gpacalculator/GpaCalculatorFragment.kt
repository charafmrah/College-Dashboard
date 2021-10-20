package com.pangolin.collegedashboard.ui.examcountdown

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pangolin.collegedashboard.databinding.FragmentExamCountdownBinding
import com.pangolin.collegedashboard.databinding.FragmentGpaCalculatorBinding
import com.pangolin.collegedashboard.ui.gpacalculator.GpaCalculatorViewModel


class GpaCalculatorFragment : Fragment() {

    private lateinit var gpaCalculatorViewModel: GpaCalculatorViewModel
    private var _binding: FragmentGpaCalculatorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        gpaCalculatorViewModel =
            ViewModelProvider(this).get(GpaCalculatorViewModel::class.java)

        _binding = FragmentGpaCalculatorBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}