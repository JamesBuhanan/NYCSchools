package com.example.nycschools.ui.schoollist

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
    private val _schoolList = MutableLiveData<List<School>>()
    val schoolList: LiveData<List<School>>
        get() = _schoolList

    init {
        viewModelScope.launch {
            _schoolList.value = getSchoolList()
        }
    }
}