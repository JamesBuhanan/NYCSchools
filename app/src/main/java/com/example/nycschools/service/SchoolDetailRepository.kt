package com.example.nycschools.service

import com.example.nycschools.model.SchoolDetail
import javax.inject.Inject

interface SchoolDetailRepository {
    suspend fun getSchoolDetail(dbn: String): Result<SchoolDetail>
}

class SchoolDetailRepositoryImpl @Inject constructor(
    private val schoolService: SchoolService
) : SchoolDetailRepository {
    override suspend fun getSchoolDetail(dbn: String): Result<SchoolDetail> {
        return try {
            val schoolDetail = schoolService.getSchoolDetails().first { it.dbn == dbn }
            Result.success(schoolDetail)
        } catch (ex: Exception) {
            Result.failure(ex)
        }
    }
}