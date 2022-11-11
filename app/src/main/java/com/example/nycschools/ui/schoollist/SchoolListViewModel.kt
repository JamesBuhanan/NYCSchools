package com.example.nycschools.ui.schoollist

import android.annotation.SuppressLint
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycschools.model.School
import com.example.nycschools.usecase.GetSchoolList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@SuppressLint("NullSafeMutableLiveData")
@HiltViewModel
class SchoolListViewModel @Inject constructor(
    private val getSchoolList: GetSchoolList
) : ViewModel() {
    val schoolList = mutableStateOf<List<School>>(emptyList())

    init {
        viewModelScope.launch {
            schoolList.value = getSchoolList()
        }
    }
}