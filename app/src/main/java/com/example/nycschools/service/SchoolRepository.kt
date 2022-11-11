package com.example.nycschools.service

import com.example.nycschools.model.School
import javax.inject.Inject

class SchoolRepository @Inject constructor(private val schoolService: SchoolService) {
    suspend fun getSchoolList(): Result<List<School>> {
        return try {
            val schoolList = schoolService.getSchoolList()
            Result.success(schoolList)
        } catch (ex: Exception) {
            Result.failure(ex)
        }
    }
}
