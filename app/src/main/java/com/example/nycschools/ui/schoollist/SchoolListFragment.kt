package com.example.nycschools.ui.schoollist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.nycschools.model.School
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SchoolListFragment : Fragment() {

    private val viewModel: SchoolListViewModel by viewModels()

    companion object {
        fun newInstance() = SchoolListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Thing(viewModel.schoolList.value)
            }
        }
    }
}

@Composable
fun Thing(schools: List<School>) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,


        ) {
        items(schools) {
            Text(
                text = it.schoolName,
                fontSize = 18.sp,
                modifier = Modifier.padding(12.dp),
                color = Color.Blue,
                textAlign = TextAlign.Center
            )
        }
    }
}