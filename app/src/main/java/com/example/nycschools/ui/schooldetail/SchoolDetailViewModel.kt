package com.example.nycschools.ui.schooldetail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycschools.model.SchoolDetail
import com.example.nycschools.usecase.GetSchoolDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolDetailViewModel @Inject constructor(
    private val getSchoolDetails: GetSchoolDetails
) : ViewModel() {
    val schoolDetail = mutableStateOf<SchoolDetail?>(null)
    val error = mutableStateOf<String?>(null)

    fun init(dbn: String) {
        viewModelScope.launch {
            getSchoolDetails(dbn).fold(
                onSuccess = {
                    schoolDetail.value = it
                    error.value = null
                },
                onFailure = {
                    error.value = it.message
                }
            )
        }
    }
}