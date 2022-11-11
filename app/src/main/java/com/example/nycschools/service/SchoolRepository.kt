package com.example.nycschools.service

import com.example.nycschools.model.School
import javax.inject.Inject

class SchoolRepository @Inject constructor(private val schoolService: SchoolService) {
    suspend fun getSchoolList(): List<School> {
        return schoolService.getSchoolList()
    }
}
