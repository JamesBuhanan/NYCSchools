package com.example.nycschools.service

import com.example.nycschools.model.School
import javax.inject.Inject

class SchoolRepository @Inject constructor(private val schoolService: SchoolService) {
    var schoolList: List<School>? = null
    suspend fun getSchoolList(): Result<List<School>> {
        return try {
            if (schoolList == null) {
                schoolList = schoolService.getSchoolList().sortedBy { it.schoolName }
            }
            Result.success(schoolList!!)
        } catch (ex: Exception) {
            Result.failure(ex)
        }
    }
}
