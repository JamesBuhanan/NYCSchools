package com.example.nycschools.ui.schoollist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycschools.usecase.GetSchoolList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolListViewModel @Inject constructor(
    private val getSchoolList: GetSchoolList
) : ViewModel() {
    // TODO: Implement the ViewModel
    init {
        viewModelScope.launch {
            val schoolList = getSchoolList()
        }

    }
}