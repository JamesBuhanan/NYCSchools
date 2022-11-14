package com.example.nycschools.ui.schoollist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.nycschools.model.School
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SchoolListFragment : Fragment() {

    private val viewModel: SchoolListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                SchoolList(
                    schools = viewModel.schoolList.value,
                    error = viewModel.error.value,
                    onClick = {
                        NavHostFragment.findNavController(this@SchoolListFragment).navigate(
                            SchoolListFragmentDirections.actionSchoolListFragmentToSchoolDetailFragment(
                                it
                            )
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun SchoolList(
    schools: List<School> = listOf(),
    error: String? = null,
    onClick: (String) -> Unit = {},
) {
    error?.let {
        Text(it)
    }
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color.Black)
    ) {
        items(schools) {
            SchoolListItem(it, onClick)
        }
    }
}

@Composable
fun SchoolListItem(
    school: School,
    onClick: (String) -> Unit = {}
) {
    Card(
        border = BorderStroke(2.dp, Color.Black),
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                onClick(school.dbn)
            }
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = school.schoolName,
                fontSize = 18.sp,
                color = Color.Blue,
                textAlign = TextAlign.Center,
            )
            Text(school.primaryAddressLine1)
            Text(school.city + ", " + school.state)
        }
    }
}