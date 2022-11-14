package com.example.nycschools.ui.schooldetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.nycschools.model.SchoolDetail
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SchoolDetailFragment : Fragment() {

    private val viewModel: SchoolDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dbn =
            SchoolDetailFragmentArgs.fromBundle(
                requireArguments()
            ).dbn
        viewModel.init(dbn)

        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                Thing(
                    error = viewModel.error.value,
                    schoolDetail = viewModel.schoolDetail.value
                )
            }
        }
    }
}

@Composable
fun Thing(
    error: String?,
    schoolDetail: SchoolDetail?
) {
    error?.let {
        Text(it)
    }
    schoolDetail?.let {
        Column() {
            Text("SAT SCORES!")
            Text("The Average Critcal Reading SAT score = ${it.satReading} ")
            Text("The Average Math SAT score = ${it.satMath} ")
            Text("The Average Writing SAT score = ${it.satWriting} ")
        }


    }
}