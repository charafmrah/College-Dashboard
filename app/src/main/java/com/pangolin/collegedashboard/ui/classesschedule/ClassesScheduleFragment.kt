package com.pangolin.collegedashboard.ui.classesschedule


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pangolin.collegedashboard.databinding.FragmentClassesScheduleBinding

class ClassScheduleFragment : Fragment() {

    private lateinit var classScheduleViewModel: ClassScheduleViewModel
    private var _binding: FragmentClassesScheduleBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        classScheduleViewModel =
            ViewModelProvider(this).get(ClassScheduleViewModel::class.java)

        _binding = FragmentClassesScheduleBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}