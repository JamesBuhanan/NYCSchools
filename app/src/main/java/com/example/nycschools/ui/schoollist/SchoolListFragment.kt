package com.example.nycschools.ui.schoollist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nycschools.R

class SchoolListFragment : Fragment() {

    companion object {
        fun newInstance() = SchoolListFragment()
    }

    private lateinit var viewModel: SchoolListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_school_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SchoolListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}