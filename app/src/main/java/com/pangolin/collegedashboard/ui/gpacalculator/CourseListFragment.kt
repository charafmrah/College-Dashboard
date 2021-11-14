/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pangolin.collegedashboard.ui.gpacalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pangolin.collegedashboard.ui.gpacalculator.CalculatorApplication
import com.pangolin.collegedashboard.R
import com.pangolin.collegedashboard.adapter.CourseListAdapter
import com.pangolin.collegedashboard.databinding.FragmentGpaCalculatorCourseListBinding
import com.pangolin.collegedashboard.ui.gpacalculator.GpaCalculatorViewModel
import com.pangolin.collegedashboard.ui.gpacalculator.GpaCalculatorViewModelFactory

// Main fragment displaying details for all courses in the database
class CourseListFragment : Fragment() {

    private var _binding: FragmentGpaCalculatorCourseListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: GpaCalculatorViewModel by activityViewModels {
        GpaCalculatorViewModelFactory(
            (activity?.application as CalculatorApplication).database.courseDao()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGpaCalculatorCourseListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CourseListAdapter {
            val action =
                CourseListFragmentDirections.actionCourseListFragmentToCourseDetailFragment(it.id)
            this.findNavController().navigate(action)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerView.adapter = adapter

        // Attach an observer on the allCourses list to update the  UI automatically when
        // the data changes
        viewModel.allCourses.observe(this.viewLifecycleOwner) { courses ->
            courses.let {
                adapter.submitList(it)

            }
            binding.gpaResult.text = viewModel.calculateGpa().toString()
        }

        binding.floatingActionButton.setOnClickListener {
            val action = CourseListFragmentDirections.actionCourseListFragmentToAddCourseFragment(
                getString(R.string.add_fragment_title)
            )
            this.findNavController().navigate(action)
        }


    }

}