package com.example.nycschools.ui.schooldetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                "${it.schoolName}",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.Blue,
            )
            Text(
                "- SAT Statistics -",
                fontSize = 22.sp,
                modifier = Modifier.padding(8.dp),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Text(
                "Number of SAT's taken:",
                fontSize = 22.sp,
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Center,
            )
            Text(
                "[${it.satTakers}]",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Text(
                "Average Critical Reading SAT score:",
                fontSize = 22.sp,
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Center,
            )
            Text(
                "[${it.satReading}]",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Text(
                "Average Math SAT score:",
                fontSize = 22.sp,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                "[${it.satMath}]",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Text(
                "Average Writing SAT score:",
                fontSize = 22.sp,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                "[${it.satWriting}]",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        }


    }
}